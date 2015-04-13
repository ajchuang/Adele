import java.util.*;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTree;

class ScanPhase extends adeleBaseListener {

    int errcount;
    GlobalScope globals;
    ParseTreeProperty<Type> types = new ParseTreeProperty<Type>();

    public ScanPhase (SymbolTable symtab) {
        globals = symtab.globals;
        errcount = 0;
    }

    public void exitProg(adeleParser.ProgContext ctx) {
        if (errcount > 0) {
            String msg = errcount == 1 ? "1 error" : errcount+" errors";
            print(msg);
            System.exit(1);
        }
    }

    /* members' types should already be defined */
    public void exitType_declaration (adeleParser.Type_declarationContext ctx) {

        String typeName = ctx.ID ().getText ();
        print ("exitType_declaration:" + typeName);

        /* save symbol name as 'group x', s.t. x can still be used as var name */
        GroupSymbol gs = new GroupSymbol("group " + typeName, globals);
        globals.define(gs);
        print(gs.getName() + " is created");

        List<adeleParser.Type_dec_itemContext> fields = ctx.type_dec_item();
        for (adeleParser.Type_dec_itemContext field: fields) {
            String f_name = field.ID().getText();
            /* if type hasn't been defined, error is handled by exitType() */
            Type f_type = types.get(field.type());

            VariableSymbol vs = new VariableSymbol(f_name, f_type);
            if (!gs.define (vs)) {
                err(ctx.start.getLine(),
                    "Field named '"+f_name+"' already exists");
            }
        }

        print("  "+gs.toString());

        // try {
        //     TypeGroup ut = new TypeGroup (typeName);
        //     err ("User-defined Type: " + ut);
        // } catch (Exception e) {
        //     throw new IllegalStateException ("illegal type definition");
        // }
    }

    /*
     * function must be defined after its return type and params' type have
     * been defined; there will only be global functions
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
                err ("Function " + name + " is duplicated.");
                System.exit (0);
            }
         */

        print ("Function " + name + " is defined.");

        adeleParser.PlistContext plist = ctx.plist ();
        List<adeleParser.PitemContext> items = plist.pitem ();

        for (int i=0; i<items.size(); ++i) {

            adeleParser.PitemContext pitem = items.get (i);
            String p_name = pitem.ID().getText();
            Type p_type = types.get(pitem.type());
            // if (ptype == null)
            //     err("null");

            VariableSymbol vs = new VariableSymbol(p_name, p_type);
            if (!fs.define (vs))
                err(ctx.start.getLine(),
                    "Param named '"+p_name+"' already exists");
        }

        print("  "+fs.toString());
    }

    public void exitType(adeleParser.TypeContext ctx) {
        String typeStr = ctx.start.getText();
        /* typeStr = 'int','string',... or 'group' */

        if (typeStr.equals("group"))
            typeStr += " " + ctx.ID().getText();

        Type type = (Type)globals.resolve(typeStr);
        if (type == null) {
            err(ctx.start.getLine(), "Type '" + typeStr + "' is not defined");
            return;
        }

        types.put(ctx, type);
    }

    private void err(int line, String msg) {
        System.err.println("line " + line + ": " + msg);
        errcount++;
    }

    private void print(String msg) {
        System.err.println(msg);
    }
}
