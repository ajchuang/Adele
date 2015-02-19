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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		PTYPE=10, ATYPE=11, TYPE=12, ID=13, FLOAT=14, INT=15, NUM=16, END=17, 
		WS=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"PTYPE", "ATYPE", "TYPE", "ID", "FLOAT", "INT", "NUM", "END", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "','", "'if'", "'*'", "'/'", "'+'", "'-'", 
		null, null, null, null, null, null, null, "'end'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "PTYPE", "ATYPE", 
		"TYPE", "ID", "FLOAT", "INT", "NUM", "END", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u0089\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\5\13G\n\13\3\f\3\f\3\f\3\f\3\r\3\r\5\rO\n\r\3\16\6\16R\n"+
		"\16\r\16\16\16S\3\16\7\16W\n\16\f\16\16\16Z\13\16\3\17\5\17]\n\17\3\17"+
		"\6\17`\n\17\r\17\16\17a\3\17\3\17\6\17f\n\17\r\17\16\17g\3\20\5\20k\n"+
		"\20\3\20\6\20n\n\20\r\20\16\20o\3\20\7\20s\n\20\f\20\16\20v\13\20\3\20"+
		"\5\20y\n\20\3\21\3\21\5\21}\n\21\3\22\3\22\3\22\3\22\3\23\6\23\u0084\n"+
		"\23\r\23\16\23\u0085\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\t\5\2C\\aa"+
		"c|\6\2\62;C\\aac|\3\2//\3\2\62;\3\2\63;\3\2\62\62\5\2\13\f\17\17\"\"\u0096"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2\7+\3\2\2\2\t-\3\2\2\2\13/\3\2\2"+
		"\2\r\62\3\2\2\2\17\64\3\2\2\2\21\66\3\2\2\2\238\3\2\2\2\25F\3\2\2\2\27"+
		"H\3\2\2\2\31N\3\2\2\2\33Q\3\2\2\2\35\\\3\2\2\2\37x\3\2\2\2!|\3\2\2\2#"+
		"~\3\2\2\2%\u0083\3\2\2\2\'(\7=\2\2(\4\3\2\2\2)*\7*\2\2*\6\3\2\2\2+,\7"+
		"+\2\2,\b\3\2\2\2-.\7.\2\2.\n\3\2\2\2/\60\7k\2\2\60\61\7h\2\2\61\f\3\2"+
		"\2\2\62\63\7,\2\2\63\16\3\2\2\2\64\65\7\61\2\2\65\20\3\2\2\2\66\67\7-"+
		"\2\2\67\22\3\2\2\289\7/\2\29\24\3\2\2\2:;\7k\2\2;<\7p\2\2<G\7v\2\2=>\7"+
		"h\2\2>?\7n\2\2?@\7q\2\2@A\7c\2\2AG\7f\2\2BC\7e\2\2CD\7j\2\2DE\7c\2\2E"+
		"G\7t\2\2F:\3\2\2\2F=\3\2\2\2FB\3\2\2\2G\26\3\2\2\2HI\5\25\13\2IJ\7]\2"+
		"\2JK\7_\2\2K\30\3\2\2\2LO\5\25\13\2MO\5\27\f\2NL\3\2\2\2NM\3\2\2\2O\32"+
		"\3\2\2\2PR\t\2\2\2QP\3\2\2\2RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TX\3\2\2\2U"+
		"W\t\3\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\34\3\2\2\2ZX\3\2\2"+
		"\2[]\t\4\2\2\\[\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^`\t\5\2\2_^\3\2\2\2`a\3\2"+
		"\2\2a_\3\2\2\2ab\3\2\2\2bc\3\2\2\2ce\7\60\2\2df\t\5\2\2ed\3\2\2\2fg\3"+
		"\2\2\2ge\3\2\2\2gh\3\2\2\2h\36\3\2\2\2ik\t\4\2\2ji\3\2\2\2jk\3\2\2\2k"+
		"m\3\2\2\2ln\t\6\2\2ml\3\2\2\2no\3\2\2\2om\3\2\2\2op\3\2\2\2pt\3\2\2\2"+
		"qs\t\5\2\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uy\3\2\2\2vt\3\2\2\2"+
		"wy\t\7\2\2xj\3\2\2\2xw\3\2\2\2y \3\2\2\2z}\5\35\17\2{}\5\37\20\2|z\3\2"+
		"\2\2|{\3\2\2\2}\"\3\2\2\2~\177\7g\2\2\177\u0080\7p\2\2\u0080\u0081\7f"+
		"\2\2\u0081$\3\2\2\2\u0082\u0084\t\b\2\2\u0083\u0082\3\2\2\2\u0084\u0085"+
		"\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0088\b\23\2\2\u0088&\3\2\2\2\20\2FNSX\\agjotx|\u0085\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}