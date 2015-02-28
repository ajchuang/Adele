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
		ADDITIVE_OP=17, MULTIPLICATIVE_OP=18, TYPE=19, ID=20, NUM=21, STR=22, 
		WS=23;
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
		"','", "';'", "'='", "'//'", "'@'", "'>'", "'<'", "'>='", "'<='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "IF", "END", "WHILE", "RETURN", "GROUP", "LPAREN", "RPAREN", "COMMA", 
		"SEMICOLON", "EQUAL", "OVERLAY", "AT", "GT", "LT", "GET", "LET", "ADDITIVE_OP", 
		"MULTIPLICATIVE_OP", "TYPE", "ID", "NUM", "STR", "WS"
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

			                /* insert into the function table */
			                m_funTbl.put ((((FuncContext)_localctx).ID!=null?((FuncContext)_localctx).ID.getText():null), new Integer (0));
			                m_scope.push (new Hashtable<String, AdeleTypeDes> ());
			            
			setState(55);
			stmts();

			                m_scope.pop ();
			            
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
			setState(70);
			switch (_input.LA(1)) {
			case RPAREN:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(60);
						match(TYPE);
						setState(61);
						match(ID);
						setState(62);
						match(COMMA);
						}
						} 
					}
					setState(67);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(68);
				match(TYPE);
				setState(69);
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
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << RETURN) | (1L << GROUP) | (1L << LPAREN) | (1L << SEMICOLON) | (1L << TYPE) | (1L << ID) | (1L << NUM))) != 0)) {
				{
				{
				setState(72);
				stmt();
				}
				}
				setState(77);
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
			setState(87);
			switch (_input.LA(1)) {
			case SEMICOLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(SEMICOLON);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				if_stmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				while_stmt();
				}
				break;
			case RETURN:
			case LPAREN:
			case ID:
			case NUM:
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				expr(0);
				setState(82);
				match(SEMICOLON);
				}
				break;
			case GROUP:
			case TYPE:
				enterOuterAlt(_localctx, 5);
				{
				setState(84);
				declaration();
				setState(85);
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
			setState(89);
			match(IF);
			setState(90);
			match(LPAREN);
			setState(91);
			((If_stmtContext)_localctx).e1 = expr(0);
			setState(92);
			match(RPAREN);

			                        m_scope.push (new Hashtable<String, AdeleTypeDes> ());
			                    
			setState(94);
			stmts();

			                        m_scope.pop ();
			                    
			setState(96);
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
			setState(98);
			match(WHILE);
			setState(99);
			match(LPAREN);
			setState(100);
			expr(0);
			setState(101);
			match(RPAREN);

			                        m_scope.push (new Hashtable<String, AdeleTypeDes> ());
			                    
			setState(103);
			stmts();

			                        m_scope.pop ();
			                    
			setState(105);
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
			setState(120);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				match(GROUP);
				setState(108);
				((DeclarationContext)_localctx).type = match(ID);
				setState(109);
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
				setState(111);
				match(TYPE);
				setState(112);
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
				setState(114);
				match(TYPE);
				setState(115);
				((DeclarationContext)_localctx).ID = match(ID);
				setState(116);
				match(EQUAL);
				setState(117);
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
		public TerminalNode ADDITIVE_OP() { return getToken(adeleParser.ADDITIVE_OP, 0); }
		public TerminalNode MULTIPLICATIVE_OP() { return getToken(adeleParser.MULTIPLICATIVE_OP, 0); }
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
			setState(156);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(123);
				((ExprContext)_localctx).ID = match(ID);
				setState(124);
				match(EQUAL);
				setState(125);
				((ExprContext)_localctx).e1 = ((ExprContext)_localctx).expr = expr(4);

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
				setState(128);
				match(RETURN);
				setState(129);
				((ExprContext)_localctx).expr = expr(3);

				                    ((ExprContext)_localctx).value =  _localctx.value;
				                
				}
				break;
			case 3:
				{
				setState(132);
				match(LPAREN);
				setState(133);
				((ExprContext)_localctx).expr = expr(0);
				setState(134);
				match(RPAREN);
				 
				                    ((ExprContext)_localctx).value =  _localctx.value; 
				                
				}
				break;
			case 4:
				{
				setState(137);
				((ExprContext)_localctx).ID = match(ID);
				setState(138);
				match(LPAREN);
				setState(139);
				((ExprContext)_localctx).func_plist = func_plist();
				setState(140);
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
				setState(143);
				((ExprContext)_localctx).ID = match(ID);
				setState(144);
				match(OVERLAY);
				setState(145);
				((ExprContext)_localctx).ID = match(ID);
				setState(146);
				match(AT);
				setState(147);
				match(LPAREN);
				setState(148);
				((ExprContext)_localctx).NUM = match(NUM);
				setState(149);
				match(COMMA);
				setState(150);
				((ExprContext)_localctx).NUM = match(NUM);
				setState(151);
				match(RPAREN);
				}
				break;
			case 6:
				{
				setState(152);
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
			case 7:
				{
				setState(154);
				((ExprContext)_localctx).NUM = match(NUM);

				                    ((ExprContext)_localctx).value =  Integer.parseInt ((((ExprContext)_localctx).NUM!=null?((ExprContext)_localctx).NUM.getText():null));
				                
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(190);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(188);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(158);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(159);
						((ExprContext)_localctx).ADDITIVE_OP = match(ADDITIVE_OP);
						setState(160);
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
						setState(163);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(164);
						((ExprContext)_localctx).MULTIPLICATIVE_OP = match(MULTIPLICATIVE_OP);
						setState(165);
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
						setState(168);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(169);
						match(GT);
						setState(170);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(10);

						                              if (((ExprContext)_localctx).e1.value - ((ExprContext)_localctx).e2.value > 0)
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
						setState(173);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(174);
						match(LT);
						setState(175);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(9);

						                              if (((ExprContext)_localctx).e1.value - ((ExprContext)_localctx).e2.value < 0)
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
						setState(178);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(179);
						match(GET);
						setState(180);
						((ExprContext)_localctx).e2 = ((ExprContext)_localctx).expr = expr(8);

						                              if (((ExprContext)_localctx).e1.value - ((ExprContext)_localctx).e2.value >= 0)
						                                  ((ExprContext)_localctx).value =  F_BOOL_TRUE;
						                              else
						                                  ((ExprContext)_localctx).value =  F_BOOL_FALSE;
						                          
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(183);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(184);
						match(LET);
						setState(185);
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
				setState(192);
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
			setState(203);
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
				setState(199);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(194);
						fpitem();
						setState(195);
						match(COMMA);
						}
						} 
					}
					setState(201);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				setState(202);
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
			setState(205);
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
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\31\u00d2\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\7\2!\n\2\f\2\16\2$\13\2"+
		"\5\2&\n\2\3\3\3\3\3\3\3\3\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5B\n\5\f\5\16\5E"+
		"\13\5\3\5\3\5\5\5I\n\5\3\6\7\6L\n\6\f\6\16\6O\13\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\5\7Z\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\5\n{\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u009f\n\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\7\13\u00bf\n\13\f\13\16\13\u00c2\13\13\3\f\3\f\3\f\3\f\7\f\u00c8"+
		"\n\f\f\f\16\f\u00cb\13\f\3\f\5\f\u00ce\n\f\3\r\3\r\3\r\2\3\24\16\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\2\3\3\2\26\30\u00e1\2%\3\2\2\2\4\'\3\2\2\2\6"+
		"\63\3\2\2\2\bH\3\2\2\2\nM\3\2\2\2\fY\3\2\2\2\16[\3\2\2\2\20d\3\2\2\2\22"+
		"z\3\2\2\2\24\u009e\3\2\2\2\26\u00cd\3\2\2\2\30\u00cf\3\2\2\2\32&\3\2\2"+
		"\2\33!\5\6\4\2\34!\5\4\3\2\35\36\5\22\n\2\36\37\7\13\2\2\37!\3\2\2\2 "+
		"\33\3\2\2\2 \34\3\2\2\2 \35\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#&"+
		"\3\2\2\2$\"\3\2\2\2%\32\3\2\2\2%\"\3\2\2\2&\3\3\2\2\2\'(\7\7\2\2(.\7\26"+
		"\2\2)*\7\25\2\2*+\7\26\2\2+-\7\13\2\2,)\3\2\2\2-\60\3\2\2\2.,\3\2\2\2"+
		"./\3\2\2\2/\61\3\2\2\2\60.\3\2\2\2\61\62\7\4\2\2\62\5\3\2\2\2\63\64\7"+
		"\25\2\2\64\65\7\26\2\2\65\66\7\b\2\2\66\67\5\b\5\2\678\7\t\2\289\b\4\1"+
		"\29:\5\n\6\2:;\b\4\1\2;<\7\4\2\2<\7\3\2\2\2=I\3\2\2\2>?\7\25\2\2?@\7\26"+
		"\2\2@B\7\n\2\2A>\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2"+
		"\2\2FG\7\25\2\2GI\7\26\2\2H=\3\2\2\2HC\3\2\2\2I\t\3\2\2\2JL\5\f\7\2KJ"+
		"\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\13\3\2\2\2OM\3\2\2\2PZ\7\13\2"+
		"\2QZ\5\16\b\2RZ\5\20\t\2ST\5\24\13\2TU\7\13\2\2UZ\3\2\2\2VW\5\22\n\2W"+
		"X\7\13\2\2XZ\3\2\2\2YP\3\2\2\2YQ\3\2\2\2YR\3\2\2\2YS\3\2\2\2YV\3\2\2\2"+
		"Z\r\3\2\2\2[\\\7\3\2\2\\]\7\b\2\2]^\5\24\13\2^_\7\t\2\2_`\b\b\1\2`a\5"+
		"\n\6\2ab\b\b\1\2bc\7\4\2\2c\17\3\2\2\2de\7\5\2\2ef\7\b\2\2fg\5\24\13\2"+
		"gh\7\t\2\2hi\b\t\1\2ij\5\n\6\2jk\b\t\1\2kl\7\4\2\2l\21\3\2\2\2mn\7\7\2"+
		"\2no\7\26\2\2op\7\26\2\2p{\b\n\1\2qr\7\25\2\2rs\7\26\2\2s{\b\n\1\2tu\7"+
		"\25\2\2uv\7\26\2\2vw\7\f\2\2wx\5\24\13\2xy\b\n\1\2y{\3\2\2\2zm\3\2\2\2"+
		"zq\3\2\2\2zt\3\2\2\2{\23\3\2\2\2|}\b\13\1\2}~\7\26\2\2~\177\7\f\2\2\177"+
		"\u0080\5\24\13\6\u0080\u0081\b\13\1\2\u0081\u009f\3\2\2\2\u0082\u0083"+
		"\7\6\2\2\u0083\u0084\5\24\13\5\u0084\u0085\b\13\1\2\u0085\u009f\3\2\2"+
		"\2\u0086\u0087\7\b\2\2\u0087\u0088\5\24\13\2\u0088\u0089\7\t\2\2\u0089"+
		"\u008a\b\13\1\2\u008a\u009f\3\2\2\2\u008b\u008c\7\26\2\2\u008c\u008d\7"+
		"\b\2\2\u008d\u008e\5\26\f\2\u008e\u008f\7\t\2\2\u008f\u0090\b\13\1\2\u0090"+
		"\u009f\3\2\2\2\u0091\u0092\7\26\2\2\u0092\u0093\7\r\2\2\u0093\u0094\7"+
		"\26\2\2\u0094\u0095\7\16\2\2\u0095\u0096\7\b\2\2\u0096\u0097\7\27\2\2"+
		"\u0097\u0098\7\n\2\2\u0098\u0099\7\27\2\2\u0099\u009f\7\t\2\2\u009a\u009b"+
		"\7\26\2\2\u009b\u009f\b\13\1\2\u009c\u009d\7\27\2\2\u009d\u009f\b\13\1"+
		"\2\u009e|\3\2\2\2\u009e\u0082\3\2\2\2\u009e\u0086\3\2\2\2\u009e\u008b"+
		"\3\2\2\2\u009e\u0091\3\2\2\2\u009e\u009a\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u00c0\3\2\2\2\u00a0\u00a1\f\r\2\2\u00a1\u00a2\7\23\2\2\u00a2\u00a3\5"+
		"\24\13\16\u00a3\u00a4\b\13\1\2\u00a4\u00bf\3\2\2\2\u00a5\u00a6\f\f\2\2"+
		"\u00a6\u00a7\7\24\2\2\u00a7\u00a8\5\24\13\r\u00a8\u00a9\b\13\1\2\u00a9"+
		"\u00bf\3\2\2\2\u00aa\u00ab\f\13\2\2\u00ab\u00ac\7\17\2\2\u00ac\u00ad\5"+
		"\24\13\f\u00ad\u00ae\b\13\1\2\u00ae\u00bf\3\2\2\2\u00af\u00b0\f\n\2\2"+
		"\u00b0\u00b1\7\20\2\2\u00b1\u00b2\5\24\13\13\u00b2\u00b3\b\13\1\2\u00b3"+
		"\u00bf\3\2\2\2\u00b4\u00b5\f\t\2\2\u00b5\u00b6\7\21\2\2\u00b6\u00b7\5"+
		"\24\13\n\u00b7\u00b8\b\13\1\2\u00b8\u00bf\3\2\2\2\u00b9\u00ba\f\b\2\2"+
		"\u00ba\u00bb\7\22\2\2\u00bb\u00bc\5\24\13\t\u00bc\u00bd\b\13\1\2\u00bd"+
		"\u00bf\3\2\2\2\u00be\u00a0\3\2\2\2\u00be\u00a5\3\2\2\2\u00be\u00aa\3\2"+
		"\2\2\u00be\u00af\3\2\2\2\u00be\u00b4\3\2\2\2\u00be\u00b9\3\2\2\2\u00bf"+
		"\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\25\3\2\2"+
		"\2\u00c2\u00c0\3\2\2\2\u00c3\u00ce\3\2\2\2\u00c4\u00c5\5\30\r\2\u00c5"+
		"\u00c6\7\n\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00c4\3\2\2\2\u00c8\u00cb\3\2"+
		"\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb"+
		"\u00c9\3\2\2\2\u00cc\u00ce\5\30\r\2\u00cd\u00c3\3\2\2\2\u00cd\u00c9\3"+
		"\2\2\2\u00ce\27\3\2\2\2\u00cf\u00d0\t\2\2\2\u00d0\31\3\2\2\2\20 \"%.C"+
		"HMYz\u009e\u00be\u00c0\u00c9\u00cd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}