#### spring-config-client
```
依赖jar包
<!-- spring-boot-starter-web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- config-client -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-client</artifactId>
    <version>1.4.0.RELEASE</version>
</dependency>

application.properties配置文件

spring.application.name=config-client
spring.cloud.config.uri=http=//localhost:9090/
spring.cloud.config.profile=dev
spring.cloud.config.label=master
server.port=9091

spring.cloud.config.uri 指明配置服务中心的网址
# dev 开发环境配置文件 |  test 测试环境  |  pro 正式环境
spring.cloud.config.profile 和git里的文件名对应
spring.cloud.config.label 远程仓库的分支


```
