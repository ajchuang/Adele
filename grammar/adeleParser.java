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
			setState(35);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TYPE) {
					{
					{
					setState(23);
					func();
					}
					}
					setState(28);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TYPE) {
					{
					{
					setState(29);
					declaration();
					}
					}
					setState(34);
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
			setState(37);
			match(TYPE);
			setState(38);
			((FuncContext)_localctx).ID = match(ID);
			setState(39);
			match(LPAREN);
			setState(40);
			plist();
			setState(41);
			match(RPAREN);
			setState(42);
			stmts();
			setState(43);
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
			setState(57);
			switch (_input.LA(1)) {
			case RPAREN:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(47);
						match(TYPE);
						setState(48);
						match(ID);
						setState(49);
						match(COMMA);
						}
						} 
					}
					setState(54);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(55);
				match(TYPE);
				setState(56);
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
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << RETURN) | (1L << LPAREN) | (1L << SEMICOLON) | (1L << TYPE) | (1L << ID) | (1L << NUM))) != 0)) {
				{
				{
				setState(59);
				stmt();
				}
				}
				setState(64);
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
			setState(74);
			switch (_input.LA(1)) {
			case SEMICOLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(SEMICOLON);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				if_stmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				while_stmt();
				}
				break;
			case RETURN:
			case LPAREN:
			case ID:
			case NUM:
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
				expr(0);
				setState(69);
				match(SEMICOLON);
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(71);
				declaration();
				setState(72);
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
		enterRule(_localctx, 10, RULE_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(IF);
			setState(77);
			match(LPAREN);
			setState(78);
			expr(0);
			setState(79);
			match(RPAREN);
			setState(80);
			expr(0);
			setState(81);
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
			setState(83);
			match(WHILE);
			setState(84);
			match(LPAREN);
			setState(85);
			expr(0);
			setState(86);
			match(RPAREN);
			setState(87);
			stmts();
			setState(88);
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
		public TerminalNode TYPE() { return getToken(adeleParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(adeleParser.ID, 0); }
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
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(TYPE);
			setState(91);
			((DeclarationContext)_localctx).ID = match(ID);

			                    symTyp.put ((((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null), new Integer (F_TYPE_INT));
			                    symVal.put ((((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null), new Integer (0));
			                    System.out.println ("declare var: " + (((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null)); 
			                
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
		public Token NUM;
		public Func_plistContext func_plist;
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
			setState(128);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(95);
				((ExprContext)_localctx).ID = match(ID);
				setState(96);
				match(EQUAL);
				setState(97);
				((ExprContext)_localctx).e1 = ((ExprContext)_localctx).expr = expr(15);

				                    int v = ((ExprContext)_localctx).e1.value;
				                    System.out.println ("assignment: " + (((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null) + " = " + (((ExprContext)_localctx).e1!=null?_input.getText(((ExprContext)_localctx).e1.start,((ExprContext)_localctx).e1.stop):null) + ":" + v);
				                    symVal.put ((((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null), new Integer (v));
				                    ((ExprContext)_localctx).value =  v;
				                
				}
				break;
			case 2:
				{
				setState(100);
				match(RETURN);
				setState(101);
				((ExprContext)_localctx).expr = expr(3);

				                    ((ExprContext)_localctx).value =  _localctx.value;
				                
				}
				break;
			case 3:
				{
				setState(104);
				match(LPAREN);
				setState(105);
				((ExprContext)_localctx).expr = expr(0);
				setState(106);
				match(RPAREN);
				 ((ExprContext)_localctx).value =  _localctx.value; 
				}
				break;
			case 4:
				{
				setState(109);
				((ExprContext)_localctx).ID = match(ID);
				setState(110);
				match(OVERLAY);
				setState(111);
				((ExprContext)_localctx).ID = match(ID);
				setState(112);
				match(AT);
				setState(113);
				match(LPAREN);
				setState(114);
				((ExprContext)_localctx).NUM = match(NUM);
				setState(115);
				match(COMMA);
				setState(116);
				((ExprContext)_localctx).NUM = match(NUM);
				setState(117);
				match(RPAREN);
				}
				break;
			case 5:
				{
				setState(118);
				((ExprContext)_localctx).ID = match(ID);
				setState(119);
				match(LPAREN);
				setState(120);
				((ExprContext)_localctx).func_plist = func_plist();
				setState(121);
				match(RPAREN);
				 
				                    //System.out.println ("func: " + (((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null) + " is called"); 
				                    
				                    /* brute force */
				                    if ((((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null).equals ("print_str")) {
				                        System.out.println ((((ExprContext)_localctx).func_plist!=null?_input.getText(((ExprContext)_localctx).func_plist.start,((ExprContext)_localctx).func_plist.stop):null));
				                    }
				                
				}
				break;
			case 6:
				{
				setState(124);
				((ExprContext)_localctx).ID = match(ID);
				 
				                    String id = (((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null);

				                    if (symVal.containsKey (id)) {
				                        Integer i = (Integer)symVal.get (id);
				                        ((ExprContext)_localctx).value =  i.intValue ();
				                        System.out.println ("ID: " + (((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null) + ":" + _localctx.value);
				                    } else {
				                        ((ExprContext)_localctx).value =  0;
				                        System.out.println ("UNKOWN ID: " + (((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null) + ":" + _localctx.value);
				                    }
				                
				}
				break;
			case 7:
				{
				setState(126);
				((ExprContext)_localctx).NUM = match(NUM);

				                    ((ExprContext)_localctx).value =  Integer.parseInt ((((ExprContext)_localctx).NUM!=null?((ExprContext)_localctx).NUM.getText():null));
				                    System.out.println ("NUM: " + (((ExprContext)_localctx).NUM!=null?((ExprContext)_localctx).NUM.getText():null) + ":" + _localctx.value);
				                
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(164);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(162);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(130);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(131);
						match(MULTI);
						setState(132);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(15);

						                              ((ExprContext)_localctx).value =  ((ExprContext)_localctx).e1.value * ((ExprContext)_localctx).e2.value;
						                          
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(135);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(136);
						match(DIV);
						setState(137);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(14);

						                              ((ExprContext)_localctx).value =  ((ExprContext)_localctx).e1.value / ((ExprContext)_localctx).e2.value;
						                          
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(140);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(141);
						match(ADD);
						setState(142);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(13);

						                              ((ExprContext)_localctx).value =  ((ExprContext)_localctx).e1.value + ((ExprContext)_localctx).e2.value;
						                              System.out.println ("ADD: " + _localctx.value);
						                          
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(145);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(146);
						match(SUB);
						setState(147);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(12);

						                              ((ExprContext)_localctx).value =  ((ExprContext)_localctx).e1.value - ((ExprContext)_localctx).e2.value;
						                          
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(150);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(151);
						match(GT);
						setState(152);
						((ExprContext)_localctx).expr = expr(11);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(153);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(154);
						match(LT);
						setState(155);
						((ExprContext)_localctx).expr = expr(10);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(156);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(157);
						match(GET);
						setState(158);
						((ExprContext)_localctx).expr = expr(9);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(159);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(160);
						match(LET);
						setState(161);
						((ExprContext)_localctx).expr = expr(8);
						}
						break;
					}
					} 
				}
				setState(166);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
			setState(177);
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
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(168);
						fpitem();
						setState(169);
						match(COMMA);
						}
						} 
					}
					setState(175);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(176);
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
			setState(179);
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
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\32\u00b8\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\3\2\7\2\33\n\2\f\2\16\2\36\13\2\3\2\7\2!\n\2\f\2\16"+
		"\2$\13\2\5\2&\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\7\4\65\n\4\f\4\16\48\13\4\3\4\3\4\5\4<\n\4\3\5\7\5?\n\5\f\5\16\5B\13"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6M\n\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0083\n\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00a5\n\n\f\n\16"+
		"\n\u00a8\13\n\3\13\3\13\3\13\3\13\7\13\u00ae\n\13\f\13\16\13\u00b1\13"+
		"\13\3\13\5\13\u00b4\n\13\3\f\3\f\3\f\2\3\22\r\2\4\6\b\n\f\16\20\22\24"+
		"\26\2\3\3\2\27\31\u00c7\2%\3\2\2\2\4\'\3\2\2\2\6;\3\2\2\2\b@\3\2\2\2\n"+
		"L\3\2\2\2\fN\3\2\2\2\16U\3\2\2\2\20\\\3\2\2\2\22\u0082\3\2\2\2\24\u00b3"+
		"\3\2\2\2\26\u00b5\3\2\2\2\30&\3\2\2\2\31\33\5\4\3\2\32\31\3\2\2\2\33\36"+
		"\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35&\3\2\2\2\36\34\3\2\2\2\37!\5\20"+
		"\t\2 \37\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#&\3\2\2\2$\"\3\2\2\2"+
		"%\30\3\2\2\2%\34\3\2\2\2%\"\3\2\2\2&\3\3\2\2\2\'(\7\26\2\2()\7\27\2\2"+
		")*\7\13\2\2*+\5\6\4\2+,\7\f\2\2,-\5\b\5\2-.\7\4\2\2./\b\3\1\2/\5\3\2\2"+
		"\2\60<\3\2\2\2\61\62\7\26\2\2\62\63\7\27\2\2\63\65\7\r\2\2\64\61\3\2\2"+
		"\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28\66\3\2\2\29:\7"+
		"\26\2\2:<\7\27\2\2;\60\3\2\2\2;\66\3\2\2\2<\7\3\2\2\2=?\5\n\6\2>=\3\2"+
		"\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\t\3\2\2\2B@\3\2\2\2CM\7\16\2\2DM\5"+
		"\f\7\2EM\5\16\b\2FG\5\22\n\2GH\7\16\2\2HM\3\2\2\2IJ\5\20\t\2JK\7\16\2"+
		"\2KM\3\2\2\2LC\3\2\2\2LD\3\2\2\2LE\3\2\2\2LF\3\2\2\2LI\3\2\2\2M\13\3\2"+
		"\2\2NO\7\3\2\2OP\7\13\2\2PQ\5\22\n\2QR\7\f\2\2RS\5\22\n\2ST\7\4\2\2T\r"+
		"\3\2\2\2UV\7\5\2\2VW\7\13\2\2WX\5\22\n\2XY\7\f\2\2YZ\5\b\5\2Z[\7\4\2\2"+
		"[\17\3\2\2\2\\]\7\26\2\2]^\7\27\2\2^_\b\t\1\2_\21\3\2\2\2`a\b\n\1\2ab"+
		"\7\27\2\2bc\7\17\2\2cd\5\22\n\21de\b\n\1\2e\u0083\3\2\2\2fg\7\6\2\2gh"+
		"\5\22\n\5hi\b\n\1\2i\u0083\3\2\2\2jk\7\13\2\2kl\5\22\n\2lm\7\f\2\2mn\b"+
		"\n\1\2n\u0083\3\2\2\2op\7\27\2\2pq\7\20\2\2qr\7\27\2\2rs\7\21\2\2st\7"+
		"\13\2\2tu\7\30\2\2uv\7\r\2\2vw\7\30\2\2w\u0083\7\f\2\2xy\7\27\2\2yz\7"+
		"\13\2\2z{\5\24\13\2{|\7\f\2\2|}\b\n\1\2}\u0083\3\2\2\2~\177\7\27\2\2\177"+
		"\u0083\b\n\1\2\u0080\u0081\7\30\2\2\u0081\u0083\b\n\1\2\u0082`\3\2\2\2"+
		"\u0082f\3\2\2\2\u0082j\3\2\2\2\u0082o\3\2\2\2\u0082x\3\2\2\2\u0082~\3"+
		"\2\2\2\u0082\u0080\3\2\2\2\u0083\u00a6\3\2\2\2\u0084\u0085\f\20\2\2\u0085"+
		"\u0086\7\t\2\2\u0086\u0087\5\22\n\21\u0087\u0088\b\n\1\2\u0088\u00a5\3"+
		"\2\2\2\u0089\u008a\f\17\2\2\u008a\u008b\7\n\2\2\u008b\u008c\5\22\n\20"+
		"\u008c\u008d\b\n\1\2\u008d\u00a5\3\2\2\2\u008e\u008f\f\16\2\2\u008f\u0090"+
		"\7\7\2\2\u0090\u0091\5\22\n\17\u0091\u0092\b\n\1\2\u0092\u00a5\3\2\2\2"+
		"\u0093\u0094\f\r\2\2\u0094\u0095\7\b\2\2\u0095\u0096\5\22\n\16\u0096\u0097"+
		"\b\n\1\2\u0097\u00a5\3\2\2\2\u0098\u0099\f\f\2\2\u0099\u009a\7\22\2\2"+
		"\u009a\u00a5\5\22\n\r\u009b\u009c\f\13\2\2\u009c\u009d\7\23\2\2\u009d"+
		"\u00a5\5\22\n\f\u009e\u009f\f\n\2\2\u009f\u00a0\7\24\2\2\u00a0\u00a5\5"+
		"\22\n\13\u00a1\u00a2\f\t\2\2\u00a2\u00a3\7\25\2\2\u00a3\u00a5\5\22\n\n"+
		"\u00a4\u0084\3\2\2\2\u00a4\u0089\3\2\2\2\u00a4\u008e\3\2\2\2\u00a4\u0093"+
		"\3\2\2\2\u00a4\u0098\3\2\2\2\u00a4\u009b\3\2\2\2\u00a4\u009e\3\2\2\2\u00a4"+
		"\u00a1\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2"+
		"\2\2\u00a7\23\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00b4\3\2\2\2\u00aa\u00ab"+
		"\5\26\f\2\u00ab\u00ac\7\r\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00aa\3\2\2\2"+
		"\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2"+
		"\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b4\5\26\f\2\u00b3\u00a9\3\2\2\2"+
		"\u00b3\u00af\3\2\2\2\u00b4\25\3\2\2\2\u00b5\u00b6\t\2\2\2\u00b6\27\3\2"+
		"\2\2\16\34\"%\66;@L\u0082\u00a4\u00a6\u00af\u00b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}