import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTree;

class DefPhase extends adeleBaseListener {
  
    ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
    ParseTreeProperty<Integer> values = new ParseTreeProperty<Integer>();
    GlobalScope globals;
    Scope currentScope;

    public void setValue (ParseTree node, int value) {
        values.put (node, value);
    }
  
    public int getValue (ParseTree node) {
        return values.get (node);
    }

    public void defineVar (adeleParser.TypeContext typeCtx, Token nameToken) {
        int typeTokenType = typeCtx.start.getType();
        Symbol.Type type = AdeleRT.getType(typeTokenType);
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
        //System.out.println(globals);
    }

    public void enterFunc (adeleParser.FuncContext ctx) {
        String name = ctx.ID().getText();
        int typeTokenType = ctx.type().start.getType();
        Symbol.Type type = AdeleRT.getType(typeTokenType);

        // push new scope by making new one that points to enclosing scope
        FunctionSymbol function = new FunctionSymbol(name, type, currentScope);
        currentScope.define(function); // Define function in current scope
        saveScope(ctx, function);      // Push: set function's parent to current
        currentScope = function;       // Current scope is now function scope
    }

    public void exitFunc(adeleParser.FuncContext ctx) {
        //System.out.println(currentScope);
        currentScope = currentScope.getEnclosingScope(); // pop scope
    }

    public void exitNum(adeleParser.NumContext ctx) {
        String numText = ctx.NUM().getText();
        setValue(ctx, Integer.valueOf(numText));
    }

    public void exitFpitem(adeleParser.FpitemContext ctx) {
        int right = getValue(ctx.expr());
        setValue(ctx, right);
    }

    public void exitAssign(adeleParser.AssignContext ctx) {
        int right = getValue(ctx.expr());
        setValue(ctx, right);
    }

    public void exitFunc_plist (adeleParser.Func_plistContext ctx) {
    }

    public void exitDeclaration (adeleParser.DeclarationContext ctx) {
        defineVar(ctx.type(), ctx.ID().getSymbol());
    }

}
