package com.leekoy.controller;

import com.leekoy.service.mar.FeignHystrix;
import com.leekoy.service.mar.FeignOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pd 2018/3/22.
 */
@RestController
@RequestMapping("/mar")
public class March {

    @Autowired
    private FeignOne feignOne;

    @Autowired
    private FeignHystrix feignHystrix;

    @GetMapping("/client")
    public String client() {
        return feignOne.client1();
    }

    @GetMapping("/client2")
    public String client2() {
        return feignHystrix.client1();
    }

}
