// Generated from /Users/wangjunchao/IdeaProjects/Java/007-antlr4-definitive-guide/chapter05-exploring-some-real-grammars/section04-parsing-cymbol/src/main/java/Cymbol.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CymbolLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, ID=22, INT=23, WS=24, SL_COMMENT=25;
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
			"T__17", "T__18", "T__19", "T__20", "ID", "LETTER", "INT", "WS", "SL_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "';'", "'float'", "'int'", "'void'", "'('", "')'", "','", 
			"'{'", "'}'", "'if'", "'then'", "'else'", "'return'", "'['", "']'", "'-'", 
			"'!'", "'*'", "'+'", "'=='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "ID", "INT", 
			"WS", "SL_COMMENT"
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


	public CymbolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Cymbol.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u009a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3"+
		"\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\7\27{\n\27\f\27\16\27"+
		"~\13\27\3\30\3\30\3\31\6\31\u0083\n\31\r\31\16\31\u0084\3\32\6\32\u0088"+
		"\n\32\r\32\16\32\u0089\3\32\3\32\3\33\3\33\3\33\3\33\7\33\u0092\n\33\f"+
		"\33\16\33\u0095\13\33\3\33\3\33\3\33\3\33\3\u0093\2\34\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\2\61\31\63\32\65\33\3\2\5\3\2\62;\4\2C\\c|\5\2\13\f"+
		"\17\17\"\"\2\u009d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\59\3\2\2\2"+
		"\7;\3\2\2\2\tA\3\2\2\2\13E\3\2\2\2\rJ\3\2\2\2\17L\3\2\2\2\21N\3\2\2\2"+
		"\23P\3\2\2\2\25R\3\2\2\2\27T\3\2\2\2\31W\3\2\2\2\33\\\3\2\2\2\35a\3\2"+
		"\2\2\37h\3\2\2\2!j\3\2\2\2#l\3\2\2\2%n\3\2\2\2\'p\3\2\2\2)r\3\2\2\2+t"+
		"\3\2\2\2-w\3\2\2\2/\177\3\2\2\2\61\u0082\3\2\2\2\63\u0087\3\2\2\2\65\u008d"+
		"\3\2\2\2\678\7?\2\28\4\3\2\2\29:\7=\2\2:\6\3\2\2\2;<\7h\2\2<=\7n\2\2="+
		">\7q\2\2>?\7c\2\2?@\7v\2\2@\b\3\2\2\2AB\7k\2\2BC\7p\2\2CD\7v\2\2D\n\3"+
		"\2\2\2EF\7x\2\2FG\7q\2\2GH\7k\2\2HI\7f\2\2I\f\3\2\2\2JK\7*\2\2K\16\3\2"+
		"\2\2LM\7+\2\2M\20\3\2\2\2NO\7.\2\2O\22\3\2\2\2PQ\7}\2\2Q\24\3\2\2\2RS"+
		"\7\177\2\2S\26\3\2\2\2TU\7k\2\2UV\7h\2\2V\30\3\2\2\2WX\7v\2\2XY\7j\2\2"+
		"YZ\7g\2\2Z[\7p\2\2[\32\3\2\2\2\\]\7g\2\2]^\7n\2\2^_\7u\2\2_`\7g\2\2`\34"+
		"\3\2\2\2ab\7t\2\2bc\7g\2\2cd\7v\2\2de\7w\2\2ef\7t\2\2fg\7p\2\2g\36\3\2"+
		"\2\2hi\7]\2\2i \3\2\2\2jk\7_\2\2k\"\3\2\2\2lm\7/\2\2m$\3\2\2\2no\7#\2"+
		"\2o&\3\2\2\2pq\7,\2\2q(\3\2\2\2rs\7-\2\2s*\3\2\2\2tu\7?\2\2uv\7?\2\2v"+
		",\3\2\2\2w|\5/\30\2x{\5/\30\2y{\t\2\2\2zx\3\2\2\2zy\3\2\2\2{~\3\2\2\2"+
		"|z\3\2\2\2|}\3\2\2\2}.\3\2\2\2~|\3\2\2\2\177\u0080\t\3\2\2\u0080\60\3"+
		"\2\2\2\u0081\u0083\t\2\2\2\u0082\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\62\3\2\2\2\u0086\u0088\t\4\2"+
		"\2\u0087\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a"+
		"\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\b\32\2\2\u008c\64\3\2\2\2\u008d"+
		"\u008e\7\61\2\2\u008e\u008f\7\61\2\2\u008f\u0093\3\2\2\2\u0090\u0092\13"+
		"\2\2\2\u0091\u0090\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0094\3\2\2\2\u0093"+
		"\u0091\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7\f"+
		"\2\2\u0097\u0098\3\2\2\2\u0098\u0099\b\33\2\2\u0099\66\3\2\2\2\b\2z|\u0084"+
		"\u0089\u0093\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}