grammar Expr;

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

ID  :   [a-zA-Z]+ ;      // 匹配标识符
INT :   [0-9]+ ;         // 匹配整数
NEWLINE:'\r'? '\n' ;     // 告诉语法分析器一个新行的开始(即语句终止标志)
WS  :   [ \t]+ -> skip ; // 丢弃空白字符