// 语法文件通常以grammar关硉字开头
// 这是—个名为ArrayInit的语法.它必须和文件名Arrayinit.g4相匹配
grammar ArrayInit;

// 一条名为init的规则,它匹配一对花括号中的、逗号分院的value
init    :'{'value (',' value)* '}';  // 必须匹配至少一个value

// 一个value可以是嵌套的花括号结构,也可以是一个简单的整数,即INT词法符号
value   : init
        | INT
        ;

// 语法分析器的规则必须以小写字母开头,词法分析器的规则必须用大写字母开头
INT: [0-9]+; // 定义词法符号I N T,它击—个或多个数字组成
WS : [\t\r\n]+ -> skip ; // 定义词法规则"空白符号”,丢弃之