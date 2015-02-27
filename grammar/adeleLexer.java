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
		IF=1, END=2, WHILE=3, RETURN=4, ADD=5, SUB=6, MULTI=7, DIV=8, LPAREN=9, 
		RPAREN=10, COMMA=11, SEMICOLON=12, EQUAL=13, OVERLAY=14, AT=15, GT=16, 
		LT=17, GET=18, LET=19, TYPE=20, ID=21, NUM=22, STR=23, WS=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"IF", "END", "WHILE", "RETURN", "ADD", "SUB", "MULTI", "DIV", "LPAREN", 
		"RPAREN", "COMMA", "SEMICOLON", "EQUAL", "OVERLAY", "AT", "GT", "LT", 
		"GET", "LET", "INT", "FLOAT", "CHAR", "VOID", "BOOL", "TYPE", "ID", "FLOAT_NUM", 
		"INT_NUM", "CHR", "NUM", "STR", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'end'", "'while'", "'return'", "'+'", "'-'", "'*'", "'/'", 
		"'('", "')'", "','", "';'", "'='", "'//'", "'@'", "'>'", "'<'", "'>='", 
		"'<='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "IF", "END", "WHILE", "RETURN", "ADD", "SUB", "MULTI", "DIV", "LPAREN", 
		"RPAREN", "COMMA", "SEMICOLON", "EQUAL", "OVERLAY", "AT", "GT", "LT", 
		"GET", "LET", "TYPE", "ID", "NUM", "STR", "WS"
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
	    final int F_TYPE_INT = 1;

	    /* globals */
	    int m_curScope = 0;

	    /* Map variable name to Integer object holding value */
	    Hashtable<Integer, Object> m_scopeTable = new Hashtable<Integer, Object> (); 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u00d6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\5\32\u0097\n\32\3\33\6\33\u009a"+
		"\n\33\r\33\16\33\u009b\3\33\7\33\u009f\n\33\f\33\16\33\u00a2\13\33\3\34"+
		"\5\34\u00a5\n\34\3\34\6\34\u00a8\n\34\r\34\16\34\u00a9\3\34\3\34\6\34"+
		"\u00ae\n\34\r\34\16\34\u00af\3\35\5\35\u00b3\n\35\3\35\6\35\u00b6\n\35"+
		"\r\35\16\35\u00b7\3\35\7\35\u00bb\n\35\f\35\16\35\u00be\13\35\3\35\5\35"+
		"\u00c1\n\35\3\36\3\36\3\37\3\37\3 \3 \7 \u00c9\n \f \16 \u00cc\13 \3 "+
		"\3 \3!\6!\u00d1\n!\r!\16!\u00d2\3!\3!\2\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\2+\2"+
		"-\2/\2\61\2\63\26\65\27\67\29\2;\2=\30?\31A\32\3\2\t\5\2C\\aac|\6\2\62"+
		";C\\aac|\3\2//\3\2\62;\3\2\63;\3\2\62\62\5\2\13\f\17\17\"\"\u00dc\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\3C\3\2\2\2\5F\3\2\2\2\7J\3\2\2\2\tP\3\2\2\2\13W\3\2\2\2"+
		"\rY\3\2\2\2\17[\3\2\2\2\21]\3\2\2\2\23_\3\2\2\2\25a\3\2\2\2\27c\3\2\2"+
		"\2\31e\3\2\2\2\33g\3\2\2\2\35i\3\2\2\2\37l\3\2\2\2!n\3\2\2\2#p\3\2\2\2"+
		"%r\3\2\2\2\'u\3\2\2\2)x\3\2\2\2+|\3\2\2\2-\u0082\3\2\2\2/\u0087\3\2\2"+
		"\2\61\u008c\3\2\2\2\63\u0096\3\2\2\2\65\u0099\3\2\2\2\67\u00a4\3\2\2\2"+
		"9\u00c0\3\2\2\2;\u00c2\3\2\2\2=\u00c4\3\2\2\2?\u00c6\3\2\2\2A\u00d0\3"+
		"\2\2\2CD\7k\2\2DE\7h\2\2E\4\3\2\2\2FG\7g\2\2GH\7p\2\2HI\7f\2\2I\6\3\2"+
		"\2\2JK\7y\2\2KL\7j\2\2LM\7k\2\2MN\7n\2\2NO\7g\2\2O\b\3\2\2\2PQ\7t\2\2"+
		"QR\7g\2\2RS\7v\2\2ST\7w\2\2TU\7t\2\2UV\7p\2\2V\n\3\2\2\2WX\7-\2\2X\f\3"+
		"\2\2\2YZ\7/\2\2Z\16\3\2\2\2[\\\7,\2\2\\\20\3\2\2\2]^\7\61\2\2^\22\3\2"+
		"\2\2_`\7*\2\2`\24\3\2\2\2ab\7+\2\2b\26\3\2\2\2cd\7.\2\2d\30\3\2\2\2ef"+
		"\7=\2\2f\32\3\2\2\2gh\7?\2\2h\34\3\2\2\2ij\7\61\2\2jk\7\61\2\2k\36\3\2"+
		"\2\2lm\7B\2\2m \3\2\2\2no\7@\2\2o\"\3\2\2\2pq\7>\2\2q$\3\2\2\2rs\7@\2"+
		"\2st\7?\2\2t&\3\2\2\2uv\7>\2\2vw\7?\2\2w(\3\2\2\2xy\7k\2\2yz\7p\2\2z{"+
		"\7v\2\2{*\3\2\2\2|}\7h\2\2}~\7n\2\2~\177\7q\2\2\177\u0080\7c\2\2\u0080"+
		"\u0081\7v\2\2\u0081,\3\2\2\2\u0082\u0083\7e\2\2\u0083\u0084\7j\2\2\u0084"+
		"\u0085\7c\2\2\u0085\u0086\7t\2\2\u0086.\3\2\2\2\u0087\u0088\7x\2\2\u0088"+
		"\u0089\7q\2\2\u0089\u008a\7k\2\2\u008a\u008b\7f\2\2\u008b\60\3\2\2\2\u008c"+
		"\u008d\7d\2\2\u008d\u008e\7q\2\2\u008e\u008f\7q\2\2\u008f\u0090\7n\2\2"+
		"\u0090\62\3\2\2\2\u0091\u0097\5)\25\2\u0092\u0097\5+\26\2\u0093\u0097"+
		"\5-\27\2\u0094\u0097\5\61\31\2\u0095\u0097\5/\30\2\u0096\u0091\3\2\2\2"+
		"\u0096\u0092\3\2\2\2\u0096\u0093\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0095"+
		"\3\2\2\2\u0097\64\3\2\2\2\u0098\u009a\t\2\2\2\u0099\u0098\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u00a0\3\2"+
		"\2\2\u009d\u009f\t\3\2\2\u009e\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0"+
		"\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\66\3\2\2\2\u00a2\u00a0\3\2\2"+
		"\2\u00a3\u00a5\t\4\2\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a7"+
		"\3\2\2\2\u00a6\u00a8\t\5\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\7\60"+
		"\2\2\u00ac\u00ae\t\5\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b08\3\2\2\2\u00b1\u00b3\t\4\2\2"+
		"\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00b6"+
		"\t\6\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7"+
		"\u00b8\3\2\2\2\u00b8\u00bc\3\2\2\2\u00b9\u00bb\t\5\2\2\u00ba\u00b9\3\2"+
		"\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"\u00c1\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c1\t\7\2\2\u00c0\u00b2\3\2"+
		"\2\2\u00c0\u00bf\3\2\2\2\u00c1:\3\2\2\2\u00c2\u00c3\t\3\2\2\u00c3<\3\2"+
		"\2\2\u00c4\u00c5\59\35\2\u00c5>\3\2\2\2\u00c6\u00ca\7$\2\2\u00c7\u00c9"+
		"\5;\36\2\u00c8\u00c7\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca"+
		"\u00cb\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00ce\7$"+
		"\2\2\u00ce@\3\2\2\2\u00cf\u00d1\t\b\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00d2"+
		"\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d5\b!\2\2\u00d5B\3\2\2\2\17\2\u0096\u009b\u00a0\u00a4\u00a9\u00af"+
		"\u00b2\u00b7\u00bc\u00c0\u00ca\u00d2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}