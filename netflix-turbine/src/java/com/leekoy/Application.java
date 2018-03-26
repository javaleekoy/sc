package com.leekoy;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author leekoy
 */
@SpringBootApplication
@EnableTurbine
//@EnableEurekaClient
@EnableHystrixDashboard
public class Application {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.run(args);
        springApplication.setBannerMode(Banner.Mode.CONSOLE);
    }

}
