import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.List;

class ScanPhase extends adeleBaseListener {

    int errcount;
    GlobalScope globals;
    Scope currentScope;
    ParseTreeProperty<Type> types = new ParseTreeProperty<Type>();
    boolean checkType = false;
    FunctionSymbol curFunc = null;

    public ScanPhase(SymbolTable symtab) {
        globals = symtab.globals;
        currentScope = globals;
        errcount = 0;
    }

    public int getErrCount() {
        return errcount;
    }

    public void enterProg(adeleParser.ProgContext ctx) {
        print("Phase Started.");
    }

    public void exitProg(adeleParser.ProgContext ctx) {
        if (errcount > 0) {
            String msg = (errcount == 1)
                    ? "[ScanPhase] 1 error"
                    : "[ScanPhase] " + errcount + " errors";
            System.err.println(msg);
        } else {
            print("Phase Completed. Continue.");
        }
    }

    public void enterType_declaration(adeleParser.Type_declarationContext ctx) {
        String typeName = ctx.ID().getText();
        GroupSymbol gs = new GroupSymbol("group " + typeName, globals);
        globals.define(gs);
        currentScope = gs;
        checkType = true;
    }

    public void exitGVarDecl(adeleParser.GVarDeclContext ctx) {
        String fieldName = ctx.ID().getText();
        /* if type hasn't been defined, error is handled by exitType() */
        Type fieldType = types.get(ctx.type());

        VariableSymbol vs = new VariableSymbol(fieldName, fieldType);
        if (!currentScope.define(vs)) {
            err(ctx.start.getLine(),
                "Field named '" + fieldName + "' already exists");
        }
    }

    public void exitGArrayDecl(adeleParser.GArrayDeclContext ctx) {
        String fieldName = ctx.ID().getText();
        /* if type hasn't been defined, error is handled by exitType() */
        Type fieldType = types.get(ctx.type());

        List<adeleParser.Array_dimenContext> dimensions = ctx.array_dimen();
        int dimen = dimensions.size();

        ArrayType symbolType = new ArrayType(fieldType, dimen);

        VariableSymbol vs = new VariableSymbol(fieldName, symbolType);
        if (!currentScope.define(vs)) {
            err(ctx.start.getLine(),
                "Field named '" + fieldName + "' already exists");
        }
    }
/*
    public void exitType_dec_item(adeleParser.Type_dec_itemContext ctx) {
        String fieldName = ctx.ID().getText();
        Type fieldType = types.get(ctx.type());

        VariableSymbol vs = new VariableSymbol(fieldName, fieldType);
        if (!currentScope.define(vs)) {
            err(ctx.start.getLine(),
                "Field named '"+fieldName+"' already exists");
        }
    }
*/
    /* members' types should already be defined */
    public void exitType_declaration(adeleParser.Type_declarationContext ctx) {

        /* save symbol name as 'group x', s.t. x can still be used as var name */

        print("  " + currentScope.toString());
        currentScope = globals;
        checkType = false;
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
    public void enterFunc(adeleParser.FuncContext ctx) {
        String name = ctx.ID().getText();

        if (currentScope.resolve("function " + name) != null) {
            err(ctx.start.getLine(), "Function " + name + " is already defined");
            System.exit(0);
        }

        /* ret type is handled by exitFunc */
        FunctionSymbol fs =
            new FunctionSymbol(
                "function " + name, null, globals, ctx.start.getLine());
        globals.define(fs);
        currentScope = fs;
        checkType = true;
        curFunc = fs;
    }

    public void exitPitem(adeleParser.PitemContext ctx) {

        String paramName = ctx.ID().getText();
        Type paramType = types.get(ctx.type());
        int ln = ctx.start.getLine();

        // ZX: Type error is reported in exitType()
        // if (paramType == null) {
        //     err (ln, "Type, " + ctx.type().getText() + " is not valid.");
        //     return;
        // }

        VariableSymbol vs = new VariableSymbol(paramName, paramType);
        vs.setInitialized();

        if (curFunc.defineParam(currentScope, vs) == false) {
            err(ln, "Param, " + paramName + ", is not valid");
        }
    }

    public void exitPlist(adeleParser.PlistContext ctx) {
        checkType = false; /* don't check type in the func block */
    }

    public void exitFunc(adeleParser.FuncContext ctx) {
        Type type = types.get(ctx.type());
        // print ("exitFunc: type: " + type);
        FunctionSymbol fs = (FunctionSymbol) currentScope;
        fs.setType(type);
        // print("exitFunc: fs:" + fs.toString());

        currentScope = globals;
        curFunc = null;
    }

    public void exitType(adeleParser.TypeContext ctx) {
        /* Don't check types func blocks */
        if (!checkType) {
            return;
        }

        String typeStr = ctx.start.getText();
        /* typeStr = 'int','string',... or 'group' */

        if (typeStr.equals("group")) {
            typeStr += " " + ctx.ID().getText();
        }

        Type type = (Type)globals.resolve(typeStr);
        if (type == null) {
            err(ctx.start.getLine(), "Type '" + typeStr + "' is not defined");
            return;
        }

        types.put(ctx, type);
    }

    private void err(int line, String msg) {
        System.err.println("[ERROR] line " + line + ": " + msg);
        errcount++;
    }

    private void print(String msg) {
        System.err.println("    [ScanPhase] " + msg);
    }
}
