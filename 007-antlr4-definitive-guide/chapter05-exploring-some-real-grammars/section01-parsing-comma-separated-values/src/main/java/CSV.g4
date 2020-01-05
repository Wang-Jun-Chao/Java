grammar CSV;

file : hdr row+ ;
hdr : row ; // 标题行

row : field (',' field)* '\r'? '\n' ;

field
    :   TEXT
    |   STRING
    |
    ;

TEXT : ~[,\n\r"]+ ;             // 注意：这里不处理双引号
STRING : '"' ('""'|~'"')* '"' ; // 两个双引号是对双引号的转义
