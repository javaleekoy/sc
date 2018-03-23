package com.leekoy.service.mar;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author pd 2018/3/22.
 */
@FeignClient(name = "client")
@Component
public interface FeginOne {

    @GetMapping("/Jan/client")
    String client1();

}
