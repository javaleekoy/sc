package com.leekoy.service;

import org.springframework.stereotype.Component;

/**
 * @author leekoy
 * @date 2018/1/4.
 */
@Component
public class FeignServerFallback implements FeignService {

    @Override
    public String sayHello() {
        return "error-1";
    }

}
