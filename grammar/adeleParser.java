// Generated from ./adele.g4 by ANTLR 4.5

    import java.util.*;

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
		IF=1, END=2, WHILE=3, RETURN=4, ADD=5, SUB=6, MULTI=7, DIV=8, LPAREN=9, 
		RPAREN=10, COMMA=11, SEMICOLON=12, EQUAL=13, OVERLAY=14, AT=15, GT=16, 
		LT=17, GET=18, LET=19, TYPE=20, ID=21, NUM=22, STR=23, WS=24;
	public static final int
		RULE_prog = 0, RULE_func = 1, RULE_plist = 2, RULE_stmts = 3, RULE_stmt = 4, 
		RULE_if_stmt = 5, RULE_while_stmt = 6, RULE_declaration = 7, RULE_expr = 8, 
		RULE_func_plist = 9, RULE_fpitem = 10;
	public static final String[] ruleNames = {
		"prog", "func", "plist", "stmts", "stmt", "if_stmt", "while_stmt", "declaration", 
		"expr", "func_plist", "fpitem"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'end'", "'while'", "'return'", "'+'", "'-'", "'*'", "'/'", 
		"'('", "')'", "','", "';'", "'='", "'//'", "'@'", "'>'", "'<'", "'>='", 
		"'<='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "IF", "END", "WHILE", "RETURN", "ADD", "SUB", "MULTI", "DIV", "LPAREN", 
		"RPAREN", "COMMA", "SEMICOLON", "EQUAL", "OVERLAY", "AT", "GT", "LT", 
		"GET", "LET", "TYPE", "ID", "NUM", "STR", "WS"
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



	    /* constant */
	    final int F_TYPE_INT = 1;

	    /* globals */
	    int m_curScope = 0;

	    /* Map variable name to Integer object holding value */
	    Hashtable<Integer, Object> m_scopeTable = new Hashtable<Integer, Object> (); 
	    Hashtable<String, Object> symTyp = new Hashtable<String, Object> ();
	    Hashtable<String, Object> symVal = new Hashtable<String, Object> ();
	    
	    /* global symbols */
	    Hashtable<String, Object> m_funTbl = new Hashtable<String, Object> ();
	    Hashtable<String, Object> m_glbTbl = new Hashtable<String, Object> ();

	public adeleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(adeleParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(adeleParser.SEMICOLON, i);
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
		int _la;
		try {
			setState(32);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TYPE) {
					{
					setState(27);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(23);
						func();
						}
						break;
					case 2:
						{
						{
						setState(24);
						declaration();
						setState(25);
						match(SEMICOLON);
						}
						}
						break;
					}
					}
					setState(31);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class FuncContext extends ParserRuleContext {
		public Token ID;
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
			setState(34);
			match(TYPE);
			setState(35);
			((FuncContext)_localctx).ID = match(ID);
			setState(36);
			match(LPAREN);
			setState(37);
			plist();
			setState(38);
			match(RPAREN);
			setState(39);
			stmts();
			setState(40);
			match(END);

			                /* insert into the function table */
			                // m_funTbl.put ((((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getText():null), null);
			            
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
		public List<TerminalNode> TYPE() { return getTokens(adeleParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(adeleParser.TYPE, i);
		}
		public List<TerminalNode> ID() { return getTokens(adeleParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(adeleParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(adeleParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(adeleParser.COMMA, i);
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
			int _alt;
			setState(54);
			switch (_input.LA(1)) {
			case RPAREN:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(44);
						match(TYPE);
						setState(45);
						match(ID);
						setState(46);
						match(COMMA);
						}
						} 
					}
					setState(51);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(52);
				match(TYPE);
				setState(53);
				match(ID);
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

	public static class StmtsContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
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
		enterRule(_localctx, 6, RULE_stmts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << RETURN) | (1L << LPAREN) | (1L << SEMICOLON) | (1L << TYPE) | (1L << ID) | (1L << NUM))) != 0)) {
				{
				{
				setState(56);
				stmt();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class StmtContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(adeleParser.SEMICOLON, 0); }
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stmt);
		try {
			setState(71);
			switch (_input.LA(1)) {
			case SEMICOLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(SEMICOLON);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				if_stmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				while_stmt();
				}
				break;
			case RETURN:
			case LPAREN:
			case ID:
			case NUM:
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				expr(0);
				setState(66);
				match(SEMICOLON);
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(68);
				declaration();
				setState(69);
				match(SEMICOLON);
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

	public static class If_stmtContext extends ParserRuleContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode IF() { return getToken(adeleParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(adeleParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(adeleParser.RPAREN, 0); }
		public TerminalNode END() { return getToken(adeleParser.END, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
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
		enterRule(_localctx, 10, RULE_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(IF);
			setState(74);
			match(LPAREN);
			setState(75);
			((If_stmtContext)_localctx).e1 = expr(0);
			setState(76);
			match(RPAREN);
			setState(77);
			((If_stmtContext)_localctx).e2 = expr(0);
			setState(78);
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
		enterRule(_localctx, 12, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(WHILE);
			setState(81);
			match(LPAREN);
			setState(82);
			expr(0);
			setState(83);
			match(RPAREN);
			setState(84);
			stmts();
			setState(85);
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

	public static class DeclarationContext extends ParserRuleContext {
		public Token ID;
		public ExprContext expr;
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
			setState(96);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				match(TYPE);
				setState(88);
				((DeclarationContext)_localctx).ID = match(ID);

				                        symTyp.put ((((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null), new Integer (F_TYPE_INT));
				                        symVal.put ((((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null), new Integer (0));
				                        //System.out.println ("declare var: " + (((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null)); 
				                    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				match(TYPE);
				setState(91);
				((DeclarationContext)_localctx).ID = match(ID);
				setState(92);
				match(EQUAL);
				setState(93);
				((DeclarationContext)_localctx).expr = expr(0);

				                        symTyp.put ((((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null), new Integer (F_TYPE_INT));
				                        symVal.put ((((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null), new Integer (((DeclarationContext)_localctx).expr.value));
				                    
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
		public int value;
		public ExprContext e1;
		public Token ID;
		public ExprContext expr;
		public Func_plistContext func_plist;
		public Token NUM;
		public ExprContext e2;
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
		public TerminalNode RETURN() { return getToken(adeleParser.RETURN, 0); }
		public TerminalNode LPAREN() { return getToken(adeleParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(adeleParser.RPAREN, 0); }
		public Func_plistContext func_plist() {
			return getRuleContext(Func_plistContext.class,0);
		}
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
		public TerminalNode GT() { return getToken(adeleParser.GT, 0); }
		public TerminalNode LT() { return getToken(adeleParser.LT, 0); }
		public TerminalNode GET() { return getToken(adeleParser.GET, 0); }
		public TerminalNode LET() { return getToken(adeleParser.LET, 0); }
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(99);
				((ExprContext)_localctx).ID = match(ID);
				setState(100);
				match(EQUAL);
				setState(101);
				((ExprContext)_localctx).e1 = ((ExprContext)_localctx).expr = expr(4);

				                    int v = ((ExprContext)_localctx).e1.value;
				                    //System.out.println ("ASSIGN: " + (((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null) + " = " + (((ExprContext)_localctx).e1!=null?_input.getText(((ExprContext)_localctx).e1.start,((ExprContext)_localctx).e1.stop):null) + ":" + v);
				                    symVal.put ((((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null), new Integer (v));
				                    ((ExprContext)_localctx).value =  v;
				                
				}
				break;
			case 2:
				{
				setState(104);
				match(RETURN);
				setState(105);
				((ExprContext)_localctx).expr = expr(3);

				                    ((ExprContext)_localctx).value =  _localctx.value;
				                
				}
				break;
			case 3:
				{
				setState(108);
				match(LPAREN);
				setState(109);
				((ExprContext)_localctx).expr = expr(0);
				setState(110);
				match(RPAREN);
				 
				                    ((ExprContext)_localctx).value =  _localctx.value; 
				                
				}
				break;
			case 4:
				{
				setState(113);
				((ExprContext)_localctx).ID = match(ID);
				setState(114);
				match(LPAREN);
				setState(115);
				((ExprContext)_localctx).func_plist = func_plist();
				setState(116);
				match(RPAREN);
				 
				                    //System.out.println ("func: " + (((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null) + " is called"); 
				                    
				                    /* brute force */
				                    if ((((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null).equals ("print")) {
				                        System.out.println ((((ExprContext)_localctx).func_plist!=null?_input.getText(((ExprContext)_localctx).func_plist.start,((ExprContext)_localctx).func_plist.stop):null));
				                    }
				                
				}
				break;
			case 5:
				{
				setState(119);
				((ExprContext)_localctx).ID = match(ID);
				setState(120);
				match(OVERLAY);
				setState(121);
				((ExprContext)_localctx).ID = match(ID);
				setState(122);
				match(AT);
				setState(123);
				match(LPAREN);
				setState(124);
				((ExprContext)_localctx).NUM = match(NUM);
				setState(125);
				match(COMMA);
				setState(126);
				((ExprContext)_localctx).NUM = match(NUM);
				setState(127);
				match(RPAREN);
				}
				break;
			case 6:
				{
				setState(128);
				((ExprContext)_localctx).ID = match(ID);
				 
				                    String id = (((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null);

				                    if (symVal.containsKey (id)) {
				                        Integer i = (Integer)symVal.get (id);
				                        ((ExprContext)_localctx).value =  i.intValue ();
				                        //System.out.println ("ID: " + (((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null) + ":" + _localctx.value);
				                    } else {
				                        ((ExprContext)_localctx).value =  0;
				                        //System.out.println ("UNKOWN ID: " + (((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null) + ":" + _localctx.value);
				                    }
				                
				}
				break;
			case 7:
				{
				setState(130);
				((ExprContext)_localctx).NUM = match(NUM);

				                    ((ExprContext)_localctx).value =  Integer.parseInt ((((ExprContext)_localctx).NUM!=null?((ExprContext)_localctx).NUM.getText():null));
				                    //System.out.println ("NUM: " + (((ExprContext)_localctx).NUM!=null?((ExprContext)_localctx).NUM.getText():null) + ":" + _localctx.value);
				                
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(170);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(168);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(134);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(135);
						match(MULTI);
						setState(136);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(14);

						                              ((ExprContext)_localctx).value =  ((ExprContext)_localctx).e1.value * ((ExprContext)_localctx).e2.value;
						                          
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(139);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(140);
						match(DIV);
						setState(141);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(13);

						                              ((ExprContext)_localctx).value =  ((ExprContext)_localctx).e1.value / ((ExprContext)_localctx).e2.value;
						                          
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(144);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(145);
						match(ADD);
						setState(146);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(12);

						                              int e1 = ((ExprContext)_localctx).e1.value;
						                              int e2 = ((ExprContext)_localctx).e2.value;
						                              ((ExprContext)_localctx).value =  e1 + e2;
						                              //System.out.println ("ADD: " + _localctx.value + ":" + e1 + ":" + e2);
						                          
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(149);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(150);
						match(SUB);
						setState(151);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(11);

						                              ((ExprContext)_localctx).value =  ((ExprContext)_localctx).e1.value - ((ExprContext)_localctx).e2.value;
						                          
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(154);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(155);
						match(GT);
						setState(156);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(10);

						                              ((ExprContext)_localctx).value =  ((ExprContext)_localctx).e1.value - ((ExprContext)_localctx).e2.value;
						                          
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(159);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(160);
						match(LT);
						setState(161);
						((ExprContext)_localctx).expr = expr(9);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(162);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(163);
						match(GET);
						setState(164);
						((ExprContext)_localctx).expr = expr(8);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(165);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(166);
						match(LET);
						setState(167);
						((ExprContext)_localctx).expr = expr(7);
						}
						break;
					}
					} 
				}
				setState(172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		public List<FpitemContext> fpitem() {
			return getRuleContexts(FpitemContext.class);
		}
		public FpitemContext fpitem(int i) {
			return getRuleContext(FpitemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(adeleParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(adeleParser.COMMA, i);
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
			int _alt;
			setState(183);
			switch (_input.LA(1)) {
			case RPAREN:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case ID:
			case NUM:
			case STR:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(174);
						fpitem();
						setState(175);
						match(COMMA);
						}
						} 
					}
					setState(181);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				setState(182);
				fpitem();
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

	public static class FpitemContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(adeleParser.ID, 0); }
		public TerminalNode NUM() { return getToken(adeleParser.NUM, 0); }
		public TerminalNode STR() { return getToken(adeleParser.STR, 0); }
		public FpitemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fpitem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).enterFpitem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).exitFpitem(this);
		}
	}

	public final FpitemContext fpitem() throws RecognitionException {
		FpitemContext _localctx = new FpitemContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_fpitem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
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
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\32\u00be\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\5\2#\n\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4\62\n\4\f\4\16\4"+
		"\65\13\4\3\4\3\4\5\49\n\4\3\5\7\5<\n\5\f\5\16\5?\13\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\5\6J\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tc\n\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0087\n"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7"+
		"\n\u00ab\n\n\f\n\16\n\u00ae\13\n\3\13\3\13\3\13\3\13\7\13\u00b4\n\13\f"+
		"\13\16\13\u00b7\13\13\3\13\5\13\u00ba\n\13\3\f\3\f\3\f\2\3\22\r\2\4\6"+
		"\b\n\f\16\20\22\24\26\2\3\3\2\27\31\u00cd\2\"\3\2\2\2\4$\3\2\2\2\68\3"+
		"\2\2\2\b=\3\2\2\2\nI\3\2\2\2\fK\3\2\2\2\16R\3\2\2\2\20b\3\2\2\2\22\u0086"+
		"\3\2\2\2\24\u00b9\3\2\2\2\26\u00bb\3\2\2\2\30#\3\2\2\2\31\36\5\4\3\2\32"+
		"\33\5\20\t\2\33\34\7\16\2\2\34\36\3\2\2\2\35\31\3\2\2\2\35\32\3\2\2\2"+
		"\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 #\3\2\2\2!\37\3\2\2\2\"\30\3\2"+
		"\2\2\"\37\3\2\2\2#\3\3\2\2\2$%\7\26\2\2%&\7\27\2\2&\'\7\13\2\2\'(\5\6"+
		"\4\2()\7\f\2\2)*\5\b\5\2*+\7\4\2\2+,\b\3\1\2,\5\3\2\2\2-9\3\2\2\2./\7"+
		"\26\2\2/\60\7\27\2\2\60\62\7\r\2\2\61.\3\2\2\2\62\65\3\2\2\2\63\61\3\2"+
		"\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66\67\7\26\2\2\679\7\27"+
		"\2\28-\3\2\2\28\63\3\2\2\29\7\3\2\2\2:<\5\n\6\2;:\3\2\2\2<?\3\2\2\2=;"+
		"\3\2\2\2=>\3\2\2\2>\t\3\2\2\2?=\3\2\2\2@J\7\16\2\2AJ\5\f\7\2BJ\5\16\b"+
		"\2CD\5\22\n\2DE\7\16\2\2EJ\3\2\2\2FG\5\20\t\2GH\7\16\2\2HJ\3\2\2\2I@\3"+
		"\2\2\2IA\3\2\2\2IB\3\2\2\2IC\3\2\2\2IF\3\2\2\2J\13\3\2\2\2KL\7\3\2\2L"+
		"M\7\13\2\2MN\5\22\n\2NO\7\f\2\2OP\5\22\n\2PQ\7\4\2\2Q\r\3\2\2\2RS\7\5"+
		"\2\2ST\7\13\2\2TU\5\22\n\2UV\7\f\2\2VW\5\b\5\2WX\7\4\2\2X\17\3\2\2\2Y"+
		"Z\7\26\2\2Z[\7\27\2\2[c\b\t\1\2\\]\7\26\2\2]^\7\27\2\2^_\7\17\2\2_`\5"+
		"\22\n\2`a\b\t\1\2ac\3\2\2\2bY\3\2\2\2b\\\3\2\2\2c\21\3\2\2\2de\b\n\1\2"+
		"ef\7\27\2\2fg\7\17\2\2gh\5\22\n\6hi\b\n\1\2i\u0087\3\2\2\2jk\7\6\2\2k"+
		"l\5\22\n\5lm\b\n\1\2m\u0087\3\2\2\2no\7\13\2\2op\5\22\n\2pq\7\f\2\2qr"+
		"\b\n\1\2r\u0087\3\2\2\2st\7\27\2\2tu\7\13\2\2uv\5\24\13\2vw\7\f\2\2wx"+
		"\b\n\1\2x\u0087\3\2\2\2yz\7\27\2\2z{\7\20\2\2{|\7\27\2\2|}\7\21\2\2}~"+
		"\7\13\2\2~\177\7\30\2\2\177\u0080\7\r\2\2\u0080\u0081\7\30\2\2\u0081\u0087"+
		"\7\f\2\2\u0082\u0083\7\27\2\2\u0083\u0087\b\n\1\2\u0084\u0085\7\30\2\2"+
		"\u0085\u0087\b\n\1\2\u0086d\3\2\2\2\u0086j\3\2\2\2\u0086n\3\2\2\2\u0086"+
		"s\3\2\2\2\u0086y\3\2\2\2\u0086\u0082\3\2\2\2\u0086\u0084\3\2\2\2\u0087"+
		"\u00ac\3\2\2\2\u0088\u0089\f\17\2\2\u0089\u008a\7\t\2\2\u008a\u008b\5"+
		"\22\n\20\u008b\u008c\b\n\1\2\u008c\u00ab\3\2\2\2\u008d\u008e\f\16\2\2"+
		"\u008e\u008f\7\n\2\2\u008f\u0090\5\22\n\17\u0090\u0091\b\n\1\2\u0091\u00ab"+
		"\3\2\2\2\u0092\u0093\f\r\2\2\u0093\u0094\7\7\2\2\u0094\u0095\5\22\n\16"+
		"\u0095\u0096\b\n\1\2\u0096\u00ab\3\2\2\2\u0097\u0098\f\f\2\2\u0098\u0099"+
		"\7\b\2\2\u0099\u009a\5\22\n\r\u009a\u009b\b\n\1\2\u009b\u00ab\3\2\2\2"+
		"\u009c\u009d\f\13\2\2\u009d\u009e\7\22\2\2\u009e\u009f\5\22\n\f\u009f"+
		"\u00a0\b\n\1\2\u00a0\u00ab\3\2\2\2\u00a1\u00a2\f\n\2\2\u00a2\u00a3\7\23"+
		"\2\2\u00a3\u00ab\5\22\n\13\u00a4\u00a5\f\t\2\2\u00a5\u00a6\7\24\2\2\u00a6"+
		"\u00ab\5\22\n\n\u00a7\u00a8\f\b\2\2\u00a8\u00a9\7\25\2\2\u00a9\u00ab\5"+
		"\22\n\t\u00aa\u0088\3\2\2\2\u00aa\u008d\3\2\2\2\u00aa\u0092\3\2\2\2\u00aa"+
		"\u0097\3\2\2\2\u00aa\u009c\3\2\2\2\u00aa\u00a1\3\2\2\2\u00aa\u00a4\3\2"+
		"\2\2\u00aa\u00a7\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\23\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00ba\3\2\2"+
		"\2\u00b0\u00b1\5\26\f\2\u00b1\u00b2\7\r\2\2\u00b2\u00b4\3\2\2\2\u00b3"+
		"\u00b0\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2"+
		"\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00ba\5\26\f\2\u00b9"+
		"\u00af\3\2\2\2\u00b9\u00b5\3\2\2\2\u00ba\25\3\2\2\2\u00bb\u00bc\t\2\2"+
		"\2\u00bc\27\3\2\2\2\17\35\37\"\638=Ib\u0086\u00aa\u00ac\u00b5\u00b9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}