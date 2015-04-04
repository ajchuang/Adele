import java.util.*;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTree;

class ScanPhase extends adeleBaseListener {

    GlobalScope globals;

    public ScanPhase (SymbolTable symtab) {
        globals = symtab.globals;
    }

    public void exitType_declaration (adeleParser.Type_declarationContext ctx) {

        String typeName = ctx.ID ().getText ();
        System.err.println ("exitType_declaration:" + typeName);

        GroupSymbol gs = new GroupSymbol (typeName, globals);
        globals.define(gs);

        // try {
        //     TypeGroup ut = new TypeGroup (typeName);
        //     System.err.println ("User-defined Type: " + ut);
        // } catch (Exception e) {
        //     throw new IllegalStateException ("illegal type definition");
        // }
    }

    public void enterFunc (adeleParser.FuncContext ctx) {

        String name = ctx.id.getText();
        Type retType = Symbol.getType (ctx.type().getText());
        
        /* semantic check: no same name functions are allowed */
        Symbol s = globals.resolve (name);
         
        /* TODO: we should use the errorhandler to handle this */
        if (s != null && s instanceof FunctionSymbol) {
            System.err.println ("Function " + name + " is duplicated.");
            System.exit (0);
        }
        
        /* create the function symbol and put it into the global scope */
        FunctionSymbol function = new FunctionSymbol (name, retType, globals);
        globals.define (function);
        System.err.println ("Function " + name + " is defined.");

        adeleParser.PlistContext plist = ctx.plist ();
        List<adeleParser.PitemContext> items = plist.pitem ();
        
        for (int i=0; i<items.size(); ++i) {
            
            adeleParser.PitemContext item = items.get (i);
            
            if (item instanceof adeleParser.Pitem_primContext) {
                
                adeleParser.Pitem_primContext pitem = (adeleParser.Pitem_primContext) item;
                System.err.println (
                    "  found param: " + pitem.pid.getText () + 
                    " of type " + pitem.type().getText ());
                
                /* to define in the function symbol */
                function.setParam (pitem.pid.getText (), null);
                
            } else if (item instanceof adeleParser.Pitem_groupContext) {
                
                adeleParser.Pitem_groupContext pitem = (adeleParser.Pitem_groupContext) item;
                System.err.println (
                    "  found param: " + pitem.pid.getText () + 
                    " of type " + pitem.gid.getText ());
                    
                /* to define in the function symbol */
                function.setParam (pitem.pid.getText (), null);
            }
        }
    }
}
