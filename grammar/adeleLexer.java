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
		T__0=1, PTYPE=2, ATYPE=3, TYPE=4, ID=5, FLOAT=6, INT=7, NUM=8, IF=9, END=10, 
		WHILE=11, ADD=12, SUB=13, MULTI=14, DIV=15, LPAREN=16, RPAREN=17, COMMA=18, 
		SEMICOLON=19, WS=20;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "PTYPE", "ATYPE", "TYPE", "ID", "FLOAT", "INT", "NUM", "IF", "END", 
		"WHILE", "ADD", "SUB", "MULTI", "DIV", "LPAREN", "RPAREN", "COMMA", "SEMICOLON", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", null, null, null, null, null, null, null, "'if'", "'end'", 
		"'while'", "'+'", "'-'", "'*'", "'/'", "'('", "')'", "','", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "PTYPE", "ATYPE", "TYPE", "ID", "FLOAT", "INT", "NUM", "IF", 
		"END", "WHILE", "ADD", "SUB", "MULTI", "DIV", "LPAREN", "RPAREN", "COMMA", 
		"SEMICOLON", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\26\u0095\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3:\n\3\3\4\3\4\3\4\3\4\3\5\3\5\5\5B\n\5\3\6\6"+
		"\6E\n\6\r\6\16\6F\3\6\7\6J\n\6\f\6\16\6M\13\6\3\7\5\7P\n\7\3\7\6\7S\n"+
		"\7\r\7\16\7T\3\7\3\7\6\7Y\n\7\r\7\16\7Z\3\b\5\b^\n\b\3\b\6\ba\n\b\r\b"+
		"\16\bb\3\b\7\bf\n\b\f\b\16\bi\13\b\3\b\5\bl\n\b\3\t\3\t\5\tp\n\t\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3"+
		"\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\6\25\u0090"+
		"\n\25\r\25\16\25\u0091\3\25\3\25\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26\3\2"+
		"\t\5\2C\\aac|\6\2\62;C\\aac|\3\2//\3\2\62;\3\2\63;\3\2\62\62\5\2\13\f"+
		"\17\17\"\"\u00a2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\59\3"+
		"\2\2\2\7;\3\2\2\2\tA\3\2\2\2\13D\3\2\2\2\rO\3\2\2\2\17k\3\2\2\2\21o\3"+
		"\2\2\2\23q\3\2\2\2\25t\3\2\2\2\27x\3\2\2\2\31~\3\2\2\2\33\u0080\3\2\2"+
		"\2\35\u0082\3\2\2\2\37\u0084\3\2\2\2!\u0086\3\2\2\2#\u0088\3\2\2\2%\u008a"+
		"\3\2\2\2\'\u008c\3\2\2\2)\u008f\3\2\2\2+,\7?\2\2,\4\3\2\2\2-.\7k\2\2."+
		"/\7p\2\2/:\7v\2\2\60\61\7h\2\2\61\62\7n\2\2\62\63\7q\2\2\63\64\7c\2\2"+
		"\64:\7f\2\2\65\66\7e\2\2\66\67\7j\2\2\678\7c\2\28:\7t\2\29-\3\2\2\29\60"+
		"\3\2\2\29\65\3\2\2\2:\6\3\2\2\2;<\5\5\3\2<=\7]\2\2=>\7_\2\2>\b\3\2\2\2"+
		"?B\5\5\3\2@B\5\7\4\2A?\3\2\2\2A@\3\2\2\2B\n\3\2\2\2CE\t\2\2\2DC\3\2\2"+
		"\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2GK\3\2\2\2HJ\t\3\2\2IH\3\2\2\2JM\3\2\2"+
		"\2KI\3\2\2\2KL\3\2\2\2L\f\3\2\2\2MK\3\2\2\2NP\t\4\2\2ON\3\2\2\2OP\3\2"+
		"\2\2PR\3\2\2\2QS\t\5\2\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2UV\3\2"+
		"\2\2VX\7\60\2\2WY\t\5\2\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\16"+
		"\3\2\2\2\\^\t\4\2\2]\\\3\2\2\2]^\3\2\2\2^`\3\2\2\2_a\t\6\2\2`_\3\2\2\2"+
		"ab\3\2\2\2b`\3\2\2\2bc\3\2\2\2cg\3\2\2\2df\t\5\2\2ed\3\2\2\2fi\3\2\2\2"+
		"ge\3\2\2\2gh\3\2\2\2hl\3\2\2\2ig\3\2\2\2jl\t\7\2\2k]\3\2\2\2kj\3\2\2\2"+
		"l\20\3\2\2\2mp\5\r\7\2np\5\17\b\2om\3\2\2\2on\3\2\2\2p\22\3\2\2\2qr\7"+
		"k\2\2rs\7h\2\2s\24\3\2\2\2tu\7g\2\2uv\7p\2\2vw\7f\2\2w\26\3\2\2\2xy\7"+
		"y\2\2yz\7j\2\2z{\7k\2\2{|\7n\2\2|}\7g\2\2}\30\3\2\2\2~\177\7-\2\2\177"+
		"\32\3\2\2\2\u0080\u0081\7/\2\2\u0081\34\3\2\2\2\u0082\u0083\7,\2\2\u0083"+
		"\36\3\2\2\2\u0084\u0085\7\61\2\2\u0085 \3\2\2\2\u0086\u0087\7*\2\2\u0087"+
		"\"\3\2\2\2\u0088\u0089\7+\2\2\u0089$\3\2\2\2\u008a\u008b\7.\2\2\u008b"+
		"&\3\2\2\2\u008c\u008d\7=\2\2\u008d(\3\2\2\2\u008e\u0090\t\b\2\2\u008f"+
		"\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2"+
		"\2\2\u0092\u0093\3\2\2\2\u0093\u0094\b\25\2\2\u0094*\3\2\2\2\20\29AFK"+
		"OTZ]bgko\u0091\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}