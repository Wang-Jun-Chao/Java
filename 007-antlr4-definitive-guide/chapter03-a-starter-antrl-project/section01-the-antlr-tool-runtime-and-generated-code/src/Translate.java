import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Translate {
    public static void main(String[] args) throws Exception {
        // 新建一个CharStream从标准输入读取奻据
        ANTLRInputStream input;
        input = new ANTLRInputStream(System.in);
        // 新建一个词法分析器,处理输入的CharStream
        ArrayInitLexer lexer = new ArrayInitLexer(input);
        // 新建一个词法符号的缓冲区,用于存付储词法分析器将生成的词法符号
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // 新建一个语法分析器,处理词法符号缓冲区中的内容
        ArrayInitParser parser = new ArrayInitParser(tokens);
        ParseTree tree = parser.init(); // 针对init规则,升始语法分析

        // 新建一个通用的、能够触发回调函数的语法法分析树遍历器
        ParseTreeWalker walker = new ParseTreeWalker();
        // 遍历语法分析过程中生成的语法分析树,触发回调
        walker.walk(new ShortToUnicodeString(), tree);
        System.out.println(); // 翻译完成后,打印一个\n
    }
}
