// Generated from C:/Users/jan/IdeaProjects/init\Demo.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DemoLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, NUMBER=21, WHITESPACE=22, IDENTIFIER=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "NUMBER", "WHITESPACE", "IDENTIFIER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'watwenn'", "'('", "')'", "'sonstdat'", "'{'", "'}'", "'/'", 
			"'*'", "'-'", "'+'", "'<'", "'<='", "'>'", "'>='", "'janzezahl'", "'='", 
			"'zeichma('", "'hauraus'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "NUMBER", "WHITESPACE", 
			"IDENTIFIER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public DemoLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Demo.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u0090\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\6\26"+
		"\177\n\26\r\26\16\26\u0080\3\27\6\27\u0084\n\27\r\27\16\27\u0085\3\27"+
		"\3\27\3\30\3\30\7\30\u008c\n\30\f\30\16\30\u008f\13\30\2\2\31\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\3\2\5\3\2\62;\5\2\13\f\17\17\"\"\4\2C\\"+
		"c|\2\u0092\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\3\61\3\2\2\2\5\63\3\2\2\2\7;\3\2\2\2\t=\3\2\2\2\13?\3\2\2"+
		"\2\rH\3\2\2\2\17J\3\2\2\2\21L\3\2\2\2\23N\3\2\2\2\25P\3\2\2\2\27R\3\2"+
		"\2\2\31T\3\2\2\2\33V\3\2\2\2\35Y\3\2\2\2\37[\3\2\2\2!^\3\2\2\2#h\3\2\2"+
		"\2%j\3\2\2\2\'s\3\2\2\2){\3\2\2\2+~\3\2\2\2-\u0083\3\2\2\2/\u0089\3\2"+
		"\2\2\61\62\7=\2\2\62\4\3\2\2\2\63\64\7y\2\2\64\65\7c\2\2\65\66\7v\2\2"+
		"\66\67\7y\2\2\678\7g\2\289\7p\2\29:\7p\2\2:\6\3\2\2\2;<\7*\2\2<\b\3\2"+
		"\2\2=>\7+\2\2>\n\3\2\2\2?@\7u\2\2@A\7q\2\2AB\7p\2\2BC\7u\2\2CD\7v\2\2"+
		"DE\7f\2\2EF\7c\2\2FG\7v\2\2G\f\3\2\2\2HI\7}\2\2I\16\3\2\2\2JK\7\177\2"+
		"\2K\20\3\2\2\2LM\7\61\2\2M\22\3\2\2\2NO\7,\2\2O\24\3\2\2\2PQ\7/\2\2Q\26"+
		"\3\2\2\2RS\7-\2\2S\30\3\2\2\2TU\7>\2\2U\32\3\2\2\2VW\7>\2\2WX\7?\2\2X"+
		"\34\3\2\2\2YZ\7@\2\2Z\36\3\2\2\2[\\\7@\2\2\\]\7?\2\2] \3\2\2\2^_\7l\2"+
		"\2_`\7c\2\2`a\7p\2\2ab\7|\2\2bc\7g\2\2cd\7|\2\2de\7c\2\2ef\7j\2\2fg\7"+
		"n\2\2g\"\3\2\2\2hi\7?\2\2i$\3\2\2\2jk\7|\2\2kl\7g\2\2lm\7k\2\2mn\7e\2"+
		"\2no\7j\2\2op\7o\2\2pq\7c\2\2qr\7*\2\2r&\3\2\2\2st\7j\2\2tu\7c\2\2uv\7"+
		"w\2\2vw\7t\2\2wx\7c\2\2xy\7w\2\2yz\7u\2\2z(\3\2\2\2{|\7.\2\2|*\3\2\2\2"+
		"}\177\t\2\2\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3"+
		"\2\2\2\u0081,\3\2\2\2\u0082\u0084\t\3\2\2\u0083\u0082\3\2\2\2\u0084\u0085"+
		"\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0088\b\27\2\2\u0088.\3\2\2\2\u0089\u008d\t\4\2\2\u008a\u008c\t\4\2\2"+
		"\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008e\60\3\2\2\2\u008f\u008d\3\2\2\2\6\2\u0080\u0085\u008d\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}