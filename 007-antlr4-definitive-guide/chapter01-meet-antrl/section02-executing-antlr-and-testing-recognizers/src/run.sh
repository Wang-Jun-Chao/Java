#!/usr/bin/env bash
# 在 /etc/profile中配置好下面的内容

antlr4file="/Users/wangjunchao/IdeaProjects/Java/007-antlr4权威指南/lib/antlr-4.0-complete.jar"
alias antlr4="java -jar $antlr4file"
alias grun='java org.antlr.v4.runtime.misc.TestRig '
export CLASSPATH="$CLASSPATH:$antlr4file"

file="$(pwd)/Hello.g4"
antlr4 "$file"
javac *.java

# 测试一
#~$grun Hello r -tokens # 使用Hello语法和r规则启动TestRig
#~hello parrt           # 程入要被识引的语句
#~<EOF>                 # 在UNIX系统上输入Ctrl+D或者Windows系统上钮入Ctrl+Z来轴入文件结束符

# 输出
# [@0,0:4='hello',<l>,1:0]      # 以下三行是grun的输出
# [@1, 6:10= 'parrt', <2>, 1:6]
# [@2,12:ll='<EOF>' ,<-l>,2:0]

#~$ grun Hello r -tree
#~$hello parrt
#~<EOF>

# 输出
# (r hello parrt)

# 显示图形界面
# ~$grun Hello r -gui
#~$hello parrt
#~<EOF>

# 输出
# 一个图形界面