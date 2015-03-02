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
		IF=1, END=2, WHILE=3, RETURN=4, GROUP=5, LPAREN=6, RPAREN=7, COMMA=8, 
		SEMICOLON=9, EQUAL=10, OVERLAY=11, AT=12, GT=13, LT=14, GET=15, LET=16, 
		ADDITIVE_OP=17, MULTIPLICATIVE_OP=18, TYPE=19, ID=20, NUM=21, STR=22, 
		WS=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"IF", "END", "WHILE", "RETURN", "GROUP", "ADD", "SUB", "MULTI", "DIV", 
		"LPAREN", "RPAREN", "COMMA", "SEMICOLON", "EQUAL", "OVERLAY", "AT", "GT", 
		"LT", "GET", "LET", "ADDITIVE_OP", "MULTIPLICATIVE_OP", "INT", "FLOAT", 
		"CHAR", "VOID", "BOOL", "STRING", "TYPE", "ID", "FLOAT_NUM", "INT_NUM", 
		"CHR", "NUM", "STR", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u00f4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\26\3\26\5\26\u0089\n\26\3\27\3\27\5\27\u008d\n\27\3\30\3"+
		"\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u00b5\n\36\3\37\6\37"+
		"\u00b8\n\37\r\37\16\37\u00b9\3\37\7\37\u00bd\n\37\f\37\16\37\u00c0\13"+
		"\37\3 \5 \u00c3\n \3 \6 \u00c6\n \r \16 \u00c7\3 \3 \6 \u00cc\n \r \16"+
		" \u00cd\3!\5!\u00d1\n!\3!\6!\u00d4\n!\r!\16!\u00d5\3!\7!\u00d9\n!\f!\16"+
		"!\u00dc\13!\3!\5!\u00df\n!\3\"\3\"\3#\3#\3$\3$\7$\u00e7\n$\f$\16$\u00ea"+
		"\13$\3$\3$\3%\6%\u00ef\n%\r%\16%\u00f0\3%\3%\2\2&\3\3\5\4\7\5\t\6\13\7"+
		"\r\2\17\2\21\2\23\2\25\b\27\t\31\n\33\13\35\f\37\r!\16#\17%\20\'\21)\22"+
		"+\23-\24/\2\61\2\63\2\65\2\67\29\2;\25=\26?\2A\2C\2E\27G\30I\31\3\2\t"+
		"\5\2C\\aac|\6\2\62;C\\aac|\3\2//\3\2\62;\3\2\63;\3\2\62\62\5\2\13\f\17"+
		"\17\"\"\u00f8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\3K\3\2\2\2\5N\3\2\2\2\7R\3\2\2\2\tX\3\2\2\2\13_\3\2\2\2\re\3"+
		"\2\2\2\17g\3\2\2\2\21i\3\2\2\2\23k\3\2\2\2\25m\3\2\2\2\27o\3\2\2\2\31"+
		"q\3\2\2\2\33s\3\2\2\2\35u\3\2\2\2\37w\3\2\2\2!z\3\2\2\2#|\3\2\2\2%~\3"+
		"\2\2\2\'\u0080\3\2\2\2)\u0083\3\2\2\2+\u0088\3\2\2\2-\u008c\3\2\2\2/\u008e"+
		"\3\2\2\2\61\u0092\3\2\2\2\63\u0098\3\2\2\2\65\u009d\3\2\2\2\67\u00a2\3"+
		"\2\2\29\u00a7\3\2\2\2;\u00b4\3\2\2\2=\u00b7\3\2\2\2?\u00c2\3\2\2\2A\u00de"+
		"\3\2\2\2C\u00e0\3\2\2\2E\u00e2\3\2\2\2G\u00e4\3\2\2\2I\u00ee\3\2\2\2K"+
		"L\7k\2\2LM\7h\2\2M\4\3\2\2\2NO\7g\2\2OP\7p\2\2PQ\7f\2\2Q\6\3\2\2\2RS\7"+
		"y\2\2ST\7j\2\2TU\7k\2\2UV\7n\2\2VW\7g\2\2W\b\3\2\2\2XY\7t\2\2YZ\7g\2\2"+
		"Z[\7v\2\2[\\\7w\2\2\\]\7t\2\2]^\7p\2\2^\n\3\2\2\2_`\7i\2\2`a\7t\2\2ab"+
		"\7q\2\2bc\7w\2\2cd\7r\2\2d\f\3\2\2\2ef\7-\2\2f\16\3\2\2\2gh\7/\2\2h\20"+
		"\3\2\2\2ij\7,\2\2j\22\3\2\2\2kl\7\61\2\2l\24\3\2\2\2mn\7*\2\2n\26\3\2"+
		"\2\2op\7+\2\2p\30\3\2\2\2qr\7.\2\2r\32\3\2\2\2st\7=\2\2t\34\3\2\2\2uv"+
		"\7?\2\2v\36\3\2\2\2wx\7\61\2\2xy\7\61\2\2y \3\2\2\2z{\7B\2\2{\"\3\2\2"+
		"\2|}\7@\2\2}$\3\2\2\2~\177\7>\2\2\177&\3\2\2\2\u0080\u0081\7@\2\2\u0081"+
		"\u0082\7?\2\2\u0082(\3\2\2\2\u0083\u0084\7>\2\2\u0084\u0085\7?\2\2\u0085"+
		"*\3\2\2\2\u0086\u0089\5\r\7\2\u0087\u0089\5\17\b\2\u0088\u0086\3\2\2\2"+
		"\u0088\u0087\3\2\2\2\u0089,\3\2\2\2\u008a\u008d\5\21\t\2\u008b\u008d\5"+
		"\23\n\2\u008c\u008a\3\2\2\2\u008c\u008b\3\2\2\2\u008d.\3\2\2\2\u008e\u008f"+
		"\7k\2\2\u008f\u0090\7p\2\2\u0090\u0091\7v\2\2\u0091\60\3\2\2\2\u0092\u0093"+
		"\7h\2\2\u0093\u0094\7n\2\2\u0094\u0095\7q\2\2\u0095\u0096\7c\2\2\u0096"+
		"\u0097\7v\2\2\u0097\62\3\2\2\2\u0098\u0099\7e\2\2\u0099\u009a\7j\2\2\u009a"+
		"\u009b\7c\2\2\u009b\u009c\7t\2\2\u009c\64\3\2\2\2\u009d\u009e\7x\2\2\u009e"+
		"\u009f\7q\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1\7f\2\2\u00a1\66\3\2\2\2\u00a2"+
		"\u00a3\7d\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7n\2\2"+
		"\u00a68\3\2\2\2\u00a7\u00a8\7u\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa\7t\2"+
		"\2\u00aa\u00ab\7k\2\2\u00ab\u00ac\7p\2\2\u00ac\u00ad\7i\2\2\u00ad:\3\2"+
		"\2\2\u00ae\u00b5\5/\30\2\u00af\u00b5\5\61\31\2\u00b0\u00b5\5\63\32\2\u00b1"+
		"\u00b5\5\67\34\2\u00b2\u00b5\5\65\33\2\u00b3\u00b5\59\35\2\u00b4\u00ae"+
		"\3\2\2\2\u00b4\u00af\3\2\2\2\u00b4\u00b0\3\2\2\2\u00b4\u00b1\3\2\2\2\u00b4"+
		"\u00b2\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5<\3\2\2\2\u00b6\u00b8\t\2\2\2"+
		"\u00b7\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba"+
		"\3\2\2\2\u00ba\u00be\3\2\2\2\u00bb\u00bd\t\3\2\2\u00bc\u00bb\3\2\2\2\u00bd"+
		"\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf>\3\2\2\2"+
		"\u00c0\u00be\3\2\2\2\u00c1\u00c3\t\4\2\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3"+
		"\3\2\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00c6\t\5\2\2\u00c5\u00c4\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\3\2"+
		"\2\2\u00c9\u00cb\7\60\2\2\u00ca\u00cc\t\5\2\2\u00cb\u00ca\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce@\3\2\2\2"+
		"\u00cf\u00d1\t\4\2\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d3"+
		"\3\2\2\2\u00d2\u00d4\t\6\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00da\3\2\2\2\u00d7\u00d9\t\5"+
		"\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00df\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00df\t\7"+
		"\2\2\u00de\u00d0\3\2\2\2\u00de\u00dd\3\2\2\2\u00dfB\3\2\2\2\u00e0\u00e1"+
		"\t\3\2\2\u00e1D\3\2\2\2\u00e2\u00e3\5A!\2\u00e3F\3\2\2\2\u00e4\u00e8\7"+
		"$\2\2\u00e5\u00e7\5C\"\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8\3\2"+
		"\2\2\u00eb\u00ec\7$\2\2\u00ecH\3\2\2\2\u00ed\u00ef\t\b\2\2\u00ee\u00ed"+
		"\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2\u00f3\b%\2\2\u00f3J\3\2\2\2\21\2\u0088\u008c\u00b4"+
		"\u00b9\u00be\u00c2\u00c7\u00cd\u00d0\u00d5\u00da\u00de\u00e8\u00f0\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}