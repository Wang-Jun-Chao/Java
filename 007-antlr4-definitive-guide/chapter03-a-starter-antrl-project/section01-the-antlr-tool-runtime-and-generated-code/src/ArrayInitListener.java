// Generated from /Users/wangjunchao/IdeaProjects/Java/007-antlr4权威指南/第3章-入门的antlr项目/3.1-ANTLR工具-运行库以及自动生成的代码/src/ArrayInit.g4 by ANTLR 4.0
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface ArrayInitListener extends ParseTreeListener {
	void enterInit(ArrayInitParser.InitContext ctx);
	void exitInit(ArrayInitParser.InitContext ctx);

	void enterValue(ArrayInitParser.ValueContext ctx);
	void exitValue(ArrayInitParser.ValueContext ctx);
}