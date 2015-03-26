import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTree;
import org.stringtemplate.v4.*;

public class TransPhase extends adeleBaseListener {
    ParseTreeProperty<Scope> scopes;
    ParseTreeProperty<Integer> values;
    GlobalScope globals;
    STGroupFile stg;
    String tmp;
    Scope currentScope; // resolve symbols starting in this scope

    public TransPhase(GlobalScope globals,
        ParseTreeProperty<Scope> scopes,
        ParseTreeProperty<Integer> values) {
        this.scopes = scopes;
        this.globals = globals;
        this.values = values;
        stg = new STGroupFile("../src/template/group.stg");
        tmp = "";
    }

    public int getValue(ParseTree node) {
        return values.get(node);
    }

    public void enterProg(adeleParser.ProgContext ctx) {
        currentScope = globals;
        //System.out.println("--------------------------");
        ST befprog = stg.getInstanceOf("befprog");
        System.out.print(befprog.render());
    }

    public void exitProg(adeleParser.ProgContext ctx) {
        ST aftprog = stg.getInstanceOf("aftprog");
        System.out.print(aftprog.render());
        System.out.println();
    }

    public void enterFunc(adeleParser.FuncContext ctx) {
        currentScope = scopes.get(ctx);
        System.out.print(tmp);
        tmp = "";
    }

    public void exitFunc(adeleParser.FuncContext ctx) {
        currentScope = currentScope.getEnclosingScope();

        org.stringtemplate.v4.ST func = stg.getInstanceOf("funcdef");
        func.add("fname", ctx.ID());
        func.add("body", tmp);
        System.out.print(func.render());
        System.out.println();
        tmp = "";
    }

    public void exitAssign(adeleParser.AssignContext ctx) {
        org.stringtemplate.v4.ST assign = stg.getInstanceOf("assign");
        assign.add("lhs", ctx.ID());
        assign.add("rhs", getValue(ctx.expr()));
        tmp += assign.render() + '\n';
    }

    public void exitDeclaration(adeleParser.DeclarationContext ctx) {
        org.stringtemplate.v4.ST decl = stg.getInstanceOf("vardecl");
        decl.add("vname", ctx.ID());
        if (ctx.expr() != null) {
            decl.add("value", getValue(ctx.expr()));
        }
        tmp += decl.render() + '\n';
    }

    public void enterFunccall(adeleParser.FunccallContext ctx) {
        org.stringtemplate.v4.ST funccall = stg.getInstanceOf("funccall");
        funccall.add("fname", ctx.ID());
        funccall.add("params", "");
        tmp += funccall.render() + '\n';

    }
}
