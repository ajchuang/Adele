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
		PTYPE=1, ATYPE=2, TYPE=3, ID=4, FLOAT=5, INT=6, NUM=7, IF=8, END=9, WHILE=10, 
		ADD=11, SUB=12, MULTI=13, DIV=14, LPAREN=15, RPAREN=16, COMMA=17, SEMICOLON=18, 
		EQUAL=19, OVERLAY=20, AT=21, WS=22;
	public static final int
		RULE_prog = 0, RULE_func = 1, RULE_plist = 2, RULE_plist_non_empty = 3, 
		RULE_if_stmt = 4, RULE_while_stmt = 5, RULE_stmts = 6, RULE_declaration = 7, 
		RULE_expr = 8;
	public static final String[] ruleNames = {
		"prog", "func", "plist", "plist_non_empty", "if_stmt", "while_stmt", "stmts", 
		"declaration", "expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, "'if'", "'end'", "'while'", 
		"'+'", "'-'", "'*'", "'/'", "'('", "')'", "','", "';'", "'='", "'//'", 
		"'@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PTYPE", "ATYPE", "TYPE", "ID", "FLOAT", "INT", "NUM", "IF", "END", 
		"WHILE", "ADD", "SUB", "MULTI", "DIV", "LPAREN", "RPAREN", "COMMA", "SEMICOLON", 
		"EQUAL", "OVERLAY", "AT", "WS"
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
			setState(18);
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
			setState(20);
			match(TYPE);
			setState(21);
			match(ID);
			setState(22);
			match(LPAREN);
			setState(23);
			plist();
			setState(24);
			match(RPAREN);
			setState(25);
			stmts();
			setState(26);
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
			setState(35);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				match(TYPE);
				setState(30);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(31);
				match(TYPE);
				setState(32);
				match(ID);
				setState(33);
				match(COMMA);
				setState(34);
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
			setState(43);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				match(TYPE);
				setState(38);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				match(TYPE);
				setState(40);
				match(ID);
				setState(41);
				match(COMMA);
				setState(42);
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
			setState(45);
			match(IF);
			setState(46);
			match(LPAREN);
			setState(47);
			expr(0);
			setState(48);
			match(RPAREN);
			setState(49);
			expr(0);
			setState(50);
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
			setState(52);
			match(WHILE);
			setState(53);
			match(LPAREN);
			setState(54);
			expr(0);
			setState(55);
			match(RPAREN);
			setState(56);
			stmts();
			setState(57);
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
			setState(65);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				if_stmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				while_stmt();
				}
				break;
			case ID:
			case NUM:
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				expr(0);
				setState(62);
				match(SEMICOLON);
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 4);
				{
				setState(64);
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
			setState(73);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				match(TYPE);
				setState(68);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				match(TYPE);
				setState(70);
				match(ID);
				setState(71);
				match(EQUAL);
				setState(72);
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
			setState(94);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(76);
				match(ID);
				setState(77);
				match(EQUAL);
				setState(78);
				expr(7);
				}
				break;
			case 2:
				{
				setState(79);
				match(LPAREN);
				setState(80);
				expr(0);
				setState(81);
				match(RPAREN);
				}
				break;
			case 3:
				{
				setState(83);
				match(ID);
				setState(84);
				match(OVERLAY);
				setState(85);
				match(ID);
				setState(86);
				match(AT);
				setState(87);
				match(LPAREN);
				setState(88);
				match(NUM);
				setState(89);
				match(COMMA);
				setState(90);
				match(NUM);
				setState(91);
				match(RPAREN);
				}
				break;
			case 4:
				{
				setState(92);
				match(NUM);
				}
				break;
			case 5:
				{
				setState(93);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(104);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(102);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(96);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(97);
						_la = _input.LA(1);
						if ( !(_la==MULTI || _la==DIV) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(98);
						expr(7);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(99);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(100);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(101);
						expr(6);
						}
						break;
					}
					} 
				}
				setState(106);
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
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\30n\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4&\n\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\5\5.\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\bD\n\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\5\tL\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\5\na\n\n\3\n\3\n\3\n\3\n\3\n\3\n\7\ni\n\n\f\n\16"+
		"\nl\13\n\3\n\2\3\22\13\2\4\6\b\n\f\16\20\22\2\4\3\2\17\20\3\2\r\16q\2"+
		"\24\3\2\2\2\4\26\3\2\2\2\6%\3\2\2\2\b-\3\2\2\2\n/\3\2\2\2\f\66\3\2\2\2"+
		"\16C\3\2\2\2\20K\3\2\2\2\22`\3\2\2\2\24\25\5\4\3\2\25\3\3\2\2\2\26\27"+
		"\7\5\2\2\27\30\7\6\2\2\30\31\7\21\2\2\31\32\5\6\4\2\32\33\7\22\2\2\33"+
		"\34\5\16\b\2\34\35\7\13\2\2\35\5\3\2\2\2\36&\3\2\2\2\37 \7\5\2\2 &\7\6"+
		"\2\2!\"\7\5\2\2\"#\7\6\2\2#$\7\23\2\2$&\5\b\5\2%\36\3\2\2\2%\37\3\2\2"+
		"\2%!\3\2\2\2&\7\3\2\2\2\'(\7\5\2\2(.\7\6\2\2)*\7\5\2\2*+\7\6\2\2+,\7\23"+
		"\2\2,.\5\b\5\2-\'\3\2\2\2-)\3\2\2\2.\t\3\2\2\2/\60\7\n\2\2\60\61\7\21"+
		"\2\2\61\62\5\22\n\2\62\63\7\22\2\2\63\64\5\22\n\2\64\65\7\13\2\2\65\13"+
		"\3\2\2\2\66\67\7\f\2\2\678\7\21\2\289\5\22\n\29:\7\22\2\2:;\5\16\b\2;"+
		"<\7\13\2\2<\r\3\2\2\2=D\5\n\6\2>D\5\f\7\2?@\5\22\n\2@A\7\24\2\2AD\3\2"+
		"\2\2BD\5\20\t\2C=\3\2\2\2C>\3\2\2\2C?\3\2\2\2CB\3\2\2\2D\17\3\2\2\2EF"+
		"\7\5\2\2FL\7\6\2\2GH\7\5\2\2HI\7\6\2\2IJ\7\25\2\2JL\5\22\n\2KE\3\2\2\2"+
		"KG\3\2\2\2L\21\3\2\2\2MN\b\n\1\2NO\7\6\2\2OP\7\25\2\2Pa\5\22\n\tQR\7\21"+
		"\2\2RS\5\22\n\2ST\7\22\2\2Ta\3\2\2\2UV\7\6\2\2VW\7\26\2\2WX\7\6\2\2XY"+
		"\7\27\2\2YZ\7\21\2\2Z[\7\t\2\2[\\\7\23\2\2\\]\7\t\2\2]a\7\22\2\2^a\7\t"+
		"\2\2_a\7\6\2\2`M\3\2\2\2`Q\3\2\2\2`U\3\2\2\2`^\3\2\2\2`_\3\2\2\2aj\3\2"+
		"\2\2bc\f\b\2\2cd\t\2\2\2di\5\22\n\tef\f\7\2\2fg\t\3\2\2gi\5\22\n\bhb\3"+
		"\2\2\2he\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\23\3\2\2\2lj\3\2\2\2\t"+
		"%-CK`hj";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}