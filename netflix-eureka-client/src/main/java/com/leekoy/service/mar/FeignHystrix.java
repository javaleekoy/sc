package com.leekoy.service.mar;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author pd 2018/3/26.
 */
@FeignClient(name = "client",fallback = FeignHystrixFallback.class)
@Component
public interface FeignHystrix {

    @GetMapping("/Feb/hystrix2")
    String client1();

}
