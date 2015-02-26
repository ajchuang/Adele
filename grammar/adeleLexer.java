// Generated from ./adele.g4 by ANTLR 4.5
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
		IF=1, END=2, WHILE=3, ADD=4, SUB=5, MULTI=6, DIV=7, LPAREN=8, RPAREN=9, 
		COMMA=10, SEMICOLON=11, EQUAL=12, OVERLAY=13, AT=14, TYPE=15, ID=16, NUM=17, 
		STR=18, WS=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"IF", "END", "WHILE", "ADD", "SUB", "MULTI", "DIV", "LPAREN", "RPAREN", 
		"COMMA", "SEMICOLON", "EQUAL", "OVERLAY", "AT", "INT", "FLOAT", "CHAR", 
		"VOID", "TYPE", "ID", "FLOAT_NUM", "INT_NUM", "CHR", "NUM", "STR", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'end'", "'while'", "'+'", "'-'", "'*'", "'/'", "'('", "')'", 
		"','", "';'", "'='", "'//'", "'@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "IF", "END", "WHILE", "ADD", "SUB", "MULTI", "DIV", "LPAREN", "RPAREN", 
		"COMMA", "SEMICOLON", "EQUAL", "OVERLAY", "AT", "TYPE", "ID", "NUM", "STR", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25\u00b5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\24\3\24\3\24\3\24\5\24t\n\24\3\25\6\25w\n\25\r\25\16\25x\3\25\7\25|\n"+
		"\25\f\25\16\25\177\13\25\3\26\5\26\u0082\n\26\3\26\6\26\u0085\n\26\r\26"+
		"\16\26\u0086\3\26\3\26\6\26\u008b\n\26\r\26\16\26\u008c\3\27\5\27\u0090"+
		"\n\27\3\27\6\27\u0093\n\27\r\27\16\27\u0094\3\27\7\27\u0098\n\27\f\27"+
		"\16\27\u009b\13\27\3\27\5\27\u009e\n\27\3\30\3\30\3\31\3\31\5\31\u00a4"+
		"\n\31\3\32\3\32\7\32\u00a8\n\32\f\32\16\32\u00ab\13\32\3\32\3\32\3\33"+
		"\6\33\u00b0\n\33\r\33\16\33\u00b1\3\33\3\33\2\2\34\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\2!\2#\2%\2\'\21"+
		")\22+\2-\2/\2\61\23\63\24\65\25\3\2\t\5\2C\\aac|\6\2\62;C\\aac|\3\2//"+
		"\3\2\62;\3\2\63;\3\2\62\62\5\2\13\f\17\17\"\"\u00bc\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\3\67\3\2\2\2\5:\3\2\2\2\7>\3\2\2\2\tD\3\2\2\2\13F\3\2\2\2"+
		"\rH\3\2\2\2\17J\3\2\2\2\21L\3\2\2\2\23N\3\2\2\2\25P\3\2\2\2\27R\3\2\2"+
		"\2\31T\3\2\2\2\33V\3\2\2\2\35Y\3\2\2\2\37[\3\2\2\2!_\3\2\2\2#e\3\2\2\2"+
		"%j\3\2\2\2\'s\3\2\2\2)v\3\2\2\2+\u0081\3\2\2\2-\u009d\3\2\2\2/\u009f\3"+
		"\2\2\2\61\u00a3\3\2\2\2\63\u00a5\3\2\2\2\65\u00af\3\2\2\2\678\7k\2\28"+
		"9\7h\2\29\4\3\2\2\2:;\7g\2\2;<\7p\2\2<=\7f\2\2=\6\3\2\2\2>?\7y\2\2?@\7"+
		"j\2\2@A\7k\2\2AB\7n\2\2BC\7g\2\2C\b\3\2\2\2DE\7-\2\2E\n\3\2\2\2FG\7/\2"+
		"\2G\f\3\2\2\2HI\7,\2\2I\16\3\2\2\2JK\7\61\2\2K\20\3\2\2\2LM\7*\2\2M\22"+
		"\3\2\2\2NO\7+\2\2O\24\3\2\2\2PQ\7.\2\2Q\26\3\2\2\2RS\7=\2\2S\30\3\2\2"+
		"\2TU\7?\2\2U\32\3\2\2\2VW\7\61\2\2WX\7\61\2\2X\34\3\2\2\2YZ\7B\2\2Z\36"+
		"\3\2\2\2[\\\7k\2\2\\]\7p\2\2]^\7v\2\2^ \3\2\2\2_`\7h\2\2`a\7n\2\2ab\7"+
		"q\2\2bc\7c\2\2cd\7v\2\2d\"\3\2\2\2ef\7e\2\2fg\7j\2\2gh\7c\2\2hi\7t\2\2"+
		"i$\3\2\2\2jk\7x\2\2kl\7q\2\2lm\7k\2\2mn\7f\2\2n&\3\2\2\2ot\5\37\20\2p"+
		"t\5!\21\2qt\5#\22\2rt\5%\23\2so\3\2\2\2sp\3\2\2\2sq\3\2\2\2sr\3\2\2\2"+
		"t(\3\2\2\2uw\t\2\2\2vu\3\2\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2y}\3\2\2\2"+
		"z|\t\3\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~*\3\2\2\2\177}\3"+
		"\2\2\2\u0080\u0082\t\4\2\2\u0081\u0080\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0084\3\2\2\2\u0083\u0085\t\5\2\2\u0084\u0083\3\2\2\2\u0085\u0086\3\2"+
		"\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u008a\7\60\2\2\u0089\u008b\t\5\2\2\u008a\u0089\3\2\2\2\u008b\u008c\3"+
		"\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d,\3\2\2\2\u008e\u0090"+
		"\t\4\2\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091"+
		"\u0093\t\6\2\2\u0092\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2"+
		"\2\2\u0094\u0095\3\2\2\2\u0095\u0099\3\2\2\2\u0096\u0098\t\5\2\2\u0097"+
		"\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\u009e\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009e\t\7\2\2\u009d"+
		"\u008f\3\2\2\2\u009d\u009c\3\2\2\2\u009e.\3\2\2\2\u009f\u00a0\t\3\2\2"+
		"\u00a0\60\3\2\2\2\u00a1\u00a4\5+\26\2\u00a2\u00a4\5-\27\2\u00a3\u00a1"+
		"\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\62\3\2\2\2\u00a5\u00a9\7$\2\2\u00a6"+
		"\u00a8\5/\30\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2"+
		"\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac"+
		"\u00ad\7$\2\2\u00ad\64\3\2\2\2\u00ae\u00b0\t\b\2\2\u00af\u00ae\3\2\2\2"+
		"\u00b0\u00b1\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3"+
		"\3\2\2\2\u00b3\u00b4\b\33\2\2\u00b4\66\3\2\2\2\20\2sx}\u0081\u0086\u008c"+
		"\u008f\u0094\u0099\u009d\u00a3\u00a9\u00b1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}