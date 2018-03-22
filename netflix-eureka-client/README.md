### eureka client

##### 负载均衡
````
ribbon依赖jar包
<!-- ribbon 负载均衡 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
    <version>1.4.0.RELEASE</version>
</dependency>

@EnableDiscoveryClient
@LoadBalanced

@SpringBootApplication
@EnableDiscoveryClient
public class App {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(App.class).web(true).run(args);
    }
}

````
