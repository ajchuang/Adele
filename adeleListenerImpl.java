import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class adeleListenerImpl implements adeleListener {

    public adeleListenerImpl () {
    }

    /* @lfred: my log function */
    void log (Object s) {
        System.out.println (s.toString ());
    }

    public void enterEveryRule(ParserRuleContext ctx) {
        //log (ctx);
    }

    public void exitEveryRule(ParserRuleContext ctx) {
        //log (ctx);
    }

    public void visitErrorNode(ErrorNode node) {
        //log (node);
    }

    public void visitTerminal (TerminalNode node) {
        //log (node);
    }

	public void enterProg(adeleParser.ProgContext ctx) {
        log (ctx);
    }

    public void exitProg(adeleParser.ProgContext ctx) {
        log (ctx);
    }

	public void enterType_declaration(adeleParser.Type_declarationContext ctx) {
        log (ctx);
    }

	public void exitType_declaration(adeleParser.Type_declarationContext ctx) {
        log (ctx);
    }

	public void enterFunc(adeleParser.FuncContext ctx) {
        log (ctx);
    }

	public void exitFunc(adeleParser.FuncContext ctx) {
        log (ctx);
    }

	public void enterPlist(adeleParser.PlistContext ctx) {
        log (ctx);
    }

	public void exitPlist(adeleParser.PlistContext ctx) {
        log (ctx);
    }

	public void enterStmts(adeleParser.StmtsContext ctx) {
        log (ctx);
    }

	public void exitStmts(adeleParser.StmtsContext ctx) {
        log (ctx);
    }

	public void enterStmt(adeleParser.StmtContext ctx) {
        log (ctx);
    }

	public void exitStmt(adeleParser.StmtContext ctx) {
        log (ctx);
    }

	public void enterIf_stmt(adeleParser.If_stmtContext ctx) {
        log (ctx);
    }

	public void exitIf_stmt(adeleParser.If_stmtContext ctx) {
        log (ctx);
    }

	public void enterWhile_stmt(adeleParser.While_stmtContext ctx) {
        log (ctx);
    }

	public void exitWhile_stmt(adeleParser.While_stmtContext ctx) {
        log (ctx);
    }

	public void enterDeclaration(adeleParser.DeclarationContext ctx) {
        log (ctx);
    }

	public void exitDeclaration(adeleParser.DeclarationContext ctx) {
        log (ctx);
    }

	public void enterExpr(adeleParser.ExprContext ctx) {
        log (ctx);
    }

	public void exitExpr(adeleParser.ExprContext ctx) {
        log (ctx);
    }

	public void enterFunc_plist(adeleParser.Func_plistContext ctx) {
        log (ctx);
    }

	public void exitFunc_plist(adeleParser.Func_plistContext ctx) {
        log (ctx);
    }

	public void enterFpitem(adeleParser.FpitemContext ctx) {
        log (ctx);
    }

	public void exitFpitem(adeleParser.FpitemContext ctx) {
        log (ctx);
    }
}
