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


file="$(pwd)/Expr.g4"
antlr4 "$file"
javac *.java

# 测试
# grun Expr prog -gui t.expr

# 测试
#javac ExprJoyRide. java Expr*.j ava
#java ExprJoyRide t.expr
# 输出
# (prog (stat (expr 193) \n) (stat a = (expr 5) \n) (stat b = (expr 6) \n) (stat (expr (expr a) + (expr (expr b) * (expr 2))) \n) (stat (expr (expr ( (expr (expr 1) + (expr 2)) )) * (expr 3)) \n))