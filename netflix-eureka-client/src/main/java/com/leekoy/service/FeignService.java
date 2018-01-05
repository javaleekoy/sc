package com.leekoy.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author peramdy
 * @date 2018/1/4
 *
 * description feign结合Hystrix
 *
 */
@FeignClient(value = "EUREKA-SERVER-A",fallback = FeignServerFallback.class)
public interface FeignService {

    /**
     * say hello
     *
     * @return
     */
    @GetMapping("/sayHello")
    String sayHello();

}
