import java.util.*;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTree;

class ScanPhase extends adeleBaseListener {

    GlobalScope globals;

    public ScanPhase(SymbolTable symtab) {
        globals = symtab.globals;
    }

    public void exitType_declaration (adeleParser.Type_declarationContext ctx) {

        String typeName = ctx.ID ().getText ();
        System.err.println ("exitType_declaration:" + typeName);

        /* save symbol name as 'group x', s.t. x can still be used as var name */
        GroupSymbol gs = new GroupSymbol("group " + typeName, globals);
        globals.define(gs);

        // try {
        //     TypeGroup ut = new TypeGroup (typeName);
        //     System.err.println ("User-defined Type: " + ut);
        // } catch (Exception e) {
        //     throw new IllegalStateException ("illegal type definition");
        // }
    }

    public void enterFunc (adeleParser.FuncContext ctx) {

        /*
        String name = ctx.id.getText();
        String typeStr = ctx.type().getText();
        Symbol.Type type = Symbol.getType(typeStr);

        FunctionSymbol function = new FunctionSymbol (name, type, currentScope);
        currentScope.define (function); // Define function in current scope
        saveScope (ctx, function);      // Push: set function's parent to current
        currentScope = function;        // Current scope is now function scope

        for (int i=0; i<ctx.getChildCount (); ++i) {
            ParseTree node = ctx.getChild (i);

            if (node instanceof PlistContext) {
                PlistContext pnode = (PlistContext) node;

                for (int j=0; j<pnode.getChildCount(); ++j) {

                    if (pnode instanceof Pitem_primContext) {

                        System.err.println ("param: " + pnode.getText ());

                    }
                }
            }
        }
        */
    }
}
