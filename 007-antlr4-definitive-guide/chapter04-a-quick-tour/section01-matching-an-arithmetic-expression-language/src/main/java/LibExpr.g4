grammar LibExpr;            // 为了和疻先的语法区分开, 注行了重命名
import CommonLexerRules;    // 引入CommonlexerRules.g4中的全部规则

/** 起始规则，语法分析的起点。 */
prog:   stat+ ;

stat:   expr NEWLINE
    |   ID '=' expr NEWLINE
    |   NEWLINE
    ;

expr:   expr ('*'|'/') expr
    |   expr ('+'|'-') expr
    |   INT
    |   ID
    |   '(' expr ')'
    ;