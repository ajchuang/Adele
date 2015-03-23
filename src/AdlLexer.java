// Generated from Adl.g4 by ANTLR 4.5
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AdlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, END=2, WHILE=3, RETURN=4, GROUP=5, LPAREN=6, RPAREN=7, COMMA=8, 
		SEMICOLON=9, EQUAL=10, OVERLAY=11, AT=12, GT=13, LT=14, GET=15, LET=16, 
		NE=17, ADDITIVE_OP=18, MULTIPLICATIVE_OP=19, K_INT=20, K_VOID=21, ID=22, 
		NUM=23, STR=24, WS=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"IF", "END", "WHILE", "RETURN", "GROUP", "ADD", "SUB", "MULTI", "DIV", 
		"LPAREN", "RPAREN", "COMMA", "SEMICOLON", "EQUAL", "OVERLAY", "AT", "GT", 
		"LT", "GET", "LET", "NE", "ADDITIVE_OP", "MULTIPLICATIVE_OP", "K_INT", 
		"K_VOID", "ID", "FLOAT_NUM", "INT_NUM", "CHR", "NUM", "STR", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'end'", "'while'", "'return'", "'group'", "'('", "')'", 
		"','", "';'", "'='", "'//'", "'@'", "'>'", "'<'", "'>='", "'<='", "'!='", 
		null, null, "'int'", "'void'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "IF", "END", "WHILE", "RETURN", "GROUP", "LPAREN", "RPAREN", "COMMA", 
		"SEMICOLON", "EQUAL", "OVERLAY", "AT", "GT", "LT", "GET", "LET", "NE", 
		"ADDITIVE_OP", "MULTIPLICATIVE_OP", "K_INT", "K_VOID", "ID", "NUM", "STR", 
		"WS"
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


	public AdlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Adl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u00d0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\27\3\27\5\27\u0084\n\27\3\30\3\30\5\30\u0088\n\30\3\31\3\31\3\31\3"+
		"\31\3\32\3\32\3\32\3\32\3\32\3\33\6\33\u0094\n\33\r\33\16\33\u0095\3\33"+
		"\7\33\u0099\n\33\f\33\16\33\u009c\13\33\3\34\5\34\u009f\n\34\3\34\6\34"+
		"\u00a2\n\34\r\34\16\34\u00a3\3\34\3\34\6\34\u00a8\n\34\r\34\16\34\u00a9"+
		"\3\35\5\35\u00ad\n\35\3\35\6\35\u00b0\n\35\r\35\16\35\u00b1\3\35\7\35"+
		"\u00b5\n\35\f\35\16\35\u00b8\13\35\3\35\5\35\u00bb\n\35\3\36\3\36\3\37"+
		"\3\37\3 \3 \7 \u00c3\n \f \16 \u00c6\13 \3 \3 \3!\6!\u00cb\n!\r!\16!\u00cc"+
		"\3!\3!\2\2\"\3\3\5\4\7\5\t\6\13\7\r\2\17\2\21\2\23\2\25\b\27\t\31\n\33"+
		"\13\35\f\37\r!\16#\17%\20\'\21)\22+\23-\24/\25\61\26\63\27\65\30\67\2"+
		"9\2;\2=\31?\32A\33\3\2\t\5\2C\\aac|\6\2\62;C\\aac|\3\2//\3\2\62;\3\2\63"+
		";\3\2\62\62\5\2\13\f\17\17\"\"\u00d5\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\3C\3\2\2\2\5"+
		"F\3\2\2\2\7J\3\2\2\2\tP\3\2\2\2\13W\3\2\2\2\r]\3\2\2\2\17_\3\2\2\2\21"+
		"a\3\2\2\2\23c\3\2\2\2\25e\3\2\2\2\27g\3\2\2\2\31i\3\2\2\2\33k\3\2\2\2"+
		"\35m\3\2\2\2\37o\3\2\2\2!r\3\2\2\2#t\3\2\2\2%v\3\2\2\2\'x\3\2\2\2){\3"+
		"\2\2\2+~\3\2\2\2-\u0083\3\2\2\2/\u0087\3\2\2\2\61\u0089\3\2\2\2\63\u008d"+
		"\3\2\2\2\65\u0093\3\2\2\2\67\u009e\3\2\2\29\u00ba\3\2\2\2;\u00bc\3\2\2"+
		"\2=\u00be\3\2\2\2?\u00c0\3\2\2\2A\u00ca\3\2\2\2CD\7k\2\2DE\7h\2\2E\4\3"+
		"\2\2\2FG\7g\2\2GH\7p\2\2HI\7f\2\2I\6\3\2\2\2JK\7y\2\2KL\7j\2\2LM\7k\2"+
		"\2MN\7n\2\2NO\7g\2\2O\b\3\2\2\2PQ\7t\2\2QR\7g\2\2RS\7v\2\2ST\7w\2\2TU"+
		"\7t\2\2UV\7p\2\2V\n\3\2\2\2WX\7i\2\2XY\7t\2\2YZ\7q\2\2Z[\7w\2\2[\\\7r"+
		"\2\2\\\f\3\2\2\2]^\7-\2\2^\16\3\2\2\2_`\7/\2\2`\20\3\2\2\2ab\7,\2\2b\22"+
		"\3\2\2\2cd\7\61\2\2d\24\3\2\2\2ef\7*\2\2f\26\3\2\2\2gh\7+\2\2h\30\3\2"+
		"\2\2ij\7.\2\2j\32\3\2\2\2kl\7=\2\2l\34\3\2\2\2mn\7?\2\2n\36\3\2\2\2op"+
		"\7\61\2\2pq\7\61\2\2q \3\2\2\2rs\7B\2\2s\"\3\2\2\2tu\7@\2\2u$\3\2\2\2"+
		"vw\7>\2\2w&\3\2\2\2xy\7@\2\2yz\7?\2\2z(\3\2\2\2{|\7>\2\2|}\7?\2\2}*\3"+
		"\2\2\2~\177\7#\2\2\177\u0080\7?\2\2\u0080,\3\2\2\2\u0081\u0084\5\r\7\2"+
		"\u0082\u0084\5\17\b\2\u0083\u0081\3\2\2\2\u0083\u0082\3\2\2\2\u0084.\3"+
		"\2\2\2\u0085\u0088\5\21\t\2\u0086\u0088\5\23\n\2\u0087\u0085\3\2\2\2\u0087"+
		"\u0086\3\2\2\2\u0088\60\3\2\2\2\u0089\u008a\7k\2\2\u008a\u008b\7p\2\2"+
		"\u008b\u008c\7v\2\2\u008c\62\3\2\2\2\u008d\u008e\7x\2\2\u008e\u008f\7"+
		"q\2\2\u008f\u0090\7k\2\2\u0090\u0091\7f\2\2\u0091\64\3\2\2\2\u0092\u0094"+
		"\t\2\2\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u009a\3\2\2\2\u0097\u0099\t\3\2\2\u0098\u0097\3\2"+
		"\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\66\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009f\t\4\2\2\u009e\u009d\3\2\2"+
		"\2\u009e\u009f\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u00a2\t\5\2\2\u00a1\u00a0"+
		"\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00a7\7\60\2\2\u00a6\u00a8\t\5\2\2\u00a7\u00a6\3"+
		"\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"8\3\2\2\2\u00ab\u00ad\t\4\2\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad\3\2\2\2"+
		"\u00ad\u00af\3\2\2\2\u00ae\u00b0\t\6\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b1"+
		"\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b6\3\2\2\2\u00b3"+
		"\u00b5\t\5\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2"+
		"\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00bb\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9"+
		"\u00bb\t\7\2\2\u00ba\u00ac\3\2\2\2\u00ba\u00b9\3\2\2\2\u00bb:\3\2\2\2"+
		"\u00bc\u00bd\t\3\2\2\u00bd<\3\2\2\2\u00be\u00bf\59\35\2\u00bf>\3\2\2\2"+
		"\u00c0\u00c4\7$\2\2\u00c1\u00c3\5;\36\2\u00c2\u00c1\3\2\2\2\u00c3\u00c6"+
		"\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c7\u00c8\7$\2\2\u00c8@\3\2\2\2\u00c9\u00cb\t\b\2\2\u00ca"+
		"\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\b!\2\2\u00cfB\3\2\2\2\20\2\u0083"+
		"\u0087\u0095\u009a\u009e\u00a3\u00a9\u00ac\u00b1\u00b6\u00ba\u00c4\u00cc"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}