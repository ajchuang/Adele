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
	 * Enter a parse tree produced by {@link adeleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(adeleParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link adeleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(adeleParser.ExprContext ctx);
}