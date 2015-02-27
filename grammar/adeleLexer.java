// Generated from ./adele.g4 by ANTLR 4.5

    import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class adeleLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, END=2, WHILE=3, RETURN=4, GROUP=5, ADD=6, SUB=7, MULTI=8, DIV=9, 
		LPAREN=10, RPAREN=11, COMMA=12, SEMICOLON=13, EQUAL=14, OVERLAY=15, AT=16, 
		GT=17, LT=18, GET=19, LET=20, TYPE=21, ID=22, NUM=23, STR=24, WS=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"IF", "END", "WHILE", "RETURN", "GROUP", "ADD", "SUB", "MULTI", "DIV", 
		"LPAREN", "RPAREN", "COMMA", "SEMICOLON", "EQUAL", "OVERLAY", "AT", "GT", 
		"LT", "GET", "LET", "INT", "FLOAT", "CHAR", "VOID", "BOOL", "TYPE", "ID", 
		"FLOAT_NUM", "INT_NUM", "CHR", "NUM", "STR", "WS"
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


	public adeleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "adele.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u00de\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3"+
		"\33\5\33\u009f\n\33\3\34\6\34\u00a2\n\34\r\34\16\34\u00a3\3\34\7\34\u00a7"+
		"\n\34\f\34\16\34\u00aa\13\34\3\35\5\35\u00ad\n\35\3\35\6\35\u00b0\n\35"+
		"\r\35\16\35\u00b1\3\35\3\35\6\35\u00b6\n\35\r\35\16\35\u00b7\3\36\5\36"+
		"\u00bb\n\36\3\36\6\36\u00be\n\36\r\36\16\36\u00bf\3\36\7\36\u00c3\n\36"+
		"\f\36\16\36\u00c6\13\36\3\36\5\36\u00c9\n\36\3\37\3\37\3 \3 \3!\3!\7!"+
		"\u00d1\n!\f!\16!\u00d4\13!\3!\3!\3\"\6\"\u00d9\n\"\r\"\16\"\u00da\3\""+
		"\3\"\2\2#\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\2-\2/\2\61\2\63\2\65\27\67\309\2"+
		";\2=\2?\31A\32C\33\3\2\t\5\2C\\aac|\6\2\62;C\\aac|\3\2//\3\2\62;\3\2\63"+
		";\3\2\62\62\5\2\13\f\17\17\"\"\u00e4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2"+
		"\2\2\5H\3\2\2\2\7L\3\2\2\2\tR\3\2\2\2\13Y\3\2\2\2\r_\3\2\2\2\17a\3\2\2"+
		"\2\21c\3\2\2\2\23e\3\2\2\2\25g\3\2\2\2\27i\3\2\2\2\31k\3\2\2\2\33m\3\2"+
		"\2\2\35o\3\2\2\2\37q\3\2\2\2!t\3\2\2\2#v\3\2\2\2%x\3\2\2\2\'z\3\2\2\2"+
		")}\3\2\2\2+\u0080\3\2\2\2-\u0084\3\2\2\2/\u008a\3\2\2\2\61\u008f\3\2\2"+
		"\2\63\u0094\3\2\2\2\65\u009e\3\2\2\2\67\u00a1\3\2\2\29\u00ac\3\2\2\2;"+
		"\u00c8\3\2\2\2=\u00ca\3\2\2\2?\u00cc\3\2\2\2A\u00ce\3\2\2\2C\u00d8\3\2"+
		"\2\2EF\7k\2\2FG\7h\2\2G\4\3\2\2\2HI\7g\2\2IJ\7p\2\2JK\7f\2\2K\6\3\2\2"+
		"\2LM\7y\2\2MN\7j\2\2NO\7k\2\2OP\7n\2\2PQ\7g\2\2Q\b\3\2\2\2RS\7t\2\2ST"+
		"\7g\2\2TU\7v\2\2UV\7w\2\2VW\7t\2\2WX\7p\2\2X\n\3\2\2\2YZ\7i\2\2Z[\7t\2"+
		"\2[\\\7q\2\2\\]\7w\2\2]^\7r\2\2^\f\3\2\2\2_`\7-\2\2`\16\3\2\2\2ab\7/\2"+
		"\2b\20\3\2\2\2cd\7,\2\2d\22\3\2\2\2ef\7\61\2\2f\24\3\2\2\2gh\7*\2\2h\26"+
		"\3\2\2\2ij\7+\2\2j\30\3\2\2\2kl\7.\2\2l\32\3\2\2\2mn\7=\2\2n\34\3\2\2"+
		"\2op\7?\2\2p\36\3\2\2\2qr\7\61\2\2rs\7\61\2\2s \3\2\2\2tu\7B\2\2u\"\3"+
		"\2\2\2vw\7@\2\2w$\3\2\2\2xy\7>\2\2y&\3\2\2\2z{\7@\2\2{|\7?\2\2|(\3\2\2"+
		"\2}~\7>\2\2~\177\7?\2\2\177*\3\2\2\2\u0080\u0081\7k\2\2\u0081\u0082\7"+
		"p\2\2\u0082\u0083\7v\2\2\u0083,\3\2\2\2\u0084\u0085\7h\2\2\u0085\u0086"+
		"\7n\2\2\u0086\u0087\7q\2\2\u0087\u0088\7c\2\2\u0088\u0089\7v\2\2\u0089"+
		".\3\2\2\2\u008a\u008b\7e\2\2\u008b\u008c\7j\2\2\u008c\u008d\7c\2\2\u008d"+
		"\u008e\7t\2\2\u008e\60\3\2\2\2\u008f\u0090\7x\2\2\u0090\u0091\7q\2\2\u0091"+
		"\u0092\7k\2\2\u0092\u0093\7f\2\2\u0093\62\3\2\2\2\u0094\u0095\7d\2\2\u0095"+
		"\u0096\7q\2\2\u0096\u0097\7q\2\2\u0097\u0098\7n\2\2\u0098\64\3\2\2\2\u0099"+
		"\u009f\5+\26\2\u009a\u009f\5-\27\2\u009b\u009f\5/\30\2\u009c\u009f\5\63"+
		"\32\2\u009d\u009f\5\61\31\2\u009e\u0099\3\2\2\2\u009e\u009a\3\2\2\2\u009e"+
		"\u009b\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f\66\3\2\2"+
		"\2\u00a0\u00a2\t\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a8\3\2\2\2\u00a5\u00a7\t\3\2\2\u00a6"+
		"\u00a5\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2"+
		"\2\2\u00a98\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ad\t\4\2\2\u00ac\u00ab"+
		"\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u00b0\t\5\2\2\u00af"+
		"\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\7\60\2\2\u00b4\u00b6\t\5\2\2\u00b5"+
		"\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2"+
		"\2\2\u00b8:\3\2\2\2\u00b9\u00bb\t\4\2\2\u00ba\u00b9\3\2\2\2\u00ba\u00bb"+
		"\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00be\t\6\2\2\u00bd\u00bc\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c4\3\2"+
		"\2\2\u00c1\u00c3\t\5\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c9\3\2\2\2\u00c6\u00c4\3\2"+
		"\2\2\u00c7\u00c9\t\7\2\2\u00c8\u00ba\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9"+
		"<\3\2\2\2\u00ca\u00cb\t\3\2\2\u00cb>\3\2\2\2\u00cc\u00cd\5;\36\2\u00cd"+
		"@\3\2\2\2\u00ce\u00d2\7$\2\2\u00cf\u00d1\5=\37\2\u00d0\u00cf\3\2\2\2\u00d1"+
		"\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2"+
		"\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\7$\2\2\u00d6B\3\2\2\2\u00d7\u00d9"+
		"\t\b\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\b\"\2\2\u00ddD\3\2\2\2"+
		"\17\2\u009e\u00a3\u00a8\u00ac\u00b1\u00b7\u00ba\u00bf\u00c4\u00c8\u00d2"+
		"\u00da\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}