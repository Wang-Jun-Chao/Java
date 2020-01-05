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


file="$(pwd)/JSON.g4"
# 不需要生成监听器
antlr4 "$file"
javac JSON*.java
# grun JSON json -tokens
# [1, "\u0849", 1.3e9]
# grun JSON json -tree
# [1, "\u0849", 1.3e9]



