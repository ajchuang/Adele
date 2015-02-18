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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, ID=6, FLOAT=7, INT=8, NUM=9, WS=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "ID", "FLOAT", "INT", "NUM", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'*'", "'/'", "'+'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "ID", "FLOAT", "INT", "NUM", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\fV\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\6\7#\n\7\r\7\16\7$\3\7"+
		"\7\7(\n\7\f\7\16\7+\13\7\3\b\5\b.\n\b\3\b\6\b\61\n\b\r\b\16\b\62\3\b\3"+
		"\b\6\b\67\n\b\r\b\16\b8\3\t\5\t<\n\t\3\t\6\t?\n\t\r\t\16\t@\3\t\7\tD\n"+
		"\t\f\t\16\tG\13\t\3\t\5\tJ\n\t\3\n\3\n\5\nN\n\n\3\13\6\13Q\n\13\r\13\16"+
		"\13R\3\13\3\13\2\2\f\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\3\2"+
		"\t\5\2C\\aac|\6\2\62;C\\aac|\3\2//\3\2\62;\3\2\63;\3\2\62\62\5\2\13\f"+
		"\17\17\"\"`\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27"+
		"\3\2\2\2\5\31\3\2\2\2\7\33\3\2\2\2\t\35\3\2\2\2\13\37\3\2\2\2\r\"\3\2"+
		"\2\2\17-\3\2\2\2\21I\3\2\2\2\23M\3\2\2\2\25P\3\2\2\2\27\30\7=\2\2\30\4"+
		"\3\2\2\2\31\32\7,\2\2\32\6\3\2\2\2\33\34\7\61\2\2\34\b\3\2\2\2\35\36\7"+
		"-\2\2\36\n\3\2\2\2\37 \7/\2\2 \f\3\2\2\2!#\t\2\2\2\"!\3\2\2\2#$\3\2\2"+
		"\2$\"\3\2\2\2$%\3\2\2\2%)\3\2\2\2&(\t\3\2\2\'&\3\2\2\2(+\3\2\2\2)\'\3"+
		"\2\2\2)*\3\2\2\2*\16\3\2\2\2+)\3\2\2\2,.\t\4\2\2-,\3\2\2\2-.\3\2\2\2."+
		"\60\3\2\2\2/\61\t\5\2\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2\62\63"+
		"\3\2\2\2\63\64\3\2\2\2\64\66\7\60\2\2\65\67\t\5\2\2\66\65\3\2\2\2\678"+
		"\3\2\2\28\66\3\2\2\289\3\2\2\29\20\3\2\2\2:<\t\4\2\2;:\3\2\2\2;<\3\2\2"+
		"\2<>\3\2\2\2=?\t\6\2\2>=\3\2\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2\2AE\3\2\2"+
		"\2BD\t\5\2\2CB\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FJ\3\2\2\2GE\3\2\2"+
		"\2HJ\t\7\2\2I;\3\2\2\2IH\3\2\2\2J\22\3\2\2\2KN\5\17\b\2LN\5\21\t\2MK\3"+
		"\2\2\2ML\3\2\2\2N\24\3\2\2\2OQ\t\b\2\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2R"+
		"S\3\2\2\2ST\3\2\2\2TU\b\13\2\2U\26\3\2\2\2\16\2$)-\628;@EIMR\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}