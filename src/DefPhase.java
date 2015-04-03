import java.util.*;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTree;

class DefPhase extends adeleBaseListener {

    ParseTreeProperty<Scope>  scopes    = new ParseTreeProperty<Scope>();
    ParseTreeProperty<Object> values    = new ParseTreeProperty<Object>();
    ParseTreeProperty<Object> usrType   = new ParseTreeProperty<Object>();

    GlobalScope globals;
    Scope currentScope;

    public DefPhase(SymbolTable symtab) {
        globals = symtab.globals;
    }

    public void setValue (ParseTree node, Object value) {
        values.put (node, value);
    }

    public Object getValue (ParseTree node) {
        return values.get(node);
    }

    public void saveScope (ParserRuleContext ctx, Scope s) {
        scopes.put (ctx, s);
    }

    public void enterProg (adeleParser.ProgContext ctx) {
        currentScope = globals;
    }

    public void exitProg (adeleParser.ProgContext ctx) {
    }

    /* when entering group definition */
    public void enterType_declaration (adeleParser.Type_declarationContext ctx) {
        System.err.println ("enterType_declaration:" + ctx.ID ().getText ());
        GroupSymbol gs = (GroupSymbol)currentScope.resolve(ctx.ID ().getText ());
        // currentScope.define(gs);
        saveScope(ctx, gs);
        currentScope = gs;
    }

    public void exitType_declaration (adeleParser.Type_declarationContext ctx) {

        String typeName = ctx.ID ().getText ();
        System.err.println ("exitType_declaration:" + typeName);

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

            System.err.println ("" + ut);

        } catch (Exception e) {
            throw new IllegalStateException ("illegal type definition");
        }
        */
    }

    public void enterFunc (adeleParser.FuncContext ctx) {
        String name = ctx.id.getText();
        String typeStr = ctx.type().getText();
        Type type = (Type)currentScope.resolve(typeStr);

        FunctionSymbol function = new FunctionSymbol (name, type, currentScope);
        currentScope.define (function); // Define function in current scope
        saveScope (ctx, function);      // Push: set function's parent to current
        currentScope = function;        // Current scope is now function scope

        /* TODO: save the parameters for the function symbol */
        //for (int i=0; i<ctx.getChildCount (); ++i) {
        //    ParseTree node = ctx.getChild (i);
        //}
    }

    public void exitFunc (adeleParser.FuncContext ctx) {
        currentScope = currentScope.getEnclosingScope ();
    }

    public void exitFpItem(adeleParser.FpitemContext ctx) {
        Object right = getValue(ctx.expr());
        setValue(ctx, right);
    }

    /* declare a group variable */
    public void exitGroupDecl (adeleParser.GroupDeclContext ctx) {
        String typeStr = ctx.gid.getText();
        Symbol type = currentScope.resolve(typeStr);
        if (type == null) {
            err("no such group: " + typeStr);
        } else if (type instanceof FunctionSymbol) {
            err(typeStr + " is not a group type");
        } else {
            GroupSymbol group = new GroupSymbol(ctx.id.getText(), (Scope)type);
            currentScope.define(group);
        }
    }

    public void exitVarDecl (adeleParser.VarDeclContext ctx) {
        String typeStr = ctx.type().getText();
        Type type = (Type)currentScope.resolve(typeStr);
        VariableSymbol var = new VariableSymbol(ctx.ID().getText(), type);
        currentScope.define(var);
    }

    /********** expr **********/
    public void exitAssign(adeleParser.AssignContext ctx) {
        Object right = getValue(ctx.expr());
        setValue(ctx, right);
    }

    public void exitNum(adeleParser.NumContext ctx) {
        String numText = ctx.NUM().getText();
        setValue(ctx, Integer.valueOf(numText));
    }

    public void exitVar (adeleParser.VarContext ctx) {
        String name = ctx.ID().getSymbol().getText();
        Symbol var = currentScope.resolve(name);
        if ( var==null ) {
            err("no such variable: "+name);
        }
        if ( var instanceof FunctionSymbol ) {
            err(name+" is not a variable");
        }
    }
    /*************************/

    private void err(String msg) {
        System.err.println(msg);
    }

}
