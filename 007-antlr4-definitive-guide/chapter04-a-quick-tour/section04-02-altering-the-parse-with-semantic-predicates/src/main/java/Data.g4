grammar Data;

file : group+ ;

group: INT sequence[$INT.int] ;

sequence[int n]
locals [int i = 1;]
     : ( {$i<=$n}? INT {$i++;} )* // 匹配n个整数
     ;
     
INT :   [0-9]+ ;             // 匹配整数
WS  :   [ \t\n\r]+ -> skip ; // 丢弃所有的空门字符
