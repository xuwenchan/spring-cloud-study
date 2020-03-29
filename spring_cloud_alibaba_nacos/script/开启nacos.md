1.打开linux 192.168.75.128
source /etc/profile
service iptables stop

2，cd /usr/soft/nacos/nacos/bin
3,sh startup.sh -m standalone
4，访问：http://192.168.75.128:8848/nacos/index.html#/login
用户名：nacos
密码：nacos

配置文件加载顺序

bootstrap.properties>bootstrap.yml>application.properties>application.yml