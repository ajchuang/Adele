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
		PTYPE=1, ATYPE=2, TYPE=3, ID=4, FLOAT=5, INT=6, NUM=7, IF=8, END=9, WHILE=10, 
		ADD=11, SUB=12, MULTI=13, DIV=14, LPAREN=15, RPAREN=16, COMMA=17, SEMICOLON=18, 
		EQUAL=19, WS=20;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"PTYPE", "ATYPE", "TYPE", "ID", "FLOAT", "INT", "NUM", "IF", "END", "WHILE", 
		"ADD", "SUB", "MULTI", "DIV", "LPAREN", "RPAREN", "COMMA", "SEMICOLON", 
		"EQUAL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, "'if'", "'end'", "'while'", 
		"'+'", "'-'", "'*'", "'/'", "'('", "')'", "','", "';'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PTYPE", "ATYPE", "TYPE", "ID", "FLOAT", "INT", "NUM", "IF", "END", 
		"WHILE", "ADD", "SUB", "MULTI", "DIV", "LPAREN", "RPAREN", "COMMA", "SEMICOLON", 
		"EQUAL", "WS"
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
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\5\28\n\2\3\3\3\3\3\3\3\3\3\4\3\4\5\4@\n\4\3\5\6\5C\n\5"+
		"\r\5\16\5D\3\5\7\5H\n\5\f\5\16\5K\13\5\3\6\5\6N\n\6\3\6\6\6Q\n\6\r\6\16"+
		"\6R\3\6\3\6\6\6W\n\6\r\6\16\6X\3\7\5\7\\\n\7\3\7\6\7_\n\7\r\7\16\7`\3"+
		"\7\7\7d\n\7\f\7\16\7g\13\7\3\7\5\7j\n\7\3\b\3\b\5\bn\n\b\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\6\25"+
		"\u0090\n\25\r\25\16\25\u0091\3\25\3\25\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"\3\2\t\5\2C\\aac|\6\2\62;C\\aac|\3\2//\3\2\62;\3\2\63;\3\2\62\62\5\2\13"+
		"\f\17\17\"\"\u00a2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3\67\3\2\2\2\5"+
		"9\3\2\2\2\7?\3\2\2\2\tB\3\2\2\2\13M\3\2\2\2\ri\3\2\2\2\17m\3\2\2\2\21"+
		"o\3\2\2\2\23r\3\2\2\2\25v\3\2\2\2\27|\3\2\2\2\31~\3\2\2\2\33\u0080\3\2"+
		"\2\2\35\u0082\3\2\2\2\37\u0084\3\2\2\2!\u0086\3\2\2\2#\u0088\3\2\2\2%"+
		"\u008a\3\2\2\2\'\u008c\3\2\2\2)\u008f\3\2\2\2+,\7k\2\2,-\7p\2\2-8\7v\2"+
		"\2./\7h\2\2/\60\7n\2\2\60\61\7q\2\2\61\62\7c\2\2\628\7f\2\2\63\64\7e\2"+
		"\2\64\65\7j\2\2\65\66\7c\2\2\668\7t\2\2\67+\3\2\2\2\67.\3\2\2\2\67\63"+
		"\3\2\2\28\4\3\2\2\29:\5\3\2\2:;\7]\2\2;<\7_\2\2<\6\3\2\2\2=@\5\3\2\2>"+
		"@\5\5\3\2?=\3\2\2\2?>\3\2\2\2@\b\3\2\2\2AC\t\2\2\2BA\3\2\2\2CD\3\2\2\2"+
		"DB\3\2\2\2DE\3\2\2\2EI\3\2\2\2FH\t\3\2\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2"+
		"IJ\3\2\2\2J\n\3\2\2\2KI\3\2\2\2LN\t\4\2\2ML\3\2\2\2MN\3\2\2\2NP\3\2\2"+
		"\2OQ\t\5\2\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2ST\3\2\2\2TV\7\60"+
		"\2\2UW\t\5\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\f\3\2\2\2Z\\\t"+
		"\4\2\2[Z\3\2\2\2[\\\3\2\2\2\\^\3\2\2\2]_\t\6\2\2^]\3\2\2\2_`\3\2\2\2`"+
		"^\3\2\2\2`a\3\2\2\2ae\3\2\2\2bd\t\5\2\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2"+
		"ef\3\2\2\2fj\3\2\2\2ge\3\2\2\2hj\t\7\2\2i[\3\2\2\2ih\3\2\2\2j\16\3\2\2"+
		"\2kn\5\13\6\2ln\5\r\7\2mk\3\2\2\2ml\3\2\2\2n\20\3\2\2\2op\7k\2\2pq\7h"+
		"\2\2q\22\3\2\2\2rs\7g\2\2st\7p\2\2tu\7f\2\2u\24\3\2\2\2vw\7y\2\2wx\7j"+
		"\2\2xy\7k\2\2yz\7n\2\2z{\7g\2\2{\26\3\2\2\2|}\7-\2\2}\30\3\2\2\2~\177"+
		"\7/\2\2\177\32\3\2\2\2\u0080\u0081\7,\2\2\u0081\34\3\2\2\2\u0082\u0083"+
		"\7\61\2\2\u0083\36\3\2\2\2\u0084\u0085\7*\2\2\u0085 \3\2\2\2\u0086\u0087"+
		"\7+\2\2\u0087\"\3\2\2\2\u0088\u0089\7.\2\2\u0089$\3\2\2\2\u008a\u008b"+
		"\7=\2\2\u008b&\3\2\2\2\u008c\u008d\7?\2\2\u008d(\3\2\2\2\u008e\u0090\t"+
		"\b\2\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\b\25\2\2\u0094*\3\2\2\2"+
		"\20\2\67?DIMRX[`eim\u0091\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}