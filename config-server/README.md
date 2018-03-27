### spring-config-server
```
依赖jar包
<!-- config-server -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
    <version>1.4.0.RELEASE</version>
</dependency>

@EnableConfigServer 开启springConfig服务端

application.properties文件配置如下：

spring.application.name=config-server
server.port=9090
spring.cloud.config.server.git.uri=http://192.168.136.130:10080/root/propertiesConfig.git
spring.cloud.config.server.git.search-paths=details
spring.cloud.config.server.git.username=root
spring.cloud.config.server.git.password=123456789

spring.cloud.config.server.git.uri git项目地址.git结尾
spring.cloud.config.server.git.search-paths 配置仓库路径
spring.cloud.config.server.git.username 用户名
spring.cloud.config.server.git.password 密码
spring.cloud.config.label  配置仓库的分支

访问 Spring Cloud Config Server服务：
http://localhost:9090/leekoy/dev/master

http请求地址和资源文件映射如下:

/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties

```
