// Generated from Adl.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AdlParser}.
 */
public interface AdlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AdlParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(AdlParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdlParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(AdlParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdlParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(AdlParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdlParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(AdlParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdlParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(AdlParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdlParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(AdlParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdlParser#stmts}.
	 * @param ctx the parse tree
	 */
	void enterStmts(AdlParser.StmtsContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdlParser#stmts}.
	 * @param ctx the parse tree
	 */
	void exitStmts(AdlParser.StmtsContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdlParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(AdlParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdlParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(AdlParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link AdlParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(AdlParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link AdlParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(AdlParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link AdlParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign(AdlParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link AdlParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign(AdlParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code num}
	 * labeled alternative in {@link AdlParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNum(AdlParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code num}
	 * labeled alternative in {@link AdlParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNum(AdlParser.NumContext ctx);
}