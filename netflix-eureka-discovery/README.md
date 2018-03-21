## spring-netflix-eureka

#### 非集群模式
````
构建enreka服务端即服务注册中心
依赖包
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.5.9.RELEASE</version>
</parent>

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Dalston.SR4</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

<dependencies>
    <!-- eureka-server -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        <version>1.4.0.RELEASE</version>
    </dependency>
</dependencies>

通过@EnableEurekaServer注解启动一个服务注册中心提供给其他应用进行对话

@SpringBootApplication
@EnableEurekaServer
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

默认情况下该服务注册中心也会将自己作为客户端来尝试注册自己，所以要禁用它的客户端行为
eureka.client.register-with-eureka=false
false表示不向注册中心注册自己
eureka.client.fetch-register=false
由于注册中心的职责就是维护服务实例并不需要去检索服务，所以设置false
````
#### 集群模式
```
server端配置：
1.application-test1.properties

spring.application.name=eureka-server
server.port=8081
eureka.instance.hostname=test1
eureka.client.service-url.defaultZone=http://test2:8082/eureka/

2.application-test2.properties

spring.application.name=eureka-server
server.port=8082
eureka.instance.hostname=test2
eureka.client.service-url.defaultZone=http://test1:8081/eureka/

启动项目
java -jar netflix-eureka-discovery-1.0-SNAPSHOT.jar --spring.profiles.active=test1
java -jar netflix-eureka-discovery-1.0-SNAPSHOT.jar --spring.profiles.active=test2

client端配置：

client.service-url.defaultZone=http://test1:8081/eureka/,http://test2:8082/eureka/
或
client.service-url.defaultZone=http://test1:8081/eureka/
ps:倘若client端配置了所有server的地址，那么每当server增加删除了一个服务后，客户端就需要随之改变，
那不是我们希望看到的，
若test1机器宕机了，但是我们看到client的注册信息还在，这说明test2还能继续提供注册发现的服务，
这样就避免了单点故障后的整体服务发现的瘫痪这样就避免了单点故障后的整体服务发现的瘫痪。

```