# antlr4 OS X 安装
## 下载文件
```shell script
cd /usr/local/lib
sudo curl -O https://www.antlr.org/download/antlr-4.7.2-complete.jar
chmod +x antlr-4.7.2-complete.jar
```

## 修改 /etc/profile 文件
```shell script
export CLASSPATH=".:/usr/local/lib/antlr-4.7.2-complete.jar:$CLASSPATH"
alias antlr4='java -jar /usr/local/lib/antlr-4.7.2-complete.jar'
alias grun='java org.antlr.v4.gui.TestRig'
```
