#!/usr/bin/env bash
# 在 /etc/profile中配置好下面的内容

### 1、下载文件
#cd /usr/local/lib
#sudo curl -O https://www.antlr.org/download/antlr-4.7.2-complete.jar
#chmod +x antlr-4.7.2-complete.jar
### 2、修改/etc/profile文件
#export CLASSPATH=".:/usr/local/lib/antlr-4.7.2-complete.jar:$CLASSPATH"
alias antlr4='java -jar /usr/local/lib/antlr-4.7.2-complete.jar'
alias grun='java org.antlr.v4.gui.TestRig'


file="$(pwd)/Rows.g4"
# 不需要生成监听器
antlr4 -no-listener "$file"
javac Rows*.java Col*.java
# 测试
#java Col 1 < t.rows
#parrt
#tombu
#bke
#java Col 2 < t.rows
#Terence Parr
#Tom Burns
#Kevin Edgar
#java Col 3 < t.rows
#101
#020
#008



