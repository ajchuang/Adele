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
		EQUAL=19, OVERLAY=20, AT=21, WS=22;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"PTYPE", "ATYPE", "TYPE", "ID", "FLOAT", "INT", "NUM", "IF", "END", "WHILE", 
		"ADD", "SUB", "MULTI", "DIV", "LPAREN", "RPAREN", "COMMA", "SEMICOLON", 
		"EQUAL", "OVERLAY", "AT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, "'if'", "'end'", "'while'", 
		"'+'", "'-'", "'*'", "'/'", "'('", "')'", "','", "';'", "'='", "'//'", 
		"'@'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PTYPE", "ATYPE", "TYPE", "ID", "FLOAT", "INT", "NUM", "IF", "END", 
		"WHILE", "ADD", "SUB", "MULTI", "DIV", "LPAREN", "RPAREN", "COMMA", "SEMICOLON", 
		"EQUAL", "OVERLAY", "AT", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\30\u009e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2<\n\2\3\3\3\3\3\3\3\3\3\4\3\4\5"+
		"\4D\n\4\3\5\6\5G\n\5\r\5\16\5H\3\5\7\5L\n\5\f\5\16\5O\13\5\3\6\5\6R\n"+
		"\6\3\6\6\6U\n\6\r\6\16\6V\3\6\3\6\6\6[\n\6\r\6\16\6\\\3\7\5\7`\n\7\3\7"+
		"\6\7c\n\7\r\7\16\7d\3\7\7\7h\n\7\f\7\16\7k\13\7\3\7\5\7n\n\7\3\b\3\b\5"+
		"\br\n\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\6\27\u0099\n\27\r\27\16\27"+
		"\u009a\3\27\3\27\2\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30\3\2\t\5\2C"+
		"\\aac|\6\2\62;C\\aac|\3\2//\3\2\62;\3\2\63;\3\2\62\62\5\2\13\f\17\17\""+
		"\"\u00ab\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\3;\3\2\2\2\5=\3\2\2\2\7C\3\2\2\2\tF\3\2\2\2\13Q\3\2\2\2\rm\3\2\2\2\17"+
		"q\3\2\2\2\21s\3\2\2\2\23v\3\2\2\2\25z\3\2\2\2\27\u0080\3\2\2\2\31\u0082"+
		"\3\2\2\2\33\u0084\3\2\2\2\35\u0086\3\2\2\2\37\u0088\3\2\2\2!\u008a\3\2"+
		"\2\2#\u008c\3\2\2\2%\u008e\3\2\2\2\'\u0090\3\2\2\2)\u0092\3\2\2\2+\u0095"+
		"\3\2\2\2-\u0098\3\2\2\2/\60\7k\2\2\60\61\7p\2\2\61<\7v\2\2\62\63\7h\2"+
		"\2\63\64\7n\2\2\64\65\7q\2\2\65\66\7c\2\2\66<\7f\2\2\678\7e\2\289\7j\2"+
		"\29:\7c\2\2:<\7t\2\2;/\3\2\2\2;\62\3\2\2\2;\67\3\2\2\2<\4\3\2\2\2=>\5"+
		"\3\2\2>?\7]\2\2?@\7_\2\2@\6\3\2\2\2AD\5\3\2\2BD\5\5\3\2CA\3\2\2\2CB\3"+
		"\2\2\2D\b\3\2\2\2EG\t\2\2\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2IM"+
		"\3\2\2\2JL\t\3\2\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\n\3\2\2\2"+
		"OM\3\2\2\2PR\t\4\2\2QP\3\2\2\2QR\3\2\2\2RT\3\2\2\2SU\t\5\2\2TS\3\2\2\2"+
		"UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2WX\3\2\2\2XZ\7\60\2\2Y[\t\5\2\2ZY\3\2\2"+
		"\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\f\3\2\2\2^`\t\4\2\2_^\3\2\2\2_`\3"+
		"\2\2\2`b\3\2\2\2ac\t\6\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2ei\3"+
		"\2\2\2fh\t\5\2\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jn\3\2\2\2ki\3"+
		"\2\2\2ln\t\7\2\2m_\3\2\2\2ml\3\2\2\2n\16\3\2\2\2or\5\13\6\2pr\5\r\7\2"+
		"qo\3\2\2\2qp\3\2\2\2r\20\3\2\2\2st\7k\2\2tu\7h\2\2u\22\3\2\2\2vw\7g\2"+
		"\2wx\7p\2\2xy\7f\2\2y\24\3\2\2\2z{\7y\2\2{|\7j\2\2|}\7k\2\2}~\7n\2\2~"+
		"\177\7g\2\2\177\26\3\2\2\2\u0080\u0081\7-\2\2\u0081\30\3\2\2\2\u0082\u0083"+
		"\7/\2\2\u0083\32\3\2\2\2\u0084\u0085\7,\2\2\u0085\34\3\2\2\2\u0086\u0087"+
		"\7\61\2\2\u0087\36\3\2\2\2\u0088\u0089\7*\2\2\u0089 \3\2\2\2\u008a\u008b"+
		"\7+\2\2\u008b\"\3\2\2\2\u008c\u008d\7.\2\2\u008d$\3\2\2\2\u008e\u008f"+
		"\7=\2\2\u008f&\3\2\2\2\u0090\u0091\7?\2\2\u0091(\3\2\2\2\u0092\u0093\7"+
		"\61\2\2\u0093\u0094\7\61\2\2\u0094*\3\2\2\2\u0095\u0096\7B\2\2\u0096,"+
		"\3\2\2\2\u0097\u0099\t\b\2\2\u0098\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\b\27"+
		"\2\2\u009d.\3\2\2\2\20\2;CHMQV\\_dimq\u009a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}