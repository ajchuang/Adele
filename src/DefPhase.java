import java.util.*;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTree;

class DefPhase extends adeleBaseListener {

    ParseTreeProperty<Scope>  scopes    = new ParseTreeProperty<Scope>();
    ParseTreeProperty<Object> values    = new ParseTreeProperty<Object>();
    ParseTreeProperty<Object> usrType   = new ParseTreeProperty<Object>();
    ParseTreeProperty<Type> types       = new ParseTreeProperty<Type>();

    GlobalScope globals;
    Scope currentScope;
    int errcount;

    public DefPhase (SymbolTable symtab) {
        globals = symtab.globals;
        errcount = 0;
    }

    /**************************************************************************/
    /* Utility functions                                                      */
    /**************************************************************************/
    public void setValue (ParseTree node, Object value) {
        values.put (node, value);
    }

    public Object getValue (ParseTree node) {
        return values.get(node);
    }

    public void setType (ParseTree node, Type type) {
        types.put (node, type);
    }

    public Type getType (ParseTree node) {
        return types.get(node);
    }

    public void saveScope (ParserRuleContext ctx, Scope s) {
        scopes.put (ctx, s);
    }

    private void err (int line, String msg) {
        System.err.println ("[ERROR] line " + line + ": " + msg);
        errcount++;
    }

    private void print (String msg) {
        System.err.println ("    [DefPhase] " +  msg);
    }

    /**************************************************************************/
    /* Grammar handler function                                               */
    /**************************************************************************/
    public void enterProg (adeleParser.ProgContext ctx) {
        print ("Phase Started.");
        currentScope = globals;
    }

    public void exitProg (adeleParser.ProgContext ctx) {
        if (errcount > 0) {
            String msg = (errcount == 1) ? "1 error" : errcount + " errors";
            print (msg);
            System.exit(1);
        } else
            print ("Phase Completed. Continue.");
    }

    /* when entering group definition */
    public void enterType_declaration (adeleParser.Type_declarationContext ctx) {
        print ("enterType_declaration:" + ctx.ID ().getText ());
        String symbolName = "group " + ctx.ID ().getText ();
        GroupSymbol gs = (GroupSymbol)currentScope.resolve(symbolName);
        saveScope(ctx, gs);
        currentScope = gs;
    }

    public void exitType_declaration (adeleParser.Type_declarationContext ctx) {

        String typeName = ctx.ID ().getText ();
        print ("exitType_declaration:" + typeName);

        currentScope = currentScope.getEnclosingScope();

        /*
        try {
            GroupSymbol ut = new GroupSymbol (typeName);

            int nChild = ctx.getChildCount ();

            for (int i=0; i<nChild; ++i) {

                ParseTree node = ctx.getChild (i);
                String mType = null, mName = null;

                if (node instanceof adeleParser.Dec_item_primContext) {
                    adeleParser.Dec_item_primContext x = (adeleParser.Dec_item_primContext) node;
                    mType = x.type ().getText ();
                    mName = x.vid.getText ();
                } else if (node instanceof adeleParser.Dec_item_groupContext) {
                    adeleParser.Dec_item_groupContext x = (adeleParser.Dec_item_groupContext) node;
                    mType = x.gid.getText ();
                    mName = x.vid.getText ();
                } else
                    continue;

                if (ut.addField (mType, mName) == false) {
                    throw new IllegalStateException ("illegal type definition");
                }
            }

            print ("" + ut);

        } catch (Exception e) {
            throw new IllegalStateException ("illegal type definition");
        }
        */
    }

    public void enterFunc (adeleParser.FuncContext ctx) {
        String symbolName = "function " + ctx.ID().getText();
        Type type = (Type)getValue(ctx.type());

        FunctionSymbol function =
                (FunctionSymbol)currentScope.resolve(symbolName);
        saveScope (ctx, function);
        currentScope = function;
    }

    public void exitFunc (adeleParser.FuncContext ctx) {
        currentScope = currentScope.getEnclosingScope ();
    }

    public void exitFpItem (adeleParser.FpitemContext ctx) {
        Object right = getValue(ctx.expr());
        setValue(ctx, right);
    }

    /************* declaration *************/
    public void exitVarDecl (adeleParser.VarDeclContext ctx) {
        String name = ctx.ID().getText();
        Type type = getType(ctx.type());
        VariableSymbol var = new VariableSymbol(name, type);
        if (!currentScope.define(var)) {
            err(ctx.start.getLine(),
                    "Variable "+name+" is already defined in "+
                    currentScope.getScopeName());
        }
    }

    public void exitArrayDecl(adeleParser.ArrayDeclContext ctx) {
        Type elementType = getType(ctx.type());

        /* get dimension */
        List<adeleParser.Array_dimenContext> dimensions = ctx.array_dimen();
        int dimen = dimensions.size();

        /* TODO: record and check num in brackets */
        /*
        ArrayType symbolType = new ArrayType(elementType, dimen);
        print(ctx.ID().getText()+" type: "+symbolType.getName());
        print(ctx.ID().getText()+" dimen: " + symbolType.getDimension());
        VariableSymbol vs = new VariableSymbol(ctx.ID().getText(), symbolType);
        currentScope.define(vs);
        */
    }

    /********** expr **********/
    public void exitParenExpr (adeleParser.ParenExprContext ctx) {
        setType(ctx, getType (ctx.expr ()));
    }

    public void exitFuncCall (adeleParser.FuncCallContext ctx) {
       
        String fname = ctx.ID ().getText ();
        Symbol func = currentScope.resolve ("function " + fname);
        FunctionSymbol fs = null;

        /* check if this function is defined */
        if (func == null) {
            err (ctx.start.getLine (), "Undefined function: " + fname);
            setType (ctx, SymbolTable._int);
            return;
        }

        /* check if the symbol is a function */
        if (func instanceof FunctionSymbol)
            fs = (FunctionSymbol)func;
        else {
            err (ctx.start.getLine (), "Symbol " + fname + " is not a function");             
            setType (ctx, SymbolTable._int);
            return;
        }

        /* set the type using function return type */
        setType (ctx, func.getType ()); 
        
        /* TODO: check param type, do this after resolving expr type */
        /*
        Map<String, Symbol> args = fs.getMembers();
        List<adeleParser.FpitemContext> items = ctx.func_plist().fpitem();
        
        for (int i=0; i<items.size(); ++i) {
             adeleParser.FpitemContext pitem = items.get (i);
        }
        */
    }

    public void exitArrayAccess (adeleParser.ArrayAccessContext ctx) {
        String name = ctx.ID ().getText ();
        Symbol s = currentScope.resolve (name);
       
        print ("Accessing array: " + name + ":" + s.getType ());

        if (s != null) {
            setType (ctx, s.getType ()); 
        } else { 
            err (ctx.start.getLine(), "Unknown array: " + name);
            setType (ctx, SymbolTable._int);
        }
    }

    public void exitMemberVar(adeleParser.MemberVarContext ctx) {
    }

    public void exitMult (adeleParser.MultContext ctx) {

        adeleParser.ExprContext expr_l = ctx.expr (0);
        adeleParser.ExprContext expr_r = ctx.expr (1);

        if (expr_l != null && expr_r != null) {
            int type_l = getType (expr_l).getTypeIndex ();
            int type_r = getType (expr_r).getTypeIndex ();
            Type op = SymbolTable.arithMultiOp[type_l][type_r];

            if (op == null) {
                err (ctx.start.getLine(), "Type does not support arithmatic operation.");
                setType (ctx, SymbolTable._int);
            } else {
                setType (ctx, op);
            }
        } else {
            err (ctx.start.getLine(), "Type does not support arithmatic operation.");
            setType (ctx, SymbolTable._int);
        }
    }
    
    /* @lfred: let's try something */
    public void exitAdd (adeleParser.AddContext ctx) {
   
        adeleParser.ExprContext expr_l = ctx.expr (0);
        adeleParser.ExprContext expr_r = ctx.expr (1);

        if (expr_l != null && expr_r != null) {
            int type_l = getType (expr_l).getTypeIndex ();
            int type_r = getType (expr_r).getTypeIndex ();
            Type op = SymbolTable.arithAddOp[type_l][type_r];

            if (op == null) {
                err (ctx.start.getLine(), "Type does not support arithmatic operation.");
                setType (ctx, SymbolTable._int);
            } else {
                setType (ctx, op);
            }
        } else {
            err (ctx.start.getLine(), "Type does not support arithmatic operation.");
            setType (ctx, SymbolTable._int);
        }
    }
     
    public void exitCompare (adeleParser.CompareContext ctx) {
        
        adeleParser.ExprContext expr_l = ctx.expr (0);
        adeleParser.ExprContext expr_r = ctx.expr (1);

        if (expr_l != null && expr_r != null) {
            int type_l = getType (expr_l).getTypeIndex ();
            int type_r = getType (expr_r).getTypeIndex ();
            boolean allow = SymbolTable.compOp[type_l][type_r];
            
            if (allow == false) {
                err (ctx.start.getLine (), "Comparison op not allowed.");
            }
        }

        setType (ctx, SymbolTable._boolean);
    }

    public void exitAtexpr(adeleParser.AtexprContext ctx) {
    }

    public void exitAssign (adeleParser.AssignContext ctx) {
        String name = ctx.ID().getText();
        Symbol var = currentScope.resolve(name);
        
        if (var == null) {
            err (ctx.start.getLine(), "no such variable: "+name);
        } else {

            Type type_r = getType (ctx.expr ());
            Type type_l = getType (ctx.ID ());

            if (type_r != null && type_l != null) {
                int type_li = type_l.getTypeIndex ();
                int type_ri = type_r.getTypeIndex ();

                Type ans = SymbolTable.assignOp[type_li][type_ri];

                if (ans == null) {
                    if (type_li == type_ri && type_li == SymbolTable.M_TYPE_USER) {
                        setType (ctx, type_r);
                    } else {
                        err (ctx.start.getLine(), "Assignment with incompatible types: " + type_l + ":" + type_r); 
                    }
                } else {
                    setType (ctx, ans);
                }
            } else {
                err (ctx.start.getLine(), "Assignment with incompatible types"); 
            }
        }
    }

    public void exitNum(adeleParser.NumContext ctx) {
        String numText = ctx.NUM().getText();
        Type type;

        if (numText.indexOf('.') == -1)
            type = SymbolTable._int;
        else
            type = SymbolTable._float;

        setType(ctx, type);
    }

    public void exitVar (adeleParser.VarContext ctx) {
        String name = ctx.ID().getText();
        Symbol var = currentScope.resolve(name);
        if ( var==null ) {
            err(ctx.start.getLine(), "no such variable: "+name);
        } else {
            setType(ctx, var.getType());
        }
    }

    public void exitType (adeleParser.TypeContext ctx) {
        String typeStr = ctx.start.getText();
        /* typeStr = 'int','string',... or 'group' */

        if (typeStr.equals("group"))
            typeStr += " " + ctx.ID().getText();

        Type type = (Type)currentScope.resolve(typeStr);
        if (type == null) {
            err(ctx.start.getLine(),"Type '" + typeStr + "' is not defined");
            return;
        }

        setType(ctx, type);
    }

}
