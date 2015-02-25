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
		PTYPE=1, ATYPE=2, TYPE=3, ID=4, FLOAT=5, INT=6, NUM=7, CHAR=8, STR=9, 
		IF=10, END=11, WHILE=12, ADD=13, SUB=14, MULTI=15, DIV=16, LPAREN=17, 
		RPAREN=18, COMMA=19, SEMICOLON=20, EQUAL=21, OVERLAY=22, AT=23, WS=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"PTYPE", "ATYPE", "TYPE", "ID", "FLOAT", "INT", "NUM", "CHAR", "STR", 
		"IF", "END", "WHILE", "ADD", "SUB", "MULTI", "DIV", "LPAREN", "RPAREN", 
		"COMMA", "SEMICOLON", "EQUAL", "OVERLAY", "AT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "'if'", "'end'", 
		"'while'", "'+'", "'-'", "'*'", "'/'", "'('", "')'", "','", "';'", "'='", 
		"'//'", "'@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PTYPE", "ATYPE", "TYPE", "ID", "FLOAT", "INT", "NUM", "CHAR", "STR", 
		"IF", "END", "WHILE", "ADD", "SUB", "MULTI", "DIV", "LPAREN", "RPAREN", 
		"COMMA", "SEMICOLON", "EQUAL", "OVERLAY", "AT", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u00b1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2@\n\2\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4L\n\4\3\5\6\5O\n\5\r\5\16\5P\3\5\7"+
		"\5T\n\5\f\5\16\5W\13\5\3\6\5\6Z\n\6\3\6\6\6]\n\6\r\6\16\6^\3\6\3\6\6\6"+
		"c\n\6\r\6\16\6d\3\7\5\7h\n\7\3\7\6\7k\n\7\r\7\16\7l\3\7\7\7p\n\7\f\7\16"+
		"\7s\13\7\3\7\5\7v\n\7\3\b\3\b\5\bz\n\b\3\t\3\t\3\n\3\n\7\n\u0080\n\n\f"+
		"\n\16\n\u0083\13\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\6\31\u00ac"+
		"\n\31\r\31\16\31\u00ad\3\31\3\31\2\2\32\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\3\2\t\5\2C\\aac|\6\2\62;C\\aac|\3\2//\3\2\62;\3\2\63;\3"+
		"\2\62\62\5\2\13\f\17\17\"\"\u00c0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\3?\3\2\2\2\5A\3\2\2\2"+
		"\7K\3\2\2\2\tN\3\2\2\2\13Y\3\2\2\2\ru\3\2\2\2\17y\3\2\2\2\21{\3\2\2\2"+
		"\23}\3\2\2\2\25\u0086\3\2\2\2\27\u0089\3\2\2\2\31\u008d\3\2\2\2\33\u0093"+
		"\3\2\2\2\35\u0095\3\2\2\2\37\u0097\3\2\2\2!\u0099\3\2\2\2#\u009b\3\2\2"+
		"\2%\u009d\3\2\2\2\'\u009f\3\2\2\2)\u00a1\3\2\2\2+\u00a3\3\2\2\2-\u00a5"+
		"\3\2\2\2/\u00a8\3\2\2\2\61\u00ab\3\2\2\2\63\64\7k\2\2\64\65\7p\2\2\65"+
		"@\7v\2\2\66\67\7h\2\2\678\7n\2\289\7q\2\29:\7c\2\2:@\7f\2\2;<\7e\2\2<"+
		"=\7j\2\2=>\7c\2\2>@\7t\2\2?\63\3\2\2\2?\66\3\2\2\2?;\3\2\2\2@\4\3\2\2"+
		"\2AB\5\3\2\2BC\7]\2\2CD\7_\2\2D\6\3\2\2\2EL\5\3\2\2FL\5\5\3\2GH\7x\2\2"+
		"HI\7q\2\2IJ\7k\2\2JL\7f\2\2KE\3\2\2\2KF\3\2\2\2KG\3\2\2\2L\b\3\2\2\2M"+
		"O\t\2\2\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QU\3\2\2\2RT\t\3\2\2"+
		"SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V\n\3\2\2\2WU\3\2\2\2XZ\t\4\2"+
		"\2YX\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[]\t\5\2\2\\[\3\2\2\2]^\3\2\2\2^\\\3"+
		"\2\2\2^_\3\2\2\2_`\3\2\2\2`b\7\60\2\2ac\t\5\2\2ba\3\2\2\2cd\3\2\2\2db"+
		"\3\2\2\2de\3\2\2\2e\f\3\2\2\2fh\t\4\2\2gf\3\2\2\2gh\3\2\2\2hj\3\2\2\2"+
		"ik\t\6\2\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2mq\3\2\2\2np\t\5\2\2"+
		"on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rv\3\2\2\2sq\3\2\2\2tv\t\7\2\2"+
		"ug\3\2\2\2ut\3\2\2\2v\16\3\2\2\2wz\5\13\6\2xz\5\r\7\2yw\3\2\2\2yx\3\2"+
		"\2\2z\20\3\2\2\2{|\t\3\2\2|\22\3\2\2\2}\u0081\7$\2\2~\u0080\5\21\t\2\177"+
		"~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0084\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085\7$\2\2\u0085\24\3\2\2\2"+
		"\u0086\u0087\7k\2\2\u0087\u0088\7h\2\2\u0088\26\3\2\2\2\u0089\u008a\7"+
		"g\2\2\u008a\u008b\7p\2\2\u008b\u008c\7f\2\2\u008c\30\3\2\2\2\u008d\u008e"+
		"\7y\2\2\u008e\u008f\7j\2\2\u008f\u0090\7k\2\2\u0090\u0091\7n\2\2\u0091"+
		"\u0092\7g\2\2\u0092\32\3\2\2\2\u0093\u0094\7-\2\2\u0094\34\3\2\2\2\u0095"+
		"\u0096\7/\2\2\u0096\36\3\2\2\2\u0097\u0098\7,\2\2\u0098 \3\2\2\2\u0099"+
		"\u009a\7\61\2\2\u009a\"\3\2\2\2\u009b\u009c\7*\2\2\u009c$\3\2\2\2\u009d"+
		"\u009e\7+\2\2\u009e&\3\2\2\2\u009f\u00a0\7.\2\2\u00a0(\3\2\2\2\u00a1\u00a2"+
		"\7=\2\2\u00a2*\3\2\2\2\u00a3\u00a4\7?\2\2\u00a4,\3\2\2\2\u00a5\u00a6\7"+
		"\61\2\2\u00a6\u00a7\7\61\2\2\u00a7.\3\2\2\2\u00a8\u00a9\7B\2\2\u00a9\60"+
		"\3\2\2\2\u00aa\u00ac\t\b\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\b\31"+
		"\2\2\u00b0\62\3\2\2\2\21\2?KPUY^dglquy\u0081\u00ad\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}