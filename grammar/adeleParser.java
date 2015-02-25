// Generated from ./adele.g4 by ANTLR 4.5
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class adeleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PTYPE=1, ATYPE=2, TYPE=3, ID=4, FLOAT=5, INT=6, NUM=7, CHAR=8, STR=9, 
		IF=10, END=11, WHILE=12, ADD=13, SUB=14, MULTI=15, DIV=16, LPAREN=17, 
		RPAREN=18, COMMA=19, SEMICOLON=20, EQUAL=21, OVERLAY=22, AT=23, WS=24;
	public static final int
		RULE_prog = 0, RULE_func = 1, RULE_plist = 2, RULE_plist_non_empty = 3, 
		RULE_if_stmt = 4, RULE_while_stmt = 5, RULE_stmts = 6, RULE_declaration = 7, 
		RULE_expr = 8, RULE_func_plist = 9, RULE_func_plist_non_empty = 10;
	public static final String[] ruleNames = {
		"prog", "func", "plist", "plist_non_empty", "if_stmt", "while_stmt", "stmts", 
		"declaration", "expr", "func_plist", "func_plist_non_empty"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "'if'", "'end'", 
		"'while'", "'+'", "'-'", "'*'", "'/'", "'('", "')'", "','", "';'", "'='", 
		"'//'", "'@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PTYPE", "ATYPE", "TYPE", "ID", "FLOAT", "INT", "NUM", "CHAR", "STR", 
		"IF", "END", "WHILE", "ADD", "SUB", "MULTI", "DIV", "LPAREN", "RPAREN", 
		"COMMA", "SEMICOLON", "EQUAL", "OVERLAY", "AT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "adele.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public adeleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			func();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(adeleParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(adeleParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(adeleParser.LPAREN, 0); }
		public PlistContext plist() {
			return getRuleContext(PlistContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(adeleParser.RPAREN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public TerminalNode END() { return getToken(adeleParser.END, 0); }
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).exitFunc(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(TYPE);
			setState(25);
			match(ID);
			setState(26);
			match(LPAREN);
			setState(27);
			plist();
			setState(28);
			match(RPAREN);
			setState(29);
			stmts();
			setState(30);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PlistContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(adeleParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(adeleParser.ID, 0); }
		public TerminalNode COMMA() { return getToken(adeleParser.COMMA, 0); }
		public Plist_non_emptyContext plist_non_empty() {
			return getRuleContext(Plist_non_emptyContext.class,0);
		}
		public PlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).enterPlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).exitPlist(this);
		}
	}

	public final PlistContext plist() throws RecognitionException {
		PlistContext _localctx = new PlistContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_plist);
		try {
			setState(39);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				match(TYPE);
				setState(34);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(35);
				match(TYPE);
				setState(36);
				match(ID);
				setState(37);
				match(COMMA);
				setState(38);
				plist_non_empty();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Plist_non_emptyContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(adeleParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(adeleParser.ID, 0); }
		public TerminalNode COMMA() { return getToken(adeleParser.COMMA, 0); }
		public Plist_non_emptyContext plist_non_empty() {
			return getRuleContext(Plist_non_emptyContext.class,0);
		}
		public Plist_non_emptyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plist_non_empty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).enterPlist_non_empty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).exitPlist_non_empty(this);
		}
	}

	public final Plist_non_emptyContext plist_non_empty() throws RecognitionException {
		Plist_non_emptyContext _localctx = new Plist_non_emptyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_plist_non_empty);
		try {
			setState(47);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				match(TYPE);
				setState(42);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				match(TYPE);
				setState(44);
				match(ID);
				setState(45);
				match(COMMA);
				setState(46);
				plist_non_empty();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(adeleParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(adeleParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(adeleParser.RPAREN, 0); }
		public TerminalNode END() { return getToken(adeleParser.END, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).exitIf_stmt(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(IF);
			setState(50);
			match(LPAREN);
			setState(51);
			expr(0);
			setState(52);
			match(RPAREN);
			setState(53);
			expr(0);
			setState(54);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(adeleParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(adeleParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(adeleParser.RPAREN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public TerminalNode END() { return getToken(adeleParser.END, 0); }
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).exitWhile_stmt(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(WHILE);
			setState(57);
			match(LPAREN);
			setState(58);
			expr(0);
			setState(59);
			match(RPAREN);
			setState(60);
			stmts();
			setState(61);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtsContext extends ParserRuleContext {
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(adeleParser.SEMICOLON, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public StmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).enterStmts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).exitStmts(this);
		}
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stmts);
		try {
			setState(69);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				if_stmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				while_stmt();
				}
				break;
			case ID:
			case NUM:
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				expr(0);
				setState(66);
				match(SEMICOLON);
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
				declaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(adeleParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(adeleParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(adeleParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declaration);
		try {
			setState(77);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(TYPE);
				setState(72);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				match(TYPE);
				setState(74);
				match(ID);
				setState(75);
				match(EQUAL);
				setState(76);
				expr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(adeleParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(adeleParser.ID, i);
		}
		public TerminalNode EQUAL() { return getToken(adeleParser.EQUAL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(adeleParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(adeleParser.RPAREN, 0); }
		public TerminalNode OVERLAY() { return getToken(adeleParser.OVERLAY, 0); }
		public TerminalNode AT() { return getToken(adeleParser.AT, 0); }
		public List<TerminalNode> NUM() { return getTokens(adeleParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(adeleParser.NUM, i);
		}
		public TerminalNode COMMA() { return getToken(adeleParser.COMMA, 0); }
		public Func_plistContext func_plist() {
			return getRuleContext(Func_plistContext.class,0);
		}
		public TerminalNode MULTI() { return getToken(adeleParser.MULTI, 0); }
		public TerminalNode DIV() { return getToken(adeleParser.DIV, 0); }
		public TerminalNode ADD() { return getToken(adeleParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(adeleParser.SUB, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(80);
				match(ID);
				setState(81);
				match(EQUAL);
				setState(82);
				expr(8);
				}
				break;
			case 2:
				{
				setState(83);
				match(LPAREN);
				setState(84);
				expr(0);
				setState(85);
				match(RPAREN);
				}
				break;
			case 3:
				{
				setState(87);
				match(ID);
				setState(88);
				match(OVERLAY);
				setState(89);
				match(ID);
				setState(90);
				match(AT);
				setState(91);
				match(LPAREN);
				setState(92);
				match(NUM);
				setState(93);
				match(COMMA);
				setState(94);
				match(NUM);
				setState(95);
				match(RPAREN);
				}
				break;
			case 4:
				{
				setState(96);
				match(ID);
				setState(97);
				match(LPAREN);
				setState(98);
				func_plist();
				setState(99);
				match(RPAREN);
				}
				break;
			case 5:
				{
				setState(101);
				match(NUM);
				}
				break;
			case 6:
				{
				setState(102);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(111);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(105);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(106);
						_la = _input.LA(1);
						if ( !(_la==MULTI || _la==DIV) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(107);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(108);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(109);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(110);
						expr(7);
						}
						break;
					}
					} 
				}
				setState(115);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Func_plistContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(adeleParser.ID, 0); }
		public TerminalNode NUM() { return getToken(adeleParser.NUM, 0); }
		public TerminalNode STR() { return getToken(adeleParser.STR, 0); }
		public TerminalNode COMMA() { return getToken(adeleParser.COMMA, 0); }
		public Func_plist_non_emptyContext func_plist_non_empty() {
			return getRuleContext(Func_plist_non_emptyContext.class,0);
		}
		public Func_plistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_plist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).enterFunc_plist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).exitFunc_plist(this);
		}
	}

	public final Func_plistContext func_plist() throws RecognitionException {
		Func_plistContext _localctx = new Func_plistContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_func_plist);
		try {
			setState(123);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				match(NUM);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(119);
				match(STR);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(120);
				match(ID);
				setState(121);
				match(COMMA);
				setState(122);
				func_plist_non_empty();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_plist_non_emptyContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(adeleParser.ID, 0); }
		public TerminalNode NUM() { return getToken(adeleParser.NUM, 0); }
		public TerminalNode STR() { return getToken(adeleParser.STR, 0); }
		public Func_plist_non_emptyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_plist_non_empty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).enterFunc_plist_non_empty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).exitFunc_plist_non_empty(this);
		}
	}

	public final Func_plist_non_emptyContext func_plist_non_empty() throws RecognitionException {
		Func_plist_non_emptyContext _localctx = new Func_plist_non_emptyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_func_plist_non_empty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << NUM) | (1L << STR))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\32\u0082\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4*\n\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5\62\n\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b"+
		"H\n\b\3\t\3\t\3\t\3\t\3\t\3\t\5\tP\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nj"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\3\n\7\nr\n\n\f\n\16\nu\13\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13~\n\13\3\f\3\f\3\f\2\3\22\r\2\4\6\b\n\f\16\20\22"+
		"\24\26\2\5\3\2\21\22\3\2\17\20\5\2\6\6\t\t\13\13\u0088\2\30\3\2\2\2\4"+
		"\32\3\2\2\2\6)\3\2\2\2\b\61\3\2\2\2\n\63\3\2\2\2\f:\3\2\2\2\16G\3\2\2"+
		"\2\20O\3\2\2\2\22i\3\2\2\2\24}\3\2\2\2\26\177\3\2\2\2\30\31\5\4\3\2\31"+
		"\3\3\2\2\2\32\33\7\5\2\2\33\34\7\6\2\2\34\35\7\23\2\2\35\36\5\6\4\2\36"+
		"\37\7\24\2\2\37 \5\16\b\2 !\7\r\2\2!\5\3\2\2\2\"*\3\2\2\2#$\7\5\2\2$*"+
		"\7\6\2\2%&\7\5\2\2&\'\7\6\2\2\'(\7\25\2\2(*\5\b\5\2)\"\3\2\2\2)#\3\2\2"+
		"\2)%\3\2\2\2*\7\3\2\2\2+,\7\5\2\2,\62\7\6\2\2-.\7\5\2\2./\7\6\2\2/\60"+
		"\7\25\2\2\60\62\5\b\5\2\61+\3\2\2\2\61-\3\2\2\2\62\t\3\2\2\2\63\64\7\f"+
		"\2\2\64\65\7\23\2\2\65\66\5\22\n\2\66\67\7\24\2\2\678\5\22\n\289\7\r\2"+
		"\29\13\3\2\2\2:;\7\16\2\2;<\7\23\2\2<=\5\22\n\2=>\7\24\2\2>?\5\16\b\2"+
		"?@\7\r\2\2@\r\3\2\2\2AH\5\n\6\2BH\5\f\7\2CD\5\22\n\2DE\7\26\2\2EH\3\2"+
		"\2\2FH\5\20\t\2GA\3\2\2\2GB\3\2\2\2GC\3\2\2\2GF\3\2\2\2H\17\3\2\2\2IJ"+
		"\7\5\2\2JP\7\6\2\2KL\7\5\2\2LM\7\6\2\2MN\7\27\2\2NP\5\22\n\2OI\3\2\2\2"+
		"OK\3\2\2\2P\21\3\2\2\2QR\b\n\1\2RS\7\6\2\2ST\7\27\2\2Tj\5\22\n\nUV\7\23"+
		"\2\2VW\5\22\n\2WX\7\24\2\2Xj\3\2\2\2YZ\7\6\2\2Z[\7\30\2\2[\\\7\6\2\2\\"+
		"]\7\31\2\2]^\7\23\2\2^_\7\t\2\2_`\7\25\2\2`a\7\t\2\2aj\7\24\2\2bc\7\6"+
		"\2\2cd\7\23\2\2de\5\24\13\2ef\7\24\2\2fj\3\2\2\2gj\7\t\2\2hj\7\6\2\2i"+
		"Q\3\2\2\2iU\3\2\2\2iY\3\2\2\2ib\3\2\2\2ig\3\2\2\2ih\3\2\2\2js\3\2\2\2"+
		"kl\f\t\2\2lm\t\2\2\2mr\5\22\n\nno\f\b\2\2op\t\3\2\2pr\5\22\n\tqk\3\2\2"+
		"\2qn\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t\23\3\2\2\2us\3\2\2\2v~\3\2"+
		"\2\2w~\7\6\2\2x~\7\t\2\2y~\7\13\2\2z{\7\6\2\2{|\7\25\2\2|~\5\26\f\2}v"+
		"\3\2\2\2}w\3\2\2\2}x\3\2\2\2}y\3\2\2\2}z\3\2\2\2~\25\3\2\2\2\177\u0080"+
		"\t\4\2\2\u0080\27\3\2\2\2\n)\61GOiqs}";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}