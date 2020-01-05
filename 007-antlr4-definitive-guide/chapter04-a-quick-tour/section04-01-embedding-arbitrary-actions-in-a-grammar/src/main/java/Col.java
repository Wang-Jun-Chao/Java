
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Col {
    public static void main(String[] args) throws Exception {
        CharStream input = CharStreams.fromStream(System.in);
        RowsLexer lexer = new RowsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        int col = Integer.parseInt(args[0]);
        RowsParser parser = new RowsParser(tokens, col); // 传递列号作为参数
        parser.setBuildParseTree(false); // 不需要浪费时间建立语法分析树
        parser.file(); // 开始语法分析
    }
}
