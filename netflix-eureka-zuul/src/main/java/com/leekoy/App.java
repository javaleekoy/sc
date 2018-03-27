package com.leekoy;

import com.leekoy.filter.AccessFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author leekoy
 */
@EnableZuulProxy
@SpringCloudApplication
public class App {

    public static void main(String[] args) {
        /*SpringApplication.run(App.class, args);*/
        new SpringApplicationBuilder(App.class).web(true).run(args);
    }

    @Bean
    public AccessFilter getAccessFilter() {
        return new AccessFilter();
    }

}
