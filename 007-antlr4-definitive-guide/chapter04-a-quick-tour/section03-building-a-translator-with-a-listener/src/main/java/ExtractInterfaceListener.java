/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
 ***/

import org.antlr.v4.runtime.TokenStream;

public class ExtractInterfaceListener extends JavaBaseListener {
    JavaParser parser;

    public ExtractInterfaceListener(JavaParser parser) {
        this.parser = parser;
    }

    /**
     * 监听对类定义的匹配
     */
    @Override
    public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
        System.out.println("interface I" + ctx.Identifier() + " {");
    }

    @Override
    public void exitClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
        System.out.println("}");
    }

    /**
     * 监听对方法定义的匹配
     */
    @Override
    public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
        // 需要从语法分听器中获取词法符号
        TokenStream tokens = parser.getTokenStream();
        String type = "void";
        if (ctx.type() != null) {
            type = tokens.getText(ctx.type());
        }
        String args = tokens.getText(ctx.formalParameters());
        System.out.println("\t" + type + " " + ctx.Identifier() + args + ";");
    }
}
