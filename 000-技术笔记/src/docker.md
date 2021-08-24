# Nacos Docker部署

```sh
# 启动docker
# -v 宿主机目录:容器目录
docker run -d \
-e MODE=standalone \
-e SPRING_DATASOURCE_PLATFORM=mysql \
-e MYSQL_SERVICE_HOST=192.168.241.129 \
-e MYSQL_SERVICE_PORT=3306 \
-e MYSQL_SERVICE_USER=root \
-e MYSQL_SERVICE_PASSWORD=123456 \
-e MYSQL_SERVICE_DB_NAME=ry-config \
-e NACOS_SERVER_PORT=8848 
-e JVM_XMS=512m \
-e JVM_XMX=512m \
-v /home/ubuntu/docker/nacos/init.d/custom.properties:/home/nacos/init.d/custom.properties \
-v /home/ubuntu/docker/nacos/logs:/home/nacos/logs \
-p 8848:8848 \
-p 9848:9848 \
-p 9849:9849 \
--restart=always \
--name nacos \
nacos/nacos-server
```

custom.properties配置

```properties
server.contextPath=/nacos
server.servlet.contextPath=/nacos
server.port=8848

spring.datasource.platform=mysql

db.num=1
db.url.0=jdbc:mysql://192.169.241.129:3306/ry-config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
db.user=root
db.password=123456


nacos.cmdb.dumpTaskInterval=3600
nacos.cmdb.eventTaskInterval=10
nacos.cmdb.labelTaskInterval=300
nacos.cmdb.loadDataAtStart=false

management.metrics.export.elastic.enabled=false

management.metrics.export.influx.enabled=false


server.tomcat.accesslog.enabled=true
server.tomcat.accesslog.pattern=%h %l %u %t "%r" %s %b %D %{User-Agent}i


nacos.security.ignore.urls=/,/**/*.css,/**/*.js,/**/*.html,/**/*.map,/**/*.svg,/**/*.png,/**/*.ico,/console-fe/public/**,/v1/auth/login,/v1/console/health/**,/v1/cs/**,/v1/ns/**,/v1/cmdb/**,/actuator/**,/v1/console/server/**
nacos.naming.distro.taskDispatchThreadCount=1
nacos.naming.distro.taskDispatchPeriod=200
nacos.naming.distro.batchSyncKeyCount=1000
nacos.naming.distro.initDataRatio=0.9
nacos.naming.distro.syncRetryDelay=5000
nacos.naming.data.warmup=true
nacos.naming.expireInstance=true

```



[使用Docker部署Nacos-Server(单机版) - 简书 (jianshu.com)](https://www.jianshu.com/p/3d3e17bc629f)



# Seata Docker部署

```sh
docker run -d \
-v /home/ubuntu/docker/seata/file.conf:/seata-server/resources/file.conf \
-v /home/ubuntu/docker/seata/registry.conf:/seata-server/resources/registry.conf \
-p 8091:8091 \
--restart=always \
--name seata \
seataio/seata-server

docker run -d \
-e SEATA_CONFIG_NAME=file:/root/seata-config/registry \
-v /home/ubuntu/docker/seata:/root/seata-config \
-p 8091:8091 \
--restart=always \
--name seata \
seataio/seata-server:1.4.2
# 使用1.4.2版本，高于此版本的启动有问题
# io.seata.common.loader.EnhancedServiceNotFoundException: not found service provider for : io.seata.core.store.DistributedLocker
```

registry.conf配置

```txt
registry {
  type = "nacos"
  nacos {
    application = "seata-server"
    serverAddr = "192.168.241.129:8848"
    group = "SEATA_GROUP"
    namespace = "public"
    cluster = "default"
    username = "nacos"
    password = "nacos"
  }
}

config {
  type = "nacos"
  nacos {
    serverAddr = "192.168.241.129:8848"
    namespace = "public"
    group = "SEATA_GROUP"
    username = "nacos"
    password = "nacos"
  }
}
```

使用Nacso的Nacos-config.sh导入数据，nacos-config.sh

```sh
#!/bin/sh
# Copyright 1999-2019 Seata.io Group.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at、
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

while getopts ":h:p:g:t:u:w:" opt
do
  case $opt in
  h)
    host=$OPTARG
    ;;
  p)
    port=$OPTARG
    ;;
  g)
    group=$OPTARG
    ;;
  t)
    tenant=$OPTARG
    ;;
  u)
    username=$OPTARG
    ;;
  w)
    password=$OPTARG
    ;;
  ?)
    echo " USAGE OPTION: $0 [-h host] [-p port] [-g group] [-t tenant] [-u username] [-w password] "
    exit 1
    ;;
  esac
done

if [ -z ${host} ]; then
    host=localhost
fi
if [ -z ${port} ]; then
    port=8848
fi
if [ -z ${group} ]; then
    group="SEATA_GROUP"
fi
if [ -z ${tenant} ]; then
    tenant=""
fi
if [ -z ${username} ]; then
    username=""
fi
if [ -z ${password} ]; then
    password=""
fi

nacosAddr=$host:$port
contentType="content-type:application/json;charset=UTF-8"

echo "set nacosAddr=$nacosAddr"
echo "set group=$group"

urlencode() {
  length="${#1}"
  i=0
  while [ $length -gt $i ]; do
    char="${1:$i:1}"
    case $char in
    [a-zA-Z0-9.~_-]) printf $char ;;
    *) printf '%%%02X' "'$char" ;;
    esac
    i=`expr $i + 1`
  done
}

failCount=0
tempLog=$(mktemp -u)
function addConfig() {
  dataId=`urlencode $1`
  content=`urlencode $2`
  curl -X POST -H "${contentType}" "http://$nacosAddr/nacos/v1/cs/configs?dataId=$dataId&group=$group&content=$content&tenant=$tenant&username=$username&password=$password" >"${tempLog}" 2>/dev/null
  if [ -z $(cat "${tempLog}") ]; then
    echo " Please check the cluster status. "
    exit 1
  fi
  if [ "$(cat "${tempLog}")" == "true" ]; then
    echo "Set $1=$2 successfully "
  else
    echo "Set $1=$2 failure "
    failCount=`expr $failCount + 1`
  fi
}

count=0
for line in $(cat $(dirname "$PWD")/config.txt | sed s/[[:space:]]//g); do
    count=`expr $count + 1`
	key=${line%%=*}
    value=${line#*=}
	addConfig "${key}" "${value}"
done

echo "========================================================================="
echo " Complete initialization parameters,  total-count:$count ,  failure-count:$failCount "
echo "========================================================================="

if [ ${failCount} -eq 0 ]; then
	echo " Init nacos config finished, please start seata-server. "
else
	echo " init nacos config fail. "
fi
```





# Sentinel Docker部署

```sh
docker run -d \
-p 8858:8858 \
--restart=always \
--name sentinel \
bladex/sentinel-dashboard:1.8.0
```























































