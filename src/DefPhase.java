import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTree;

class DefPhase extends AdlBaseListener {
  ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
  ParseTreeProperty<Integer> values = new ParseTreeProperty<Integer>();
  GlobalScope globals;
  Scope currentScope;

  public void setValue(ParseTree node, int value) {
    values.put(node, value);
  }

  public int getValue(ParseTree node) {
    return values.get(node);
  }

  public void defineVar(AdlParser.TypeContext typeCtx, Token nameToken) {
    int typeTokenType = typeCtx.start.getType();
    Symbol.Type type = TestAdl.getType(typeTokenType);
    VariableSymbol var = new VariableSymbol(nameToken.getText(), type);
    currentScope.define(var); // Define symbol in current scope
  }

  public void saveScope(ParserRuleContext ctx, Scope s) {
    scopes.put(ctx, s);
  }

  public void enterProg(AdlParser.ProgContext ctx) {
    globals = new GlobalScope(null);
    currentScope = globals;
  }

  public void exitProg(AdlParser.ProgContext ctx) {
    //System.out.println(globals);
  }

  public void enterFunc(AdlParser.FuncContext ctx) {
    String name = ctx.ID().getText();
    int typeTokenType = ctx.type().start.getType();
    Symbol.Type type = TestAdl.getType(typeTokenType);

    // push new scope by making new one that points to enclosing scope
    FunctionSymbol function = new FunctionSymbol(name, type, currentScope);
    currentScope.define(function); // Define function in current scope
    saveScope(ctx, function);      // Push: set function's parent to current
    currentScope = function;       // Current scope is now function scope
  }

  public void exitFunc(AdlParser.FuncContext ctx) {
    //System.out.println(currentScope);
    currentScope = currentScope.getEnclosingScope(); // pop scope
  }

  public void exitNum(AdlParser.NumContext ctx) {
    String numText = ctx.NUM().getText();
    setValue(ctx, Integer.valueOf(numText));
  }

  public void exitAssign(AdlParser.AssignContext ctx) {
    int right = getValue(ctx.expr());
    setValue(ctx, right);
  }

  public void exitDeclaration(AdlParser.DeclarationContext ctx) {
    defineVar(ctx.type(), ctx.ID().getSymbol());
  }

}
