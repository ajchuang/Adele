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
		"CHAR", "VOID", "BOOL", "TYPE", "ID", "FLOAT_NUM", "INT_NUM", "CHR", "NUM", 
		"STR", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u00ea\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\26\3\26\5\26\u0087\n\26\3\27\3\27\5\27\u008b\n\27\3\30\3\30\3"+
		"\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\5"+
		"\35\u00ab\n\35\3\36\6\36\u00ae\n\36\r\36\16\36\u00af\3\36\7\36\u00b3\n"+
		"\36\f\36\16\36\u00b6\13\36\3\37\5\37\u00b9\n\37\3\37\6\37\u00bc\n\37\r"+
		"\37\16\37\u00bd\3\37\3\37\6\37\u00c2\n\37\r\37\16\37\u00c3\3 \5 \u00c7"+
		"\n \3 \6 \u00ca\n \r \16 \u00cb\3 \7 \u00cf\n \f \16 \u00d2\13 \3 \5 "+
		"\u00d5\n \3!\3!\3\"\3\"\3#\3#\7#\u00dd\n#\f#\16#\u00e0\13#\3#\3#\3$\6"+
		"$\u00e5\n$\r$\16$\u00e6\3$\3$\2\2%\3\3\5\4\7\5\t\6\13\7\r\2\17\2\21\2"+
		"\23\2\25\b\27\t\31\n\33\13\35\f\37\r!\16#\17%\20\'\21)\22+\23-\24/\2\61"+
		"\2\63\2\65\2\67\29\25;\26=\2?\2A\2C\27E\30G\31\3\2\t\5\2C\\aac|\6\2\62"+
		";C\\aac|\3\2//\3\2\62;\3\2\63;\3\2\62\62\5\2\13\f\17\17\"\"\u00ee\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\3I\3\2\2\2"+
		"\5L\3\2\2\2\7P\3\2\2\2\tV\3\2\2\2\13]\3\2\2\2\rc\3\2\2\2\17e\3\2\2\2\21"+
		"g\3\2\2\2\23i\3\2\2\2\25k\3\2\2\2\27m\3\2\2\2\31o\3\2\2\2\33q\3\2\2\2"+
		"\35s\3\2\2\2\37u\3\2\2\2!x\3\2\2\2#z\3\2\2\2%|\3\2\2\2\'~\3\2\2\2)\u0081"+
		"\3\2\2\2+\u0086\3\2\2\2-\u008a\3\2\2\2/\u008c\3\2\2\2\61\u0090\3\2\2\2"+
		"\63\u0096\3\2\2\2\65\u009b\3\2\2\2\67\u00a0\3\2\2\29\u00aa\3\2\2\2;\u00ad"+
		"\3\2\2\2=\u00b8\3\2\2\2?\u00d4\3\2\2\2A\u00d6\3\2\2\2C\u00d8\3\2\2\2E"+
		"\u00da\3\2\2\2G\u00e4\3\2\2\2IJ\7k\2\2JK\7h\2\2K\4\3\2\2\2LM\7g\2\2MN"+
		"\7p\2\2NO\7f\2\2O\6\3\2\2\2PQ\7y\2\2QR\7j\2\2RS\7k\2\2ST\7n\2\2TU\7g\2"+
		"\2U\b\3\2\2\2VW\7t\2\2WX\7g\2\2XY\7v\2\2YZ\7w\2\2Z[\7t\2\2[\\\7p\2\2\\"+
		"\n\3\2\2\2]^\7i\2\2^_\7t\2\2_`\7q\2\2`a\7w\2\2ab\7r\2\2b\f\3\2\2\2cd\7"+
		"-\2\2d\16\3\2\2\2ef\7/\2\2f\20\3\2\2\2gh\7,\2\2h\22\3\2\2\2ij\7\61\2\2"+
		"j\24\3\2\2\2kl\7*\2\2l\26\3\2\2\2mn\7+\2\2n\30\3\2\2\2op\7.\2\2p\32\3"+
		"\2\2\2qr\7=\2\2r\34\3\2\2\2st\7?\2\2t\36\3\2\2\2uv\7\61\2\2vw\7\61\2\2"+
		"w \3\2\2\2xy\7B\2\2y\"\3\2\2\2z{\7@\2\2{$\3\2\2\2|}\7>\2\2}&\3\2\2\2~"+
		"\177\7@\2\2\177\u0080\7?\2\2\u0080(\3\2\2\2\u0081\u0082\7>\2\2\u0082\u0083"+
		"\7?\2\2\u0083*\3\2\2\2\u0084\u0087\5\r\7\2\u0085\u0087\5\17\b\2\u0086"+
		"\u0084\3\2\2\2\u0086\u0085\3\2\2\2\u0087,\3\2\2\2\u0088\u008b\5\21\t\2"+
		"\u0089\u008b\5\23\n\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2\2\u008b.\3"+
		"\2\2\2\u008c\u008d\7k\2\2\u008d\u008e\7p\2\2\u008e\u008f\7v\2\2\u008f"+
		"\60\3\2\2\2\u0090\u0091\7h\2\2\u0091\u0092\7n\2\2\u0092\u0093\7q\2\2\u0093"+
		"\u0094\7c\2\2\u0094\u0095\7v\2\2\u0095\62\3\2\2\2\u0096\u0097\7e\2\2\u0097"+
		"\u0098\7j\2\2\u0098\u0099\7c\2\2\u0099\u009a\7t\2\2\u009a\64\3\2\2\2\u009b"+
		"\u009c\7x\2\2\u009c\u009d\7q\2\2\u009d\u009e\7k\2\2\u009e\u009f\7f\2\2"+
		"\u009f\66\3\2\2\2\u00a0\u00a1\7d\2\2\u00a1\u00a2\7q\2\2\u00a2\u00a3\7"+
		"q\2\2\u00a3\u00a4\7n\2\2\u00a48\3\2\2\2\u00a5\u00ab\5/\30\2\u00a6\u00ab"+
		"\5\61\31\2\u00a7\u00ab\5\63\32\2\u00a8\u00ab\5\67\34\2\u00a9\u00ab\5\65"+
		"\33\2\u00aa\u00a5\3\2\2\2\u00aa\u00a6\3\2\2\2\u00aa\u00a7\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab:\3\2\2\2\u00ac\u00ae\t\2\2\2"+
		"\u00ad\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0"+
		"\3\2\2\2\u00b0\u00b4\3\2\2\2\u00b1\u00b3\t\3\2\2\u00b2\u00b1\3\2\2\2\u00b3"+
		"\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5<\3\2\2\2"+
		"\u00b6\u00b4\3\2\2\2\u00b7\u00b9\t\4\2\2\u00b8\u00b7\3\2\2\2\u00b8\u00b9"+
		"\3\2\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00bc\t\5\2\2\u00bb\u00ba\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\3\2"+
		"\2\2\u00bf\u00c1\7\60\2\2\u00c0\u00c2\t\5\2\2\u00c1\u00c0\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4>\3\2\2\2"+
		"\u00c5\u00c7\t\4\2\2\u00c6\u00c5\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c9"+
		"\3\2\2\2\u00c8\u00ca\t\6\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00d0\3\2\2\2\u00cd\u00cf\t\5"+
		"\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00d5\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d5\t\7"+
		"\2\2\u00d4\u00c6\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5@\3\2\2\2\u00d6\u00d7"+
		"\t\3\2\2\u00d7B\3\2\2\2\u00d8\u00d9\5? \2\u00d9D\3\2\2\2\u00da\u00de\7"+
		"$\2\2\u00db\u00dd\5A!\2\u00dc\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de"+
		"\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00de\3\2"+
		"\2\2\u00e1\u00e2\7$\2\2\u00e2F\3\2\2\2\u00e3\u00e5\t\b\2\2\u00e4\u00e3"+
		"\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00e9\b$\2\2\u00e9H\3\2\2\2\21\2\u0086\u008a\u00aa"+
		"\u00af\u00b4\u00b8\u00bd\u00c3\u00c6\u00cb\u00d0\u00d4\u00de\u00e6\3\b"+
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