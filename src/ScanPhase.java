import java.util.*;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTree;

class ScanPhase extends adeleBaseListener {

    int errcount;
    GlobalScope globals;
    Scope currentScope;
    ParseTreeProperty<Type> types = new ParseTreeProperty<Type>();
    boolean check_type = false;

    public ScanPhase (SymbolTable symtab) {
        globals = symtab.globals;
        currentScope = globals;
        errcount = 0;
    }

    public void exitProg(adeleParser.ProgContext ctx) {
        if (errcount > 0) {
            String msg = errcount == 1 ? "1 error" : errcount+" errors";
            print(msg);
            System.exit(1);
        } else
            print("pass ScanPhase");
    }

    public void enterType_declaration (adeleParser.Type_declarationContext ctx) {
        String typeName = ctx.ID ().getText ();
        GroupSymbol gs = new GroupSymbol("group " + typeName, globals);
        globals.define(gs);
        currentScope = gs;
        check_type = true;
    }

    public void exitType_dec_item(adeleParser.Type_dec_itemContext ctx) {
        String f_name = ctx.ID().getText();
        /* if type hasn't been defined, error is handled by exitType() */
        Type f_type = types.get(ctx.type());

        VariableSymbol vs = new VariableSymbol(f_name, f_type);
        if (!currentScope.define (vs)) {
            err(ctx.start.getLine(),
                "Field named '"+f_name+"' already exists");
        }
    }

    /* members' types should already be defined */
    public void exitType_declaration (adeleParser.Type_declarationContext ctx) {

        /* save symbol name as 'group x', s.t. x can still be used as var name */

        print("  "+currentScope.toString());
        currentScope = globals;
        check_type = false;
        // try {
        //     TypeGroup ut = new TypeGroup (typeName);
        //     err ("User-defined Type: " + ut);
        // } catch (Exception e) {
        //     throw new IllegalStateException ("illegal type definition");
        // }
    }

    /*
     * return type and params' type should already be defined;
     * there will only be global functions
     */
    public void enterFunc (adeleParser.FuncContext ctx) {
        String name = ctx.ID().getText();
        Type type = (Type)globals.resolve(ctx.type().getText());
        FunctionSymbol fs = new FunctionSymbol("function " + name, type, globals);
        globals.define(fs);
        currentScope = fs;
        check_type = true;
    }

    public void exitPitem(adeleParser.PitemContext ctx) {
        String p_name = ctx.ID().getText();
        Type p_type = types.get(ctx.type());

        VariableSymbol vs = new VariableSymbol(p_name, p_type);
        if (!currentScope.define (vs))
            err(ctx.start.getLine(),
                "Param named '"+p_name+"' already exists");
    }

    public void exitPlist(adeleParser.PlistContext ctx) {
        check_type = false; /* don't check type in the func block */
    }

    public void exitFunc (adeleParser.FuncContext ctx) {
        print("  "+currentScope.toString());
        currentScope = globals;
    }

    public void exitType(adeleParser.TypeContext ctx) {
        /* Don't check types func blocks */
        if (!check_type)
            return;

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
