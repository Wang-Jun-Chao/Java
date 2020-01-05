#!/usr/bin/env bash
# 在 /etc/profile中配置好下面的内容

antlr4file="/Users/wangjunchao/IdeaProjects/Java/007-antlr4权威指南/lib/antlr-4.0-complete.jar"
alias antlr4="java -jar $antlr4file"
alias grun='java org.antlr.v4.runtime.misc.TestRig '
export CLASSPATH="$CLASSPATH:$antlr4file"

file="$(pwd)/ArrayInit.g4"
antlr4 "$file"
javac *.java Test.java Translate.java

# 测试
#~$grun ArrayInit init -tokens
#{99, 3, 451}
#<EOF>
# 输出
#line 1:4 token recognition error at: ' '
#line 1:7 token recognition error at: ' '
#[@0,0:0='{',<1>,1:0]
#[@1,1:2='99',<4>,1:1]
#[@2,3:3=',',<2>,1:3]
#[@3,5:5='3',<4>,1:5]
#[@4,6:6=',',<2>,1:6]
#[@5,8:10='451',<4>,1:8]
#[@6,11:11='}',<3>,1:11]
#[@7,13:12='<EOF>',<-1>,2:0]

# 测试
#~$grun ArrayInit init -tree
#{99, 3, 451}
#<EOF>
# 输出
#line 1:4 token recognition error at: ' '
#line 1:7 token recognition error at: ' '
#(init { (value 99) , (value 3) , (value 451) })

# 测试
# java Test
#{1,2
#line 2:0 missing '}' at '<EOF>'
#(init { (value 1) , (value 2) <missing '}'>)

# 测试
# java Translate
#{99, 3, 451}
#<EOF>
# 输出
#line 1:4 token recognition error at: ' '
#line 1:7 token recognition error at: ' '
#"\u0063\u0003\u01c3"