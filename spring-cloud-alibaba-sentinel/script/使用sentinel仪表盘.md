1,对Sentinel项目执行mvn clean package 进行打包
2，打包成功之后
  1），打开cmd 进入到sentienl-dashboard项目的target目录之下
  eg：F:\master\spring cloud alibaba\Sentinel\sentinel-dashboard\target
  执行：java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard.jar  命令
  如果端口冲突可以更改
  2），访问：http://8080
  3），默认的用户名和密码都是sentinel