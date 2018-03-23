### eureka client

##### 负载均衡(Ribbon)
````
Ribbon是Netflix发布的云中间层服务开源项目，主要功能是提供客户端负载均衡算法。Ribbon客户端组件提供一系列完善的配置项，如，连接超时，
重试等。简单的说，Ribbon是一个客户端负载均衡器，我们可以在配置文件中列出load Balancer后面所有的机器，Ribbon会自动的帮助你基于某种
规则(如简单轮询，随机连接等)去连接这些机器，我们也很容易使用Ribbon实现自定义的负载均衡算法

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
##### 容错保护(Hystrix)
```
如果服务提供者的响速度十分缓慢，导致消费者请求一直处于等待状态，资源得不到释放，一旦请求积累过多，资源耗尽，就会导致服务不可用，很可
能引起雪崩效应，熔断机制 类似电路中的断路器，如果发生火灾或线路过载等问题时，断路器就会自动断开，熔断同理，比如请求超时时间设置5秒，
连续N个请求都没获得响应，那么基本就判断服务挂了，为了避免资源浪费，没有必要再去访问这个服务，可以采用断路器断开服务

Hystrix依赖jar包

<!-- hystrix 容错性 -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
    <version>1.4.0.RELEASE</version>
</dependency>

使用@EnableCircuitBreaker或@EnableHystrix注解开启容错保护
或者使用@SpringCloudApplication(这个注解强大包含了@EnableDiscoveryClient和@EnableCircuitBreaker)

Hystrix默认超时时间为2000mm
Hystrix的相关属性的修改参考com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager类

如：
@HystrixCommand(fallbackMethod = "error",commandProperties = {
@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "6000"),
                @HystrixProperty(name = "execution.timeout.enabled", value = "false")})
                
Hystrix-dashboard是一款针对Hystrix进行实时监控的工具，通过Hystrix Dashboard我们可以在直观地看到各Hystrix Command的请求响应时
间，请求成功率等数据

依赖jar包
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
    <version>1.4.0.RELEASE</version>
</dependency>

注解@EnableHystrixDashboard表示启用dashboard
访问地址：http://${hostname}:${port}/hystrix

```
##### 集群监控(Turbine)
```

```
