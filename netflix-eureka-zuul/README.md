#### spring-cloud-zuul
````
依赖jar包
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
    <version>1.4.0.RELEASE</version>
</dependency>

Zuul是Netflix出品的一个基于JVM路由和服务端的负载均衡器.
Zuul功能：
认证
压力测试
金丝雀测试
动态路由
负载削减
安全
静态响应处理
主动/主动交换管理

Zuul的规则引擎允许通过任何JVM语言来编写规则和过滤器, 支持基于Java和Groovy的构建

@EnableZuulProxy开启网关API

application.properties配置：
zuul.routes.leekoy.path=/leekoy/*
zuul.routes.leekoy.serviceId=client

zuul.routes.leekoy.path 访问路径
zuul.routes.leekoy.serviceId 服务Id
zuul.routes.leekoy.url  跳转路径

zuul 可添加filter检查请求的权限
继承 ZuulFilter 类 见：AccessFilter类

@Bean
public AccessFilter getAccessFilter() {
    return new AccessFilter();
}


````
