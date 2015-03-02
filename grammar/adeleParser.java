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
		IF=1, END=2, WHILE=3, RETURN=4, GROUP=5, LPAREN=6, RPAREN=7, COMMA=8, 
		SEMICOLON=9, EQUAL=10, OVERLAY=11, AT=12, GT=13, LT=14, GET=15, LET=16, 
		NE=17, ADDITIVE_OP=18, MULTIPLICATIVE_OP=19, TYPE=20, ID=21, NUM=22, STR=23, 
		WS=24;
	public static final int
		RULE_prog = 0, RULE_type_declaration = 1, RULE_func = 2, RULE_plist = 3, 
		RULE_stmts = 4, RULE_stmt = 5, RULE_if_stmt = 6, RULE_while_stmt = 7, 
		RULE_declaration = 8, RULE_expr = 9, RULE_func_plist = 10, RULE_fpitem = 11;
	public static final String[] ruleNames = {
		"prog", "type_declaration", "func", "plist", "stmts", "stmt", "if_stmt", 
		"while_stmt", "declaration", "expr", "func_plist", "fpitem"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'end'", "'while'", "'return'", "'group'", "'('", "')'", 
		"','", "';'", "'='", "'//'", "'@'", "'>'", "'<'", "'>='", "'<='", "'!='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "IF", "END", "WHILE", "RETURN", "GROUP", "LPAREN", "RPAREN", "COMMA", 
		"SEMICOLON", "EQUAL", "OVERLAY", "AT", "GT", "LT", "GET", "LET", "NE", 
		"ADDITIVE_OP", "MULTIPLICATIVE_OP", "TYPE", "ID", "NUM", "STR", "WS"
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
	    final int F_TYPE_CUSTOM = 3;
	    
	    final int F_BOOL_TRUE   = 1;
	    final int F_BOOL_FALSE  = 0;

	    /* Map variable name to Integer object holding value */
	    Stack<Hashtable<String, AdeleTypeDes>> m_scope; 
	    
	    /* global symbols */
	    Hashtable<String, Object> m_funTbl;
	    Hashtable<String, AdeleTypeDes> m_glbVar;

	    /* user defined type */
	    int m_curUserTypeId = 0x5566;
	    Hashtable<String, Integer> m_userType;

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

		        m_scope     = new Stack<Hashtable<String, AdeleTypeDes>> (); 
		        m_funTbl    = new Hashtable<String, Object> ();
		        m_glbVar    = new Hashtable<String, AdeleTypeDes> ();
		        m_userType  = new Hashtable<String, Integer> ();

		        /* put the global scope in the bottom of the stack */
		        m_scope.push (m_glbVar);
		    
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
		public Token tid;
		public TerminalNode GROUP() { return getToken(adeleParser.GROUP, 0); }
		public TerminalNode END() { return getToken(adeleParser.END, 0); }
		public List<TerminalNode> ID() { return getTokens(adeleParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(adeleParser.ID, i);
		}
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
			((Type_declarationContext)_localctx).tid = match(ID);
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

			                if (m_userType.containsKey ((((Type_declarationContext)_localctx).tid!=null?((Type_declarationContext)_localctx).tid.getText():null))) {
			                    System.err.println ("Error: group " + (((Type_declarationContext)_localctx).tid!=null?((Type_declarationContext)_localctx).tid.getText():null) + " re-defined.");
			                } else {
			                    m_userType.put (new String ((((Type_declarationContext)_localctx).tid!=null?((Type_declarationContext)_localctx).tid.getText():null)), m_curUserTypeId++);
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

	public static class FuncContext extends ParserRuleContext {
		public Token ID;
		public List<TerminalNode> ID() { return getTokens(adeleParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(adeleParser.ID, i);
		}
		public TerminalNode LPAREN() { return getToken(adeleParser.LPAREN, 0); }
		public PlistContext plist() {
			return getRuleContext(PlistContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(adeleParser.RPAREN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public TerminalNode END() { return getToken(adeleParser.END, 0); }
		public TerminalNode TYPE() { return getToken(adeleParser.TYPE, 0); }
		public TerminalNode GROUP() { return getToken(adeleParser.GROUP, 0); }
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
			setState(53);
			switch (_input.LA(1)) {
			case TYPE:
				{
				setState(50);
				match(TYPE);
				}
				break;
			case GROUP:
				{
				setState(51);
				match(GROUP);
				setState(52);
				((FuncContext)_localctx).ID = match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(55);
			((FuncContext)_localctx).ID = match(ID);
			setState(56);
			match(LPAREN);
			setState(57);
			plist();
			setState(58);
			match(RPAREN);

			                /* insert into the function table */
			                m_funTbl.put ((((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getText():null), new Integer (0));
			                m_scope.push (new Hashtable<String, AdeleTypeDes> ());
			            
			setState(60);
			stmts();

			                m_scope.pop ();
			            
			setState(62);
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
		public List<TerminalNode> TYPE() { return getTokens(adeleParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(adeleParser.TYPE, i);
		}
		public List<TerminalNode> ID() { return getTokens(adeleParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(adeleParser.ID, i);
		}
		public List<TerminalNode> GROUP() { return getTokens(adeleParser.GROUP); }
		public TerminalNode GROUP(int i) {
			return getToken(adeleParser.GROUP, i);
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
			setState(83);
			switch (_input.LA(1)) {
			case RPAREN:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case GROUP:
			case TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(71);
						switch (_input.LA(1)) {
						case TYPE:
							{
							{
							setState(65);
							match(TYPE);
							setState(66);
							match(ID);
							setState(67);
							match(COMMA);
							}
							}
							break;
						case GROUP:
							{
							{
							setState(68);
							match(GROUP);
							setState(69);
							match(ID);
							setState(70);
							match(ID);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						} 
					}
					setState(75);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(81);
				switch (_input.LA(1)) {
				case TYPE:
					{
					setState(76);
					match(TYPE);
					setState(77);
					match(ID);
					}
					break;
				case GROUP:
					{
					setState(78);
					match(GROUP);
					setState(79);
					match(ID);
					setState(80);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << RETURN) | (1L << GROUP) | (1L << LPAREN) | (1L << SEMICOLON) | (1L << TYPE) | (1L << ID) | (1L << NUM))) != 0)) {
				{
				{
				setState(85);
				stmt();
				}
				}
				setState(90);
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
		public TerminalNode RETURN() { return getToken(adeleParser.RETURN, 0); }
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
			setState(104);
			switch (_input.LA(1)) {
			case SEMICOLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				match(SEMICOLON);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				if_stmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				while_stmt();
				}
				break;
			case LPAREN:
			case ID:
			case NUM:
				enterOuterAlt(_localctx, 4);
				{
				setState(94);
				expr(0);
				setState(95);
				match(SEMICOLON);
				}
				break;
			case GROUP:
			case TYPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(97);
				declaration();
				setState(98);
				match(SEMICOLON);
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 6);
				{
				setState(100);
				match(RETURN);
				setState(101);
				expr(0);
				setState(102);
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
			setState(106);
			match(IF);
			setState(107);
			match(LPAREN);
			setState(108);
			((If_stmtContext)_localctx).e1 = expr(0);
			setState(109);
			match(RPAREN);

			                        m_scope.push (new Hashtable<String, AdeleTypeDes> ());
			                    
			setState(111);
			stmts();

			                        m_scope.pop ();
			                    
			setState(113);
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
			setState(115);
			match(WHILE);
			setState(116);
			match(LPAREN);
			setState(117);
			expr(0);
			setState(118);
			match(RPAREN);

			                        m_scope.push (new Hashtable<String, AdeleTypeDes> ());
			                    
			setState(120);
			stmts();

			                        m_scope.pop ();
			                    
			setState(122);
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
		public Token type;
		public Token name;
		public Token ID;
		public ExprContext expr;
		public TerminalNode GROUP() { return getToken(adeleParser.GROUP, 0); }
		public List<TerminalNode> ID() { return getTokens(adeleParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(adeleParser.ID, i);
		}
		public TerminalNode TYPE() { return getToken(adeleParser.TYPE, 0); }
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
			setState(137);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(GROUP);
				setState(125);
				((DeclarationContext)_localctx).type = match(ID);
				setState(126);
				((DeclarationContext)_localctx).name = match(ID);

				                        Hashtable<String, AdeleTypeDes> scp =  m_scope.peek ();
				                        
				                        if (scp.containsKey ((((DeclarationContext)_localctx).name!=null?((DeclarationContext)_localctx).name.getText():null))) {
				                            System.err.println ("Duplicate decalration of variable: " + (((DeclarationContext)_localctx).name!=null?((DeclarationContext)_localctx).name.getText():null));
				                        } else {
				                            AdeleTypeDes id = new AdeleTypeDes (F_TYPE_CUSTOM, null);
				                            id.setTypeName ((((DeclarationContext)_localctx).type!=null?((DeclarationContext)_localctx).type.getText():null));
				                            scp.put ((((DeclarationContext)_localctx).name!=null?((DeclarationContext)_localctx).name.getText():null), id);
				                        }
				                    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				match(TYPE);
				setState(129);
				((DeclarationContext)_localctx).ID = match(ID);

				                        Hashtable<String, AdeleTypeDes> scp =  m_scope.peek ();
				                        
				                        if (scp.containsKey ((((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null))) {
				                            System.err.println ("Duplicate decalration of variable: " + (((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null));
				                        } else {
				                            AdeleTypeDes id = new AdeleTypeDes (F_TYPE_INT, new Integer (0));
				                            scp.put ((((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null), id);
				                        }

				                        System.err.println ("declare var: " + (((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null)); 
				                    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				match(TYPE);
				setState(132);
				((DeclarationContext)_localctx).ID = match(ID);
				setState(133);
				match(EQUAL);
				setState(134);
				((DeclarationContext)_localctx).expr = expr(0);

				                        Hashtable<String, AdeleTypeDes> scp =  m_scope.peek ();
				                        
				                        if (scp.containsKey ((((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null))) {
				                            System.err.println ("Duplicate decalration of variable: " + (((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null));
				                        } else {
				                            AdeleTypeDes id = new AdeleTypeDes (F_TYPE_INT, new Integer (((DeclarationContext)_localctx).expr.value));
				                            scp.put ((((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null), id);
				                        }

				                        System.err.println ("declare var: " + (((DeclarationContext)_localctx).ID!=null?((DeclarationContext)_localctx).ID.getText():null)); 
				                    
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
		public Token ADDITIVE_OP;
		public ExprContext e2;
		public Token MULTIPLICATIVE_OP;
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
		public TerminalNode ADDITIVE_OP() { return getToken(adeleParser.ADDITIVE_OP, 0); }
		public TerminalNode MULTIPLICATIVE_OP() { return getToken(adeleParser.MULTIPLICATIVE_OP, 0); }
		public TerminalNode NE() { return getToken(adeleParser.NE, 0); }
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
			setState(169);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(140);
				((ExprContext)_localctx).ID = match(ID);
				setState(141);
				match(EQUAL);
				setState(142);
				((ExprContext)_localctx).e1 = ((ExprContext)_localctx).expr = expr(3);

				                    int v = ((ExprContext)_localctx).e1.value;

				                    /* find the right scope */
				                    Hashtable<String, AdeleTypeDes> sc = null;
				                    boolean found = false;

				                    for (int i = m_scope.size () - 1; i >= 0; --i) {
				                        
				                        sc = m_scope.elementAt (i);

				                        if (sc.containsKey ((((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null))) {
				                            AdeleTypeDes atd = sc.get ((((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null));
				                            atd.setValue (new Integer (((ExprContext)_localctx).e1.value));
				                            ((ExprContext)_localctx).value =  v;
				                            found = true;
				                            break;
				                        }
				                    }

				                    if (found == false)
				                        System.err.println ("Error: undefined variable " + (((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null));
				                
				}
				break;
			case 2:
				{
				setState(145);
				match(LPAREN);
				setState(146);
				((ExprContext)_localctx).expr = expr(0);
				setState(147);
				match(RPAREN);
				 
				                    ((ExprContext)_localctx).value =  _localctx.value; 
				                
				}
				break;
			case 3:
				{
				setState(150);
				((ExprContext)_localctx).ID = match(ID);
				setState(151);
				match(LPAREN);
				setState(152);
				((ExprContext)_localctx).func_plist = func_plist();
				setState(153);
				match(RPAREN);
				 
				                    //System.out.println ("func: " + (((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null) + " is called"); 
				                    
				                    /* brute force */
				                    if ((((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null).equals ("print")) {
				                        System.out.println ((((ExprContext)_localctx).func_plist!=null?_input.getText(((ExprContext)_localctx).func_plist.start,((ExprContext)_localctx).func_plist.stop):null));
				                    }
				                
				}
				break;
			case 4:
				{
				setState(156);
				((ExprContext)_localctx).ID = match(ID);
				setState(157);
				match(OVERLAY);
				setState(158);
				((ExprContext)_localctx).ID = match(ID);
				setState(159);
				match(AT);
				setState(160);
				match(LPAREN);
				setState(161);
				((ExprContext)_localctx).NUM = match(NUM);
				setState(162);
				match(COMMA);
				setState(163);
				((ExprContext)_localctx).NUM = match(NUM);
				setState(164);
				match(RPAREN);
				}
				break;
			case 5:
				{
				setState(165);
				((ExprContext)_localctx).ID = match(ID);
				 
				                    /* find the right scope */
				                    Hashtable<String, AdeleTypeDes> sc = null;
				                    boolean found = false;

				                    for (int i = m_scope.size () - 1; i >= 0; --i) {
				                        
				                        sc = m_scope.elementAt (i);

				                        if (sc.containsKey ((((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null))) {
				                            AdeleTypeDes atd = sc.get ((((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null));
				                            Integer x = (Integer)atd.getValue ();
				                            ((ExprContext)_localctx).value =  x.intValue ();
				                            found = true;
				                            break;
				                        }
				                    }

				                    if (found == false)
				                        System.err.println ("Error: undefined variable " + (((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null));
				                
				}
				break;
			case 6:
				{
				setState(167);
				((ExprContext)_localctx).NUM = match(NUM);

				                    ((ExprContext)_localctx).value =  Integer.parseInt ((((ExprContext)_localctx).NUM!=null?((ExprContext)_localctx).NUM.getText():null));
				                
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(206);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(171);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(172);
						((ExprContext)_localctx).ADDITIVE_OP = match(ADDITIVE_OP);
						setState(173);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(12);

						                              int e1 = ((ExprContext)_localctx).e1.value;
						                              int e2 = ((ExprContext)_localctx).e2.value;

						                              if ("+".equals ((((ExprContext)_localctx).ADDITIVE_OP!=null?((ExprContext)_localctx).ADDITIVE_OP.getText():null)))                    
						                                  ((ExprContext)_localctx).value =  e1 + e2;
						                              else
						                                  ((ExprContext)_localctx).value =  e1 - e2;
						                              
						                              System.err.println (
						                                  "ADD: " + (((ExprContext)_localctx).ADDITIVE_OP!=null?((ExprContext)_localctx).ADDITIVE_OP.getText():null) + ":"  + 
						                                  _localctx.value + ":" + e1 + ":" + e2);
						                          
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(176);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(177);
						((ExprContext)_localctx).MULTIPLICATIVE_OP = match(MULTIPLICATIVE_OP);
						setState(178);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(11);

						                              if ("*".equals ((((ExprContext)_localctx).MULTIPLICATIVE_OP!=null?((ExprContext)_localctx).MULTIPLICATIVE_OP.getText():null)))
						                                  ((ExprContext)_localctx).value =  ((ExprContext)_localctx).e1.value * ((ExprContext)_localctx).e2.value;
						                              else
						                                  ((ExprContext)_localctx).value =  ((ExprContext)_localctx).e1.value / ((ExprContext)_localctx).e2.value;
						                          
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(181);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(182);
						match(NE);
						setState(183);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(10);

						                              if (((ExprContext)_localctx).e1.value == ((ExprContext)_localctx).e2.value)
						                                  ((ExprContext)_localctx).value =  F_BOOL_TRUE;
						                              else
						                                  ((ExprContext)_localctx).value =  F_BOOL_FALSE;;
						                          
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(186);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(187);
						match(GT);
						setState(188);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(9);

						                              if (((ExprContext)_localctx).e1.value - ((ExprContext)_localctx).e2.value > 0)
						                                  ((ExprContext)_localctx).value =  F_BOOL_TRUE;
						                              else
						                                  ((ExprContext)_localctx).value =  F_BOOL_FALSE;;
						                          
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(191);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(192);
						match(LT);
						setState(193);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(8);

						                              if (((ExprContext)_localctx).e1.value - ((ExprContext)_localctx).e2.value < 0)
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
						setState(196);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(197);
						match(GET);
						setState(198);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(7);

						                              if (((ExprContext)_localctx).e1.value - ((ExprContext)_localctx).e2.value >= 0)
						                                  ((ExprContext)_localctx).value =  F_BOOL_TRUE;
						                              else
						                                  ((ExprContext)_localctx).value =  F_BOOL_FALSE;
						                          
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(201);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(202);
						match(LET);
						setState(203);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(6);

						                              if (((ExprContext)_localctx).e1.value - ((ExprContext)_localctx).e2.value <= 0)
						                                  ((ExprContext)_localctx).value =  F_BOOL_TRUE;
						                              else
						                                  ((ExprContext)_localctx).value =  F_BOOL_FALSE;
						                          
						}
						break;
					}
					} 
				}
				setState(210);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
			setState(221);
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
				setState(217);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(212);
						fpitem();
						setState(213);
						match(COMMA);
						}
						} 
					}
					setState(219);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				setState(220);
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
			setState(223);
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
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\32\u00e4\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\7\2!\n\2\f\2\16\2$\13\2"+
		"\5\2&\n\2\3\3\3\3\3\3\3\3\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\5\48\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\7\5J\n\5\f\5\16\5M\13\5\3\5\3\5\3\5\3\5\3\5\5\5T\n\5\5"+
		"\5V\n\5\3\6\7\6Y\n\6\f\6\16\6\\\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\5\7k\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u008c\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00ac\n\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\7\13\u00d1\n\13\f\13\16\13\u00d4\13\13\3\f\3\f\3\f\3\f"+
		"\7\f\u00da\n\f\f\f\16\f\u00dd\13\f\3\f\5\f\u00e0\n\f\3\r\3\r\3\r\2\3\24"+
		"\16\2\4\6\b\n\f\16\20\22\24\26\30\2\3\3\2\27\31\u00f7\2%\3\2\2\2\4\'\3"+
		"\2\2\2\6\67\3\2\2\2\bU\3\2\2\2\nZ\3\2\2\2\fj\3\2\2\2\16l\3\2\2\2\20u\3"+
		"\2\2\2\22\u008b\3\2\2\2\24\u00ab\3\2\2\2\26\u00df\3\2\2\2\30\u00e1\3\2"+
		"\2\2\32&\3\2\2\2\33!\5\6\4\2\34!\5\4\3\2\35\36\5\22\n\2\36\37\7\13\2\2"+
		"\37!\3\2\2\2 \33\3\2\2\2 \34\3\2\2\2 \35\3\2\2\2!$\3\2\2\2\" \3\2\2\2"+
		"\"#\3\2\2\2#&\3\2\2\2$\"\3\2\2\2%\32\3\2\2\2%\"\3\2\2\2&\3\3\2\2\2\'("+
		"\7\7\2\2(.\7\27\2\2)*\7\26\2\2*+\7\27\2\2+-\7\13\2\2,)\3\2\2\2-\60\3\2"+
		"\2\2.,\3\2\2\2./\3\2\2\2/\61\3\2\2\2\60.\3\2\2\2\61\62\7\4\2\2\62\63\b"+
		"\3\1\2\63\5\3\2\2\2\648\7\26\2\2\65\66\7\7\2\2\668\7\27\2\2\67\64\3\2"+
		"\2\2\67\65\3\2\2\289\3\2\2\29:\7\27\2\2:;\7\b\2\2;<\5\b\5\2<=\7\t\2\2"+
		"=>\b\4\1\2>?\5\n\6\2?@\b\4\1\2@A\7\4\2\2A\7\3\2\2\2BV\3\2\2\2CD\7\26\2"+
		"\2DE\7\27\2\2EJ\7\n\2\2FG\7\7\2\2GH\7\27\2\2HJ\7\27\2\2IC\3\2\2\2IF\3"+
		"\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LS\3\2\2\2MK\3\2\2\2NO\7\26\2\2OT"+
		"\7\27\2\2PQ\7\7\2\2QR\7\27\2\2RT\7\27\2\2SN\3\2\2\2SP\3\2\2\2TV\3\2\2"+
		"\2UB\3\2\2\2UK\3\2\2\2V\t\3\2\2\2WY\5\f\7\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2"+
		"\2\2Z[\3\2\2\2[\13\3\2\2\2\\Z\3\2\2\2]k\7\13\2\2^k\5\16\b\2_k\5\20\t\2"+
		"`a\5\24\13\2ab\7\13\2\2bk\3\2\2\2cd\5\22\n\2de\7\13\2\2ek\3\2\2\2fg\7"+
		"\6\2\2gh\5\24\13\2hi\7\13\2\2ik\3\2\2\2j]\3\2\2\2j^\3\2\2\2j_\3\2\2\2"+
		"j`\3\2\2\2jc\3\2\2\2jf\3\2\2\2k\r\3\2\2\2lm\7\3\2\2mn\7\b\2\2no\5\24\13"+
		"\2op\7\t\2\2pq\b\b\1\2qr\5\n\6\2rs\b\b\1\2st\7\4\2\2t\17\3\2\2\2uv\7\5"+
		"\2\2vw\7\b\2\2wx\5\24\13\2xy\7\t\2\2yz\b\t\1\2z{\5\n\6\2{|\b\t\1\2|}\7"+
		"\4\2\2}\21\3\2\2\2~\177\7\7\2\2\177\u0080\7\27\2\2\u0080\u0081\7\27\2"+
		"\2\u0081\u008c\b\n\1\2\u0082\u0083\7\26\2\2\u0083\u0084\7\27\2\2\u0084"+
		"\u008c\b\n\1\2\u0085\u0086\7\26\2\2\u0086\u0087\7\27\2\2\u0087\u0088\7"+
		"\f\2\2\u0088\u0089\5\24\13\2\u0089\u008a\b\n\1\2\u008a\u008c\3\2\2\2\u008b"+
		"~\3\2\2\2\u008b\u0082\3\2\2\2\u008b\u0085\3\2\2\2\u008c\23\3\2\2\2\u008d"+
		"\u008e\b\13\1\2\u008e\u008f\7\27\2\2\u008f\u0090\7\f\2\2\u0090\u0091\5"+
		"\24\13\5\u0091\u0092\b\13\1\2\u0092\u00ac\3\2\2\2\u0093\u0094\7\b\2\2"+
		"\u0094\u0095\5\24\13\2\u0095\u0096\7\t\2\2\u0096\u0097\b\13\1\2\u0097"+
		"\u00ac\3\2\2\2\u0098\u0099\7\27\2\2\u0099\u009a\7\b\2\2\u009a\u009b\5"+
		"\26\f\2\u009b\u009c\7\t\2\2\u009c\u009d\b\13\1\2\u009d\u00ac\3\2\2\2\u009e"+
		"\u009f\7\27\2\2\u009f\u00a0\7\r\2\2\u00a0\u00a1\7\27\2\2\u00a1\u00a2\7"+
		"\16\2\2\u00a2\u00a3\7\b\2\2\u00a3\u00a4\7\30\2\2\u00a4\u00a5\7\n\2\2\u00a5"+
		"\u00a6\7\30\2\2\u00a6\u00ac\7\t\2\2\u00a7\u00a8\7\27\2\2\u00a8\u00ac\b"+
		"\13\1\2\u00a9\u00aa\7\30\2\2\u00aa\u00ac\b\13\1\2\u00ab\u008d\3\2\2\2"+
		"\u00ab\u0093\3\2\2\2\u00ab\u0098\3\2\2\2\u00ab\u009e\3\2\2\2\u00ab\u00a7"+
		"\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00d2\3\2\2\2\u00ad\u00ae\f\r\2\2\u00ae"+
		"\u00af\7\24\2\2\u00af\u00b0\5\24\13\16\u00b0\u00b1\b\13\1\2\u00b1\u00d1"+
		"\3\2\2\2\u00b2\u00b3\f\f\2\2\u00b3\u00b4\7\25\2\2\u00b4\u00b5\5\24\13"+
		"\r\u00b5\u00b6\b\13\1\2\u00b6\u00d1\3\2\2\2\u00b7\u00b8\f\13\2\2\u00b8"+
		"\u00b9\7\23\2\2\u00b9\u00ba\5\24\13\f\u00ba\u00bb\b\13\1\2\u00bb\u00d1"+
		"\3\2\2\2\u00bc\u00bd\f\n\2\2\u00bd\u00be\7\17\2\2\u00be\u00bf\5\24\13"+
		"\13\u00bf\u00c0\b\13\1\2\u00c0\u00d1\3\2\2\2\u00c1\u00c2\f\t\2\2\u00c2"+
		"\u00c3\7\20\2\2\u00c3\u00c4\5\24\13\n\u00c4\u00c5\b\13\1\2\u00c5\u00d1"+
		"\3\2\2\2\u00c6\u00c7\f\b\2\2\u00c7\u00c8\7\21\2\2\u00c8\u00c9\5\24\13"+
		"\t\u00c9\u00ca\b\13\1\2\u00ca\u00d1\3\2\2\2\u00cb\u00cc\f\7\2\2\u00cc"+
		"\u00cd\7\22\2\2\u00cd\u00ce\5\24\13\b\u00ce\u00cf\b\13\1\2\u00cf\u00d1"+
		"\3\2\2\2\u00d0\u00ad\3\2\2\2\u00d0\u00b2\3\2\2\2\u00d0\u00b7\3\2\2\2\u00d0"+
		"\u00bc\3\2\2\2\u00d0\u00c1\3\2\2\2\u00d0\u00c6\3\2\2\2\u00d0\u00cb\3\2"+
		"\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\25\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00e0\3\2\2\2\u00d6\u00d7\5\30\r"+
		"\2\u00d7\u00d8\7\n\2\2\u00d8\u00da\3\2\2\2\u00d9\u00d6\3\2\2\2\u00da\u00dd"+
		"\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd"+
		"\u00db\3\2\2\2\u00de\u00e0\5\30\r\2\u00df\u00d5\3\2\2\2\u00df\u00db\3"+
		"\2\2\2\u00e0\27\3\2\2\2\u00e1\u00e2\t\2\2\2\u00e2\31\3\2\2\2\23 \"%.\67"+
		"IKSUZj\u008b\u00ab\u00d0\u00d2\u00db\u00df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}