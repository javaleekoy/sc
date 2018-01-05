package com.leekoy.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author peramdy
 * @date 2018/1/4
 */
@FeignClient("EUREKA-SERVER-A")
public interface FeignService2 {

    /**
     * say hello
     *
     * @return
     */
    @GetMapping("/sayHello")
    String sayHello();

}
