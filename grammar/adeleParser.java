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
		IF=1, END=2, WHILE=3, RETURN=4, GROUP=5, ADD=6, SUB=7, MULTI=8, DIV=9, 
		LPAREN=10, RPAREN=11, COMMA=12, SEMICOLON=13, EQUAL=14, OVERLAY=15, AT=16, 
		GT=17, LT=18, GET=19, LET=20, TYPE=21, ID=22, NUM=23, STR=24, WS=25;
	public static final int
		RULE_prog = 0, RULE_type_declaration = 1, RULE_func = 2, RULE_plist = 3, 
		RULE_stmts = 4, RULE_stmt = 5, RULE_if_stmt = 6, RULE_while_stmt = 7, 
		RULE_declaration = 8, RULE_expr = 9, RULE_func_plist = 10, RULE_fpitem = 11;
	public static final String[] ruleNames = {
		"prog", "type_declaration", "func", "plist", "stmts", "stmt", "if_stmt", 
		"while_stmt", "declaration", "expr", "func_plist", "fpitem"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'end'", "'while'", "'return'", "'group'", "'+'", "'-'", 
		"'*'", "'/'", "'('", "')'", "','", "';'", "'='", "'//'", "'@'", "'>'", 
		"'<'", "'>='", "'<='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "IF", "END", "WHILE", "RETURN", "GROUP", "ADD", "SUB", "MULTI", 
		"DIV", "LPAREN", "RPAREN", "COMMA", "SEMICOLON", "EQUAL", "OVERLAY", "AT", 
		"GT", "LT", "GET", "LET", "TYPE", "ID", "NUM", "STR", "WS"
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
	    final int F_TYPE_INT    = 1;
	    final int F_TYPE_CHAR   = 2;
	    final int F_BOOL_TRUE   = 1;
	    final int F_BOOL_FALSE  = -1;

	    /* globals */
	    int m_curScope = 0;

	    /* Map variable name to Integer object holding value */
	    Stack<Hashtable<String, Object>> m_scope = new Stack<Hashtable<String, Object>> (); 
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
		public List<Type_declarationContext> type_declaration() {
			return getRuleContexts(Type_declarationContext.class);
		}
		public Type_declarationContext type_declaration(int i) {
			return getRuleContext(Type_declarationContext.class,i);
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
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==GROUP || _la==TYPE) {
					{
					setState(30);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(25);
						func();
						}
						break;
					case 2:
						{
						setState(26);
						type_declaration();
						}
						break;
					case 3:
						{
						{
						setState(27);
						declaration();
						setState(28);
						match(SEMICOLON);
						}
						}
						break;
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

	public static class Type_declarationContext extends ParserRuleContext {
		public TerminalNode GROUP() { return getToken(adeleParser.GROUP, 0); }
		public List<TerminalNode> ID() { return getTokens(adeleParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(adeleParser.ID, i);
		}
		public TerminalNode END() { return getToken(adeleParser.END, 0); }
		public List<TerminalNode> TYPE() { return getTokens(adeleParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(adeleParser.TYPE, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(adeleParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(adeleParser.SEMICOLON, i);
		}
		public Type_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).enterType_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof adeleListener ) ((adeleListener)listener).exitType_declaration(this);
		}
	}

	public final Type_declarationContext type_declaration() throws RecognitionException {
		Type_declarationContext _localctx = new Type_declarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_type_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(GROUP);
			setState(38);
			match(ID);
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(39);
				match(TYPE);
				setState(40);
				match(ID);
				setState(41);
				match(SEMICOLON);
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(47);
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
		enterRule(_localctx, 4, RULE_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(TYPE);
			setState(50);
			((FuncContext)_localctx).ID = match(ID);
			setState(51);
			match(LPAREN);
			setState(52);
			plist();
			setState(53);
			match(RPAREN);
			setState(54);
			stmts();
			setState(55);
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
		enterRule(_localctx, 6, RULE_plist);
		try {
			int _alt;
			setState(69);
			switch (_input.LA(1)) {
			case RPAREN:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(59);
						match(TYPE);
						setState(60);
						match(ID);
						setState(61);
						match(COMMA);
						}
						} 
					}
					setState(66);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(67);
				match(TYPE);
				setState(68);
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
		enterRule(_localctx, 8, RULE_stmts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << RETURN) | (1L << LPAREN) | (1L << SEMICOLON) | (1L << TYPE) | (1L << ID) | (1L << NUM))) != 0)) {
				{
				{
				setState(71);
				stmt();
				}
				}
				setState(76);
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
		enterRule(_localctx, 10, RULE_stmt);
		try {
			setState(86);
			switch (_input.LA(1)) {
			case SEMICOLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(SEMICOLON);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				if_stmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				while_stmt();
				}
				break;
			case RETURN:
			case LPAREN:
			case ID:
			case NUM:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				expr(0);
				setState(81);
				match(SEMICOLON);
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(83);
				declaration();
				setState(84);
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
		public TerminalNode IF() { return getToken(adeleParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(adeleParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(adeleParser.RPAREN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public TerminalNode END() { return getToken(adeleParser.END, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		enterRule(_localctx, 12, RULE_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(IF);
			setState(89);
			match(LPAREN);
			setState(90);
			((If_stmtContext)_localctx).e1 = expr(0);
			setState(91);
			match(RPAREN);
			m_curScope++;
			setState(93);
			stmts();
			m_curScope--;
			setState(95);
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
		enterRule(_localctx, 14, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(WHILE);
			setState(98);
			match(LPAREN);
			setState(99);
			expr(0);
			setState(100);
			match(RPAREN);
			m_curScope++;
			setState(102);
			stmts();
			m_curScope--;
			setState(104);
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
		enterRule(_localctx, 16, RULE_declaration);
		try {
			setState(115);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(TYPE);
				setState(107);
				((DeclarationContext)_localctx).ID = match(ID);

				                        symTyp.put ((((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null), new Integer (F_TYPE_INT));
				                        symVal.put ((((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null), new Integer (0));

				                        System.err.println ("declare var: " + (((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null)); 
				                    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				match(TYPE);
				setState(110);
				((DeclarationContext)_localctx).ID = match(ID);
				setState(111);
				match(EQUAL);
				setState(112);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(118);
				((ExprContext)_localctx).ID = match(ID);
				setState(119);
				match(EQUAL);
				setState(120);
				((ExprContext)_localctx).e1 = ((ExprContext)_localctx).expr = expr(4);

				                    int v = ((ExprContext)_localctx).e1.value;
				                    //System.out.println ("ASSIGN: " + (((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null) + " = " + (((ExprContext)_localctx).e1!=null?_input.getText(((ExprContext)_localctx).e1.start,((ExprContext)_localctx).e1.stop):null) + ":" + v);
				                    symVal.put ((((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null), new Integer (v));
				                    ((ExprContext)_localctx).value =  v;
				                
				}
				break;
			case 2:
				{
				setState(123);
				match(RETURN);
				setState(124);
				((ExprContext)_localctx).expr = expr(3);

				                    ((ExprContext)_localctx).value =  _localctx.value;
				                
				}
				break;
			case 3:
				{
				setState(127);
				match(LPAREN);
				setState(128);
				((ExprContext)_localctx).expr = expr(0);
				setState(129);
				match(RPAREN);
				 
				                    ((ExprContext)_localctx).value =  _localctx.value; 
				                
				}
				break;
			case 4:
				{
				setState(132);
				((ExprContext)_localctx).ID = match(ID);
				setState(133);
				match(LPAREN);
				setState(134);
				((ExprContext)_localctx).func_plist = func_plist();
				setState(135);
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
				setState(138);
				((ExprContext)_localctx).ID = match(ID);
				setState(139);
				match(OVERLAY);
				setState(140);
				((ExprContext)_localctx).ID = match(ID);
				setState(141);
				match(AT);
				setState(142);
				match(LPAREN);
				setState(143);
				((ExprContext)_localctx).NUM = match(NUM);
				setState(144);
				match(COMMA);
				setState(145);
				((ExprContext)_localctx).NUM = match(NUM);
				setState(146);
				match(RPAREN);
				}
				break;
			case 6:
				{
				setState(147);
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
				setState(149);
				((ExprContext)_localctx).NUM = match(NUM);

				                    ((ExprContext)_localctx).value =  Integer.parseInt ((((ExprContext)_localctx).NUM!=null?((ExprContext)_localctx).NUM.getText():null));
				                    //System.out.println ("NUM: " + (((ExprContext)_localctx).NUM!=null?((ExprContext)_localctx).NUM.getText():null) + ":" + _localctx.value);
				                
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(195);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(193);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(153);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(154);
						match(MULTI);
						setState(155);
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
						setState(158);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(159);
						match(DIV);
						setState(160);
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
						setState(163);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(164);
						match(ADD);
						setState(165);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(12);

						                              int e1 = ((ExprContext)_localctx).e1.value;
						                              int e2 = ((ExprContext)_localctx).e2.value;
						                              ((ExprContext)_localctx).value =  e1 + e2;
						                              
						                              System.err.println ("ADD: " + _localctx.value + ":" + e1 + ":" + e2);
						                          
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(168);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(169);
						match(SUB);
						setState(170);
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
						setState(173);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(174);
						match(GT);
						setState(175);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(10);

						                              if (((ExprContext)_localctx).e1.value - ((ExprContext)_localctx).e2.value > 0)
						                                  ((ExprContext)_localctx).value =  F_BOOL_TRUE;
						                              else
						                                  ((ExprContext)_localctx).value =  F_BOOL_FALSE;;
						                          
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(178);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(179);
						match(LT);
						setState(180);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(9);

						                              if (((ExprContext)_localctx).e1.value - ((ExprContext)_localctx).e2.value < 0)
						                                  ((ExprContext)_localctx).value =  F_BOOL_TRUE;
						                              else
						                                  ((ExprContext)_localctx).value =  F_BOOL_FALSE;;
						                          
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(183);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(184);
						match(GET);
						setState(185);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(8);

						                              if (((ExprContext)_localctx).e1.value - ((ExprContext)_localctx).e2.value >= 0)
						                                  ((ExprContext)_localctx).value =  F_BOOL_TRUE;
						                              else
						                                  ((ExprContext)_localctx).value =  F_BOOL_FALSE;
						                          
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(188);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(189);
						match(LET);
						setState(190);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(7);

						                              if (((ExprContext)_localctx).e1.value - ((ExprContext)_localctx).e2.value <= 0)
						                                  ((ExprContext)_localctx).value =  F_BOOL_TRUE;
						                              else
						                                  ((ExprContext)_localctx).value =  F_BOOL_FALSE;
						                          
						}
						break;
					}
					} 
				}
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		enterRule(_localctx, 20, RULE_func_plist);
		try {
			int _alt;
			setState(208);
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
				setState(204);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(199);
						fpitem();
						setState(200);
						match(COMMA);
						}
						} 
					}
					setState(206);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				setState(207);
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
		enterRule(_localctx, 22, RULE_fpitem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
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
		case 9:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\33\u00d7\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\7\2!\n\2\f\2\16\2$\13\2"+
		"\5\2&\n\2\3\3\3\3\3\3\3\3\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5A\n\5\f\5\16\5D\13\5"+
		"\3\5\3\5\5\5H\n\5\3\6\7\6K\n\6\f\6\16\6N\13\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7Y\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nv\n\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u009a\n\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00c4\n\13\f\13\16\13\u00c7\13"+
		"\13\3\f\3\f\3\f\3\f\7\f\u00cd\n\f\f\f\16\f\u00d0\13\f\3\f\5\f\u00d3\n"+
		"\f\3\r\3\r\3\r\2\3\24\16\2\4\6\b\n\f\16\20\22\24\26\30\2\3\3\2\30\32\u00e7"+
		"\2%\3\2\2\2\4\'\3\2\2\2\6\63\3\2\2\2\bG\3\2\2\2\nL\3\2\2\2\fX\3\2\2\2"+
		"\16Z\3\2\2\2\20c\3\2\2\2\22u\3\2\2\2\24\u0099\3\2\2\2\26\u00d2\3\2\2\2"+
		"\30\u00d4\3\2\2\2\32&\3\2\2\2\33!\5\6\4\2\34!\5\4\3\2\35\36\5\22\n\2\36"+
		"\37\7\17\2\2\37!\3\2\2\2 \33\3\2\2\2 \34\3\2\2\2 \35\3\2\2\2!$\3\2\2\2"+
		"\" \3\2\2\2\"#\3\2\2\2#&\3\2\2\2$\"\3\2\2\2%\32\3\2\2\2%\"\3\2\2\2&\3"+
		"\3\2\2\2\'(\7\7\2\2(.\7\30\2\2)*\7\27\2\2*+\7\30\2\2+-\7\17\2\2,)\3\2"+
		"\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60.\3\2\2\2\61\62\7\4"+
		"\2\2\62\5\3\2\2\2\63\64\7\27\2\2\64\65\7\30\2\2\65\66\7\f\2\2\66\67\5"+
		"\b\5\2\678\7\r\2\289\5\n\6\29:\7\4\2\2:;\b\4\1\2;\7\3\2\2\2<H\3\2\2\2"+
		"=>\7\27\2\2>?\7\30\2\2?A\7\16\2\2@=\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2"+
		"\2\2CE\3\2\2\2DB\3\2\2\2EF\7\27\2\2FH\7\30\2\2G<\3\2\2\2GB\3\2\2\2H\t"+
		"\3\2\2\2IK\5\f\7\2JI\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\13\3\2\2\2"+
		"NL\3\2\2\2OY\7\17\2\2PY\5\16\b\2QY\5\20\t\2RS\5\24\13\2ST\7\17\2\2TY\3"+
		"\2\2\2UV\5\22\n\2VW\7\17\2\2WY\3\2\2\2XO\3\2\2\2XP\3\2\2\2XQ\3\2\2\2X"+
		"R\3\2\2\2XU\3\2\2\2Y\r\3\2\2\2Z[\7\3\2\2[\\\7\f\2\2\\]\5\24\13\2]^\7\r"+
		"\2\2^_\b\b\1\2_`\5\n\6\2`a\b\b\1\2ab\7\4\2\2b\17\3\2\2\2cd\7\5\2\2de\7"+
		"\f\2\2ef\5\24\13\2fg\7\r\2\2gh\b\t\1\2hi\5\n\6\2ij\b\t\1\2jk\7\4\2\2k"+
		"\21\3\2\2\2lm\7\27\2\2mn\7\30\2\2nv\b\n\1\2op\7\27\2\2pq\7\30\2\2qr\7"+
		"\20\2\2rs\5\24\13\2st\b\n\1\2tv\3\2\2\2ul\3\2\2\2uo\3\2\2\2v\23\3\2\2"+
		"\2wx\b\13\1\2xy\7\30\2\2yz\7\20\2\2z{\5\24\13\6{|\b\13\1\2|\u009a\3\2"+
		"\2\2}~\7\6\2\2~\177\5\24\13\5\177\u0080\b\13\1\2\u0080\u009a\3\2\2\2\u0081"+
		"\u0082\7\f\2\2\u0082\u0083\5\24\13\2\u0083\u0084\7\r\2\2\u0084\u0085\b"+
		"\13\1\2\u0085\u009a\3\2\2\2\u0086\u0087\7\30\2\2\u0087\u0088\7\f\2\2\u0088"+
		"\u0089\5\26\f\2\u0089\u008a\7\r\2\2\u008a\u008b\b\13\1\2\u008b\u009a\3"+
		"\2\2\2\u008c\u008d\7\30\2\2\u008d\u008e\7\21\2\2\u008e\u008f\7\30\2\2"+
		"\u008f\u0090\7\22\2\2\u0090\u0091\7\f\2\2\u0091\u0092\7\31\2\2\u0092\u0093"+
		"\7\16\2\2\u0093\u0094\7\31\2\2\u0094\u009a\7\r\2\2\u0095\u0096\7\30\2"+
		"\2\u0096\u009a\b\13\1\2\u0097\u0098\7\31\2\2\u0098\u009a\b\13\1\2\u0099"+
		"w\3\2\2\2\u0099}\3\2\2\2\u0099\u0081\3\2\2\2\u0099\u0086\3\2\2\2\u0099"+
		"\u008c\3\2\2\2\u0099\u0095\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u00c5\3\2"+
		"\2\2\u009b\u009c\f\17\2\2\u009c\u009d\7\n\2\2\u009d\u009e\5\24\13\20\u009e"+
		"\u009f\b\13\1\2\u009f\u00c4\3\2\2\2\u00a0\u00a1\f\16\2\2\u00a1\u00a2\7"+
		"\13\2\2\u00a2\u00a3\5\24\13\17\u00a3\u00a4\b\13\1\2\u00a4\u00c4\3\2\2"+
		"\2\u00a5\u00a6\f\r\2\2\u00a6\u00a7\7\b\2\2\u00a7\u00a8\5\24\13\16\u00a8"+
		"\u00a9\b\13\1\2\u00a9\u00c4\3\2\2\2\u00aa\u00ab\f\f\2\2\u00ab\u00ac\7"+
		"\t\2\2\u00ac\u00ad\5\24\13\r\u00ad\u00ae\b\13\1\2\u00ae\u00c4\3\2\2\2"+
		"\u00af\u00b0\f\13\2\2\u00b0\u00b1\7\23\2\2\u00b1\u00b2\5\24\13\f\u00b2"+
		"\u00b3\b\13\1\2\u00b3\u00c4\3\2\2\2\u00b4\u00b5\f\n\2\2\u00b5\u00b6\7"+
		"\24\2\2\u00b6\u00b7\5\24\13\13\u00b7\u00b8\b\13\1\2\u00b8\u00c4\3\2\2"+
		"\2\u00b9\u00ba\f\t\2\2\u00ba\u00bb\7\25\2\2\u00bb\u00bc\5\24\13\n\u00bc"+
		"\u00bd\b\13\1\2\u00bd\u00c4\3\2\2\2\u00be\u00bf\f\b\2\2\u00bf\u00c0\7"+
		"\26\2\2\u00c0\u00c1\5\24\13\t\u00c1\u00c2\b\13\1\2\u00c2\u00c4\3\2\2\2"+
		"\u00c3\u009b\3\2\2\2\u00c3\u00a0\3\2\2\2\u00c3\u00a5\3\2\2\2\u00c3\u00aa"+
		"\3\2\2\2\u00c3\u00af\3\2\2\2\u00c3\u00b4\3\2\2\2\u00c3\u00b9\3\2\2\2\u00c3"+
		"\u00be\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2"+
		"\2\2\u00c6\25\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00d3\3\2\2\2\u00c9\u00ca"+
		"\5\30\r\2\u00ca\u00cb\7\16\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00c9\3\2\2\2"+
		"\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1"+
		"\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d3\5\30\r\2\u00d2\u00c8\3\2\2\2"+
		"\u00d2\u00ce\3\2\2\2\u00d3\27\3\2\2\2\u00d4\u00d5\t\2\2\2\u00d5\31\3\2"+
		"\2\2\20 \"%.BGLXu\u0099\u00c3\u00c5\u00ce\u00d2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}