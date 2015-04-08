import java.util.*;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTree;

class ScanPhase extends adeleBaseListener {

    GlobalScope globals;
    ParseTreeProperty<Type> values = new ParseTreeProperty<Type>();

    public ScanPhase (SymbolTable symtab) {
        globals = symtab.globals;
    }

    public void exitType_declaration (adeleParser.Type_declarationContext ctx) {

        String typeName = ctx.ID ().getText ();
        System.err.println ("exitType_declaration:" + typeName);

        /* save symbol name as 'group x', s.t. x can still be used as var name */
        GroupSymbol gs = new GroupSymbol("group " + typeName, globals);
        globals.define(gs);
        System.err.println(gs.getName() + " is created");

        // try {
        //     TypeGroup ut = new TypeGroup (typeName);
        //     System.err.println ("User-defined Type: " + ut);
        // } catch (Exception e) {
        //     throw new IllegalStateException ("illegal type definition");
        // }
    }

    /*
     * function must be defined after its return type has been defined;
     * there will only be global functions
     */
    public void exitFunc (adeleParser.FuncContext ctx) {
        String name = ctx.ID().getText();
        Type type = (Type)globals.resolve(ctx.type().getText());
        FunctionSymbol fs = new FunctionSymbol("function " + name, type, globals);
        globals.define(fs);

        /*
         * ZX: The following part is moved to BaseScope.java, in define()
         *
         * semantic check: no same name functions are allowed

        Symbol s = globals.resolve (name);

        TODO: we should use the errorhandler to handle this
        if (s != null && s instanceof FunctionSymbol) {
            System.err.println ("Function " + name + " is duplicated.");
            System.exit (0);
        }
         */

        /* create the function symbol and put it into the global scope */
        System.err.println ("Function " + name + " is defined.");

        adeleParser.PlistContext plist = ctx.plist ();
        List<adeleParser.PitemContext> items = plist.pitem ();

        for (int i=0; i<items.size(); ++i) {

            adeleParser.PitemContext pitem = items.get (i);
            Type ptype = values.get(pitem.type());
            if (ptype == null)
                System.err.println("null");
            System.err.println (
                "  found param: " + pitem.ID().getText () +
                " of type " + ptype.getName());

            /* to define in the function symbol */
            fs.setParam (pitem.ID().getText (), null);
        }
    }

    public void exitType(adeleParser.TypeContext ctx) {
        String typeStr = ctx.start.getText();
        /* typeStr = 'int','string',... or 'group' */

        if (typeStr.equals("group"))
            typeStr += " " + ctx.ID().getText();

        Type type = (Type)globals.resolve(typeStr);
        if (type == null) {
            System.err.println("Type '" + typeStr + "' is not defined");
            return;
        }

        values.put(ctx, type);
    }
}
