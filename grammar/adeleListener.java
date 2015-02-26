// Generated from ./adele.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link adeleParser}.
 */
public interface adeleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link adeleParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(adeleParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link adeleParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(adeleParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link adeleParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(adeleParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link adeleParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(adeleParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link adeleParser#plist}.
	 * @param ctx the parse tree
	 */
	void enterPlist(adeleParser.PlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link adeleParser#plist}.
	 * @param ctx the parse tree
	 */
	void exitPlist(adeleParser.PlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link adeleParser#plist_non_empty}.
	 * @param ctx the parse tree
	 */
	void enterPlist_non_empty(adeleParser.Plist_non_emptyContext ctx);
	/**
	 * Exit a parse tree produced by {@link adeleParser#plist_non_empty}.
	 * @param ctx the parse tree
	 */
	void exitPlist_non_empty(adeleParser.Plist_non_emptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link adeleParser#stmts}.
	 * @param ctx the parse tree
	 */
	void enterStmts(adeleParser.StmtsContext ctx);
	/**
	 * Exit a parse tree produced by {@link adeleParser#stmts}.
	 * @param ctx the parse tree
	 */
	void exitStmts(adeleParser.StmtsContext ctx);
	/**
	 * Enter a parse tree produced by {@link adeleParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(adeleParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link adeleParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(adeleParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link adeleParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(adeleParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link adeleParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(adeleParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link adeleParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(adeleParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link adeleParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(adeleParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link adeleParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(adeleParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link adeleParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(adeleParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link adeleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(adeleParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link adeleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(adeleParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link adeleParser#func_plist}.
	 * @param ctx the parse tree
	 */
	void enterFunc_plist(adeleParser.Func_plistContext ctx);
	/**
	 * Exit a parse tree produced by {@link adeleParser#func_plist}.
	 * @param ctx the parse tree
	 */
	void exitFunc_plist(adeleParser.Func_plistContext ctx);
	/**
	 * Enter a parse tree produced by {@link adeleParser#func_plist_non_empty}.
	 * @param ctx the parse tree
	 */
	void enterFunc_plist_non_empty(adeleParser.Func_plist_non_emptyContext ctx);
	/**
	 * Exit a parse tree produced by {@link adeleParser#func_plist_non_empty}.
	 * @param ctx the parse tree
	 */
	void exitFunc_plist_non_empty(adeleParser.Func_plist_non_emptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link adeleParser#fpitem}.
	 * @param ctx the parse tree
	 */
	void enterFpitem(adeleParser.FpitemContext ctx);
	/**
	 * Exit a parse tree produced by {@link adeleParser#fpitem}.
	 * @param ctx the parse tree
	 */
	void exitFpitem(adeleParser.FpitemContext ctx);
}