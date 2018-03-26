package com.leekoy.service.mar;

import org.springframework.stereotype.Component;

/**
 * @author pd 2018/3/26.
 */
@Component
public class FeignHystrixFallback implements FeignHystrix {

    @Override
    public String client1() {
        return "error";
    }
}
