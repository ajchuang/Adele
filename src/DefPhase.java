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

    public void setValue (ParseTree node, Object value) {
        values.put (node, value);
    }

    public Object getValue (ParseTree node) {
        return values.get(node);
    }

    public void defineVar (adeleParser.TypeContext typeCtx, Token nameToken) {
        String typeStr = typeCtx.getText();
        Symbol.Type type = Symbol.getType(typeStr);
        VariableSymbol var = new VariableSymbol(nameToken.getText(), type);
        currentScope.define(var); // Define symbol in current scope
    }

    public void saveScope (ParserRuleContext ctx, Scope s) {
        scopes.put (ctx, s);
    }

    public void enterProg (adeleParser.ProgContext ctx) {
        globals = new GlobalScope(null);
        currentScope = globals;
    }

    public void exitProg (adeleParser.ProgContext ctx) {
    }

    /* when entering group definition */
    public void enterType_declaration (adeleParser.Type_declarationContext ctx) {
        System.err.println ("enterType_declaration:" + ctx.ID ().getText ());
    }

    public void exitType_declaration (adeleParser.Type_declarationContext ctx) {
        
        String typeName = ctx.ID ().getText ();
        System.err.println ("exitType_declaration:" + typeName);
        
        try {
            TypeGroup ut = new TypeGroup (typeName); 
            
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
    }
    
    public void enterFunc (adeleParser.FuncContext ctx) {
        String name = ctx.id.getText();
        String typeStr = ctx.type().getText();
        Symbol.Type type = Symbol.getType(typeStr);
        
        /* TODO: save the parameters for the function symbol */

        FunctionSymbol function = new FunctionSymbol (name, type, currentScope);
        currentScope.define (function); // Define function in current scope
        saveScope (ctx, function);      // Push: set function's parent to current
        currentScope = function;        // Current scope is now function scope
    }

    public void exitFunc(adeleParser.FuncContext ctx) {
        currentScope = currentScope.getEnclosingScope (); // pop scope
    }

    public void exitNum(adeleParser.NumContext ctx) {
        String numText = ctx.NUM().getText();
        setValue(ctx, Integer.valueOf(numText));
    }

    public void exitFpItem(adeleParser.FpitemContext ctx) {
        Object right = getValue(ctx.expr());
        setValue(ctx, right);
    }

    public void exitAssign(adeleParser.AssignContext ctx) {
        Object right = getValue(ctx.expr());
        setValue(ctx, right);
    }

    public void exitVarDecl (adeleParser.VarDeclContext ctx) {
        defineVar(ctx.type(), ctx.ID().getSymbol());
    }

    // public void exitType(adeleParser.TypeContext ctx) {

    // }

}
