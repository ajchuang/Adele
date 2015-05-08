import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class DefPhase extends adeleBaseListener {

    ParseTreeProperty<Scope>  scopes    = new ParseTreeProperty<Scope>();
    ParseTreeProperty<Object> values    = new ParseTreeProperty<Object>();
    ParseTreeProperty<Object> usrType   = new ParseTreeProperty<Object>();
    ParseTreeProperty<Type>   types     = new ParseTreeProperty<Type>();
  
    GlobalScope globals;
    Scope currentScope;
    int errCount;
    int warnCount;

    /*------------------------------------------------------------------------*/
    /* ctor                                                                   */
    /*------------------------------------------------------------------------*/
    public DefPhase(SymbolTable symtab) {
        globals = symtab.globals;
        errCount = 0;
        warnCount = 0;
    }

    /*------------------------------------------------------------------------*/
    /* Utility functions                                                      */
    /*------------------------------------------------------------------------*/
    public int getErrCount() {
        return errCount;
    }

    public void setValue(ParseTree node, Object value) {
        values.put(node, value);
    }

    public Object getValue(ParseTree node) {
        return values.get(node);
    }

    public void setType(ParseTree node, Type type) {
        types.put(node, type);
    }

    public Type getType(ParseTree node) {
        return types.get(node);
    }

    public void saveScope(ParserRuleContext ctx, Scope sc) {
        scopes.put(ctx, sc);
    }

    private void warning(int line, String msg) {
        System.err.println("[WARNING] line " + line + ": " + msg);
        warnCount++;
    }

    private void err(int line, String msg) {
        System.err.println("[ERROR] line " + line + ": " + msg);
        errCount++;
    }

    private void print(String msg) {
        System.out.println("    [DefPhase] " +  msg);
    }

    /*------------------------------------------------------------------------*/
    /* Grammar handler function                                               */
    /*------------------------------------------------------------------------*/
    public void enterProg(adeleParser.ProgContext ctx) {
        print("Phase Started.");
        currentScope = globals;
    }

    public void exitProg(adeleParser.ProgContext ctx) {
        if (errCount > 0) {
            String msg =
               (errCount == 1) 
               ? "[Def Phase] 1 error" :
                 "[Def Phase] " + errCount + " errors";
            System.err.println(msg);
        } else {
            print("Phase Completed. Continue.");
        }
    }

    /* when entering group definition */
    public void enterType_declaration(adeleParser.Type_declarationContext ctx) {
        print("enterType_declaration:" + ctx.ID().getText());
        String symbolName = "group " + ctx.ID().getText();
        GroupSymbol gs = (GroupSymbol)currentScope.resolve(symbolName);
        saveScope(ctx, gs);
        currentScope = gs;
    }

    public void exitType_declaration(adeleParser.Type_declarationContext ctx) {

        String typeName = ctx.ID().getText();
        print("exitType_declaration:" + typeName);

        currentScope = currentScope.getEnclosingScope();

        /*
        try {
            GroupSymbol ut = new GroupSymbol(typeName);

            int nChild = ctx.getChildCount();

            for(int i=0; i<nChild; ++i) {

                ParseTree node = ctx.getChild(i);
                String mType = null, mName = null;

                if (node instanceof adeleParser.Dec_item_primContext) {
                    adeleParser.Dec_item_primContext x = (adeleParser.Dec_item_primContext) node;
                    mType = x.type().getText();
                    mName = x.vid.getText();
                } else if (node instanceof adeleParser.Dec_item_groupContext) {
                    adeleParser.Dec_item_groupContext x = (adeleParser.Dec_item_groupContext) node;
                    mType = x.gid.getText();
                    mName = x.vid.getText();
                } else
                    continue;

                if (ut.addField(mType, mName) == false) {
                    throw new IllegalStateException("illegal type definition");
                }
            }

            print("" + ut);

        } catch(Exception e) {
            throw new IllegalStateException("illegal type definition");
        }
        */
    }

    public void enterFunc(adeleParser.FuncContext ctx) {
        String symbolName = "function " + ctx.ID().getText();
        //Type type = (Type)getValue(ctx.type());

        FunctionSymbol function =
               (FunctionSymbol)currentScope.resolve(symbolName);
        saveScope(ctx, function);
        currentScope = function;
    }

    public void exitFunc(adeleParser.FuncContext ctx) {
        currentScope = currentScope.getEnclosingScope();
    }

    public void exitFpItem(adeleParser.FpitemContext ctx) {
        //Object right = getValue(ctx.expr());
        //setValue(ctx, right);
        setType(ctx, getType(ctx.expr()));
    }

    /*------------------------------------------------------------------------*/
    /* declaration                                                            */
    /*------------------------------------------------------------------------*/
    public void exitVarDecl(adeleParser.VarDeclContext ctx) {
        int ln = ctx.start.getLine();

        String name = ctx.ID().getText();
        Type type = getType(ctx.type());
        VariableSymbol var = new VariableSymbol(name, type);
        print("var " + name + ":" + type + " is declared");

        if (!currentScope.define(var)) {
            err(ctx.start.getLine(),
                    "Variable " + name + " is already defined in " 
                    + currentScope.getScopeName());
        }

        if (type instanceof GroupSymbol) {
            var.setInitialized();
        }

        // if  assign, check type
        if (ctx.expr() != null) {

            /* check expr is initialized */
            var.setInitialized();
            print("exitAssign: typeof expr: " + ctx.expr().getClass().getName());
            if (ctx.expr() instanceof adeleParser.VarContext) {
                VariableSymbol vs = (VariableSymbol)currentScope.resolve(ctx.expr().getText());
                assert (vs != null);
                if (!vs.isInitialized()) {
                    err(ln, "Variable, " + vs.getName() + ", might not have been initialized");
                }
            }

            Type typer = getType(ctx.expr());
            if (typer == null) { // err already reported by exitSomeExpr()

            } else {
                print("typer: " + typer.getName());
                int typeli = type.getTypeIndex();
                int typeri = typer.getTypeIndex();

                Type ans = SymbolTable.assignOp[typeli][typeri];
                if (ans == null) {
                    // both are of group type
                    if (typeli == typeri
                            && typeli == SymbolTable.M_TYPE_USER
                            && type.getName().equals(typer.getName())) {
                        setType(ctx, typer);
                    } else {
                        err(ln,"Assignment with incompatible types: " + type + ":" + typer);
                        setType(ctx, SymbolTable._int);
                    }
                } else {
                    setType(ctx, ans);
                }
            }
        }
    }

    public void exitArrayDecl(adeleParser.ArrayDeclContext ctx) {
        Type elementType = getType(ctx.type());

        /* get dimension */
        List<adeleParser.Array_dimenContext> dimensions = ctx.array_dimen();
        int dimen = dimensions.size();

        /* TODO: record and check num in brackets */
        ArrayType symbolType = new ArrayType(elementType, dimen);
        // print(ctx.ID().getText()+" type: "+symbolType.getName());
        // print(ctx.ID().getText()+" dimen: " + symbolType.getDimension());
        String name = ctx.ID().getText();
        VariableSymbol vs = new VariableSymbol(name, symbolType);
        if (!currentScope.define(vs)) {
            err(ctx.start.getLine(),
                    "Variable " + name + " is already defined in "
                    + currentScope.getScopeName());
        }
    }

    /*-----------------------------------------------------------------------*/
    /* statements(in the order in the grammar)                              */
    /*-----------------------------------------------------------------------*/
    public void exitStm_ret(adeleParser.Stm_retContext ctx) {
        
        int ln = ctx.start.getLine();
        Scope fs = currentScope;
        
        while (fs instanceof FunctionSymbol == false) {
            fs = currentScope.getEnclosingScope();
            if (fs == null) {
                err(ln, "Using return in the context other than function call");
                return;
            }
        }
       
        Symbol sb = (Symbol) fs;
        Type retType = sb.getType();
        Type exprType = getType(ctx.expr());

        if (retType != null && exprType != null) {
            int typeLi = retType.getTypeIndex();
            int typeRi = exprType.getTypeIndex();

            Type ans = SymbolTable.assignOp[typeLi][typeRi];

            // print("exitStm_ret: " + retType.getName() + " " + exprType.getName());

            if (   ans == null 
                && retType.getName() != exprType.getName()) {
                err(ln, "incompatible type: return type should be " + retType.getName());
            }
        }

        // print("exitStm_ret: " + retType + exprType);
    }

    public void enterStm_if(adeleParser.Stm_ifContext ctx) {
        InnerScope is = new InnerScope(currentScope);
        saveScope(ctx, is);
        currentScope = is;
    }

    public void exitStm_if(adeleParser.Stm_ifContext ctx) {

        int ln = ctx.start.getLine();
        currentScope = currentScope.getEnclosingScope();
        Type exprType = getType(ctx.if_stmt().expr());

        if (    exprType != SymbolTable._boolean 
            &&  exprType != SymbolTable._int
            &&  exprType != SymbolTable._char) {
            err(ln, "The expression in if statement is not allowed.");
            return;
        }

        if (    exprType != SymbolTable._int 
            &&  exprType != SymbolTable._char) {
            warning(ln, "Using integer expression in if statement.");
        }

        return;
    }

    public void enterStm_while(adeleParser.Stm_whileContext ctx) {
        InnerScope is = new InnerScope(currentScope);
        saveScope(ctx, is);
        currentScope = is;
    }

    public void exitStm_while(adeleParser.Stm_whileContext ctx) {

        int ln = ctx.start.getLine();
        currentScope = currentScope.getEnclosingScope();
        Type exprType = getType(ctx.while_stmt().expr());

        if (    exprType != SymbolTable._boolean 
            &&  exprType != SymbolTable._int
            &&  exprType != SymbolTable._char) {
            err(ln, "The expression in while statement is not boolean.");
            return;
        }

        if (    exprType == SymbolTable._int 
            ||  exprType != SymbolTable._char) {
            warning(ln, "Using integer type in while statement. Auto casting");
        }

        return;
    }
    
    /*-----------------------------------------------------------------------*/
    /* expressions(in the order in the grammar)                             */
    /*-----------------------------------------------------------------------*/
    public void exitParenExpr(adeleParser.ParenExprContext ctx) {
        setType(ctx, getType(ctx.expr()));
    }

    public void exitCast(adeleParser.CastContext ctx) {

        int ln = ctx.start.getLine();
        Type sourceType = getType(ctx.expr());
        Type targetType = null;

        print("Left side: " + ctx.type().getText() + ":" + ctx.ID());

        if (ctx.type().getText() != null) {
            /* Primitive type casting */
            Symbol left = currentScope.resolve(ctx.type().getText());

            if (left == null) {
                err(ln, "Cast can not be performed at type, " + left);
                setType(ctx, sourceType);
                return;
            }

            if (left instanceof BuiltInTypeSymbol == false) {
                err(ln, "Type, " + left + ", is not a valid type.");
                setType(ctx, sourceType);
                return;
            }

            BuiltInTypeSymbol bts = (BuiltInTypeSymbol) left;
            int idxLeft = bts.getTypeIndex();
            int idxRight = sourceType.getTypeIndex();

            Type cc = SymbolTable.assignOp[idxLeft][idxRight];

            if (cc != null) {
                setType(ctx, cc);
            } else {
                err(ln, "Can not cast from " + sourceType + " to " + left);
                setType(ctx, sourceType);
                return;
            }
        } else {
            /* Group type casting */
            String type = "group " + ctx.ID().getText();
            Symbol ss = currentScope.resolve(type);

            if (ss != null) {

                if (type == sourceType.getName()) {
                    setType(ctx, sourceType);
                    return;
                }

                if (ss instanceof GroupSymbol == false) {
                    err(ln, ctx.ID().getText() + " is not a valid id.");
                    setType(ctx, sourceType);
                    return;
                }

                /* cast anyway */
                setType(ctx, ss.getType());

            } else {
                err(ln, type + " is not defined");
                setType(ctx, sourceType);
                return;
            }
        }

    }

    public void exitFuncCall(adeleParser.FuncCallContext ctx) {

        String fname = ctx.ID().getText();
        Symbol func = currentScope.resolve("function " + fname);
        FunctionSymbol fs = null;
        int ln = ctx.start.getLine();

        /* check if  this function is defined */
        if (func == null) {
            err(ln, "Undefined function: " + fname);
            setType(ctx, SymbolTable._int);
            return;
        }

        /* check if  the symbol is a function */
        if (func instanceof FunctionSymbol) {
            fs = (FunctionSymbol)func;
        } else {
            err(ln, "Symbol " + fname + " is not a function");
            setType(ctx, SymbolTable._int);
            return;
        }

        /* set the type using function return type */
        setType(ctx, func.getType());
        print("calling func " + fname + ":" + func.getType());

        /* check param type, do this after resolving expr type */
        ArrayList<Symbol> plist = fs.getParams();
        adeleParser.Func_plistContext plc = ctx.func_plist();

        /* empty list */
        if (plc instanceof adeleParser.Empty_fpisContext) {
            if (plist.size() != 0) {
                err(ln, "Too many parameters.");
            }
            return;
        }

        adeleParser.FpisContext fpc = (adeleParser.FpisContext) ctx.func_plist();
        List<adeleParser.FpitemContext> items = fpc.fpitem();

        if (plist.size() != items.size()) {
            err(ln, "Parameter count does not match.");
            print(plist.size() + ":" + items.size());
            return;
        }

        /* iterate the loop */
        for (int i = 0; i < items.size(); ++i) {
            adeleParser.FpitemContext pitem = items.get(i);
            Type tt = getType(pitem.expr());
            Symbol ss = plist.get(i);

            if (tt != ss.getType()) {
                err(ln, "Parameter, " + pitem.expr().getText() + ", does not match.");
                print(tt + ":" + ss.getType());
            }
        }
    }

    public void exitArrayAccess(adeleParser.ArrayAccessContext ctx) {

        String name = ctx.ID().getText();
        Symbol ss = currentScope.resolve(name);
        int ln = ctx.start.getLine();

        if (ss == null) {
            err(ln, "Unknown array symbol: " + name);
            setType(ctx, SymbolTable._int);
            return;
        }

        Type tt = ss.getType();

        if (tt instanceof ArrayType == false) {
            err(ln, "Incorrect type(not array): " + name);
            setType(ctx, SymbolTable._int);
            return;
        }

        int dimen = ((ArrayType)tt).getDimension();
        if (ctx.array_access().size() != dimen) {
            err(ln, "The array dimension should be " + dimen);
            setType(ctx, SymbolTable._int);
            return;
        }

        ArrayType as = (ArrayType) tt;
        print("Accessing array: " + name + ":" + as);
        setType(ctx, as.getElmType());
    }

    /* TODO: @lfred */
    public void exitMemberVar(adeleParser.MemberVarContext ctx) {

        List<adeleParser.Member_accessContext> mem = ctx.member_access();
        Iterator<adeleParser.Member_accessContext> it = mem.iterator();
        adeleParser.Member_accessContext curr = null;
        int ln = ctx.start.getLine();

        String ss = new String();
        Symbol starting = currentScope.resolve(ctx.ID().getText());

        if (    starting instanceof VariableSymbol == false 
            &&  starting.getType() instanceof GroupSymbol) {
            err(ln, starting + " is not a group symbol");
            setType(ctx, SymbolTable._int);
            return;
        }

        VariableSymbol gs = (VariableSymbol) starting;
        Type curType = gs.getType();

        while (it.hasNext()) {

            Symbol cs = null;
            curr = it.next();

            if (gs != null) {
                // TODO: how to resolve this ?
                //cs = gs.resolveMember(curr.ID().getText());
                curType = cs.getType();
            } else {
                curType = null;
            }

            if (cs == null) {
                err(ln, starting + " is not a member");
                setType(ctx, SymbolTable._int);
                return;
            } else if (cs instanceof GroupSymbol) {
                //TODO: this is wrong.
                //gs = (GroupSymbol) cs;
                curType = gs.getType();
            } else {
                gs = null;
            }
        }

        if (curType != null) {
            setType(ctx, curType);
        } else {
            err(ln, "Bad member access");
            setType(ctx, SymbolTable._int);
        }

        print(ss);
    }

    public void exitMult(adeleParser.MultContext ctx) {

        adeleParser.ExprContext exprL = ctx.expr(0);
        adeleParser.ExprContext exprR = ctx.expr(1);

        if (exprL != null && exprR != null) {
            int typeL = getType(exprL).getTypeIndex();
            int typeR = getType(exprR).getTypeIndex();
            Type op = SymbolTable.arithMultiOp[typeL][typeR];

            if (op == null) {
                err(ctx.start.getLine(), "Type does not support arithmatic operation.");
                setType(ctx, SymbolTable._int);
            } else {
                setType(ctx, op);
            }
        } else {
            err(ctx.start.getLine(), "Type(unknown) does not support arithmatic operation.");
            setType(ctx, SymbolTable._int);
        }
    }

    public void exitAdd(adeleParser.AddContext ctx) {

        adeleParser.ExprContext exprL = ctx.expr(0);
        adeleParser.ExprContext exprR = ctx.expr(1);

        if (getType(exprL) != null && getType(exprR) != null) {
            int typeL = getType(exprL).getTypeIndex();
            int typeR = getType(exprR).getTypeIndex();
            Type op = SymbolTable.arithAddOp[typeL][typeR];

            if (op == null) {
                err(ctx.start.getLine(), "Type does not support arithmatic operation.");
                setType(ctx, SymbolTable._int);
            } else {
                setType(ctx, op);
            }
        } else {
            /* err should already be reported */
            // err(ctx.start.getLine(), "Type(unknown) does not support arithmatic operation.");
            setType(ctx, SymbolTable._int);
        }
    }

    public void exitSub(adeleParser.SubContext ctx) {

        adeleParser.ExprContext exprL = ctx.expr(0);
        adeleParser.ExprContext exprR = ctx.expr(1);

        if (exprL != null && exprR != null) {
            int typeL = getType(exprL).getTypeIndex();
            int typeR = getType(exprR).getTypeIndex();
            Type op = SymbolTable.arithAddOp[typeL][typeR];

            if (op == null) {
                err(ctx.start.getLine(), "Type does not support arithmatic operation.");
                setType(ctx, SymbolTable._int);
            } else {
                setType(ctx, op);
            }
        } else {
            err(ctx.start.getLine(), "Type(unknown) does not support arithmatic operation.");
            setType(ctx, SymbolTable._int);
        }
    }

    public void exitCompare(adeleParser.CompareContext ctx) {

        adeleParser.ExprContext exprL = ctx.expr(0);
        adeleParser.ExprContext exprR = ctx.expr(1);

        if (exprL != null && exprR != null) {
            int typeL = getType(exprL).getTypeIndex();
            int typeR = getType(exprR).getTypeIndex();
            boolean allow = SymbolTable.compOp[typeL][typeR];

            if (allow == false) {
                err(ctx.start.getLine(), "Type mismatch: comparison not allowed.");
                print("type: " + typeL + ":" + typeR);
            }
        }

        setType(ctx, SymbolTable._boolean);
    }

    public void exitBool_val(adeleParser.Bool_valContext ctx) {
        print("Processing bool literal: " + ctx.BOOL_LITERAL().getText());
        setType(ctx, SymbolTable._boolean);
    }

    public void exitOverlay(adeleParser.OverlayContext ctx) {

        int ln = ctx.start.getLine();
        setType(ctx, SymbolTable._void);

        Symbol ss = currentScope.resolve(ctx.sid.getText());
        Symbol tt = currentScope.resolve(ctx.tid.getText());

        /* check source */
        if (ss == null) {
            err(ln, "Symbol " + ctx.sid.getText() + " not defined.");
            return;
        } else if (ss.getType() != SymbolTable._graph) {
            err(ln, "Source in overlay operator is not a graph.");
            return;
        }

        /* check target */
        if (tt == null) {
            err(ln, "Symbol " + ctx.tid.getText() + " not defined.");
            return;
        } else if (tt.getType() != SymbolTable._graph) {
            err(ln, "Target in overlay operator is not a graph.");
            return;
        }

        if (    getType(ctx.xc) != SymbolTable._int 
            ||  getType(ctx.yc) != SymbolTable._int) {

            err(ln, "Expression is not integer.");
            return;
        }
    }

    public void exitAtexpr(adeleParser.AtexprContext ctx) {

        int ln = ctx.start.getLine();
        setType(ctx, SymbolTable._void);

        Symbol ss = currentScope.resolve(ctx.sid.getText());

        /* check source */
        if (ss == null) {
            err(ln, "Symbol " + ctx.sid.getText() + " not defined.");
            return;
        } else if (ss.getType() != SymbolTable._graph) {
            err(ln, "Source in overlay operator is not a graph.");
            return;
        }

        if (    getType(ctx.xc) != SymbolTable._int 
            ||  getType(ctx.yc) != SymbolTable._int) {

            err(ln, "Expression is not integer.");
            return;
        }
    }

    public void exitVatt(adeleParser.VattContext ctx) {
    
        int ln = ctx.start.getLine();
        print("exitVatt");
   
        Type ltype = getType(ctx.lexp);
        Type rtype = getType(ctx.rexp);
        setType(ctx, SymbolTable._graph);

        if (ltype != rtype) {
            err(ln, "Type inconsistency for | operator");
            return;
        }

        if (ltype != SymbolTable._graph) {
            err(ln, "| operator needs graph type");
        }

        return;
    }

    public void exitAssign(adeleParser.AssignContext ctx) {

        int ln = ctx.start.getLine();

        String name = ctx.ID().getText();
        VariableSymbol var = (VariableSymbol)currentScope.resolve(name);

        if (var == null) {
            err(ctx.start.getLine(), "no such variable: " + name);
            setType(ctx, SymbolTable._int);
            return;
        }

        print("exitAssign: typeof expr: " + ctx.expr().getClass().getName());
        if (ctx.expr() instanceof adeleParser.VarContext) {
            VariableSymbol vs = (VariableSymbol)currentScope.resolve(ctx.expr().getText());
            assert (vs != null);
            if (!vs.isInitialized()) {
                err(ln, "Variable, " + vs.getName() + ", might not have been initialized");
            }
        }

        Type typeR = getType(ctx.expr());
        Type typeL = var.getType();

        if (typeR != null && typeL != null) {

            var.setInitialized();

            int typeLi = typeL.getTypeIndex();
            int typeRi = typeR.getTypeIndex();

            Type ans = SymbolTable.assignOp[typeLi][typeRi];

            if (ans == null) {
                if (typeLi == typeRi && typeLi == SymbolTable.M_TYPE_USER
                    && typeL.getName() == typeR.getName()) {
                    setType(ctx, typeR);
                } else {
                    err(ctx.start.getLine(),
                        "Assignment with incompatible types: " + typeL + ":" + typeR);
                    setType(ctx, SymbolTable._int);
                }
            } else {
                setType(ctx, ans);
            }
        } else {
            if (typeL == null) {
                err(ln, "Assignment(left) with incompatible types(unknown)");
            }

            if (typeR == null) {
                err(ln, "Assignment(right) with incompatible types(unknown)");
            }

            setType(ctx, SymbolTable._int);
        }
    }

    /* TODO: @lfred */
    public void exitArrayAssign(adeleParser.ArrayAssignContext ctx) {
        String name = ctx.ID().getText();
        Symbol ss = currentScope.resolve(name);
        int ln = ctx.start.getLine();

        if (ss == null) {
            err(ln, "Unknown array symbol: " + name);
            setType(ctx, SymbolTable._int);
            return;
        }

        Type tt = ss.getType();

        if (tt instanceof ArrayType == false) {
            err(ln, "Incorrect type(not array): " + name);
            setType(ctx, SymbolTable._int);
            return;
        }

        int dimen = ((ArrayType)tt).getDimension();
        
        if (ctx.array_access().size() != dimen) {
            err(ln, "The array dimension should be " + dimen);
            setType(ctx, SymbolTable._int);
            return;
        }

        ArrayType as = (ArrayType) tt;
        print("Accessing array: " + name + ":" + as);

        Type typeR = getType(ctx.expr());
        Type typeL = as.getElmType();

        if (typeR != null && typeL != null) {
            int typeLi = typeL.getTypeIndex();
            int typeRi = typeR.getTypeIndex();

            Type ans = SymbolTable.assignOp[typeLi][typeRi];

            if (ans == null) {
                if (typeLi == typeRi && typeLi == SymbolTable.M_TYPE_USER
                    && typeR.getName() == typeL.getName()) {
                    setType(ctx, typeR);
                } else {
                    err(ctx.start.getLine(),
                        "Assignment with incompatible types: " + typeL + ":" + typeR);
                    setType(ctx, SymbolTable._int);
                }
            } else {
                setType(ctx, ans);
            }
        }
    }

    public void exitVar(adeleParser.VarContext ctx) {
        String name = ctx.ID().getText();
        Symbol var = currentScope.resolve(name);
        
        if (var == null) {
            err(ctx.start.getLine(), "no such variable: " + name);
        } else {
            setType(ctx, var.getType());
        }
    }

    public void exitNegNum(adeleParser.NegNumContext ctx) {

        int ln = ctx.start.getLine();
        String numText = ctx.SUB() + ctx.NUM().getText();
        Type type;
    
        if (ctx.NUM().equals ("0")) {
            err(ln, "-0 is not allowed.");
        }

        if (numText.indexOf('.') == -1) {
            type = SymbolTable._int;
        } else {
            type = SymbolTable._float;
        }

        setType(ctx, type);
    }

    public void exitNum(adeleParser.NumContext ctx) {

        String numText = ctx.NUM().getText();
        Type type;

        if (numText.indexOf('.') == -1) {
            type = SymbolTable._int;
        } else {
            type = SymbolTable._float;
        }

        setType(ctx, type);
    }

    public void exitString(adeleParser.StringContext ctx) {
        print("Processing string literal: " + ctx.STR().getText());
        setType(ctx, SymbolTable._string);
    }

    /*-----------------------------------------------------------------------*/
    /* other constructs                                                      */
    /*-----------------------------------------------------------------------*/
    public void exitType(adeleParser.TypeContext ctx) {

        /* typeStr = 'int','string',... or 'group' */
        String typeStr = ctx.start.getText();

        if (typeStr.equals("group")) {
            typeStr += (" " + ctx.ID().getText());
        }

        Type type = (Type)currentScope.resolve(typeStr);

        if (type == null) {
            err(ctx.start.getLine(),"Type '" + typeStr + "' is not defined");
            setType(ctx, SymbolTable._int);
            return;
        }

        setType(ctx, type);
    }
}
