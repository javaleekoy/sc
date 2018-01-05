package com.leekoy.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author leekoy
 * @date 2018/1/4.
 * <p>
 * description 单独Hystrix
 */
@Component
public class FeignServerFallback2 {

    @Autowired
    private FeignService2 feignService2;

    @HystrixCommand(fallbackMethod = "defaultStores")
    public String sayHello() {
        return feignService2.sayHello();
    }

    public String defaultStores() {
        return "error-2";
    }


    @HystrixCommand(fallbackMethod = "defaultStores")
    public String sayHello(String str) {
        return feignService2.sayHello();
    }

    public String defaultStores(String str) {
        return str + "-error-2";
    }
}
