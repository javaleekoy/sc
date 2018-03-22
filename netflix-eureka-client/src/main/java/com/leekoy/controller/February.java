package com.leekoy.controller;

import com.leekoy.service.feb.FebService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author leekoy
 */
@RestController
@RequestMapping("/Feb")
public class February {


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private FebService febService;


    @GetMapping("/hystrix1")
    public String hystrix1() {
        return febService.FebHystrix();
    }


    @GetMapping("/hystrix2")
    @HystrixCommand(fallbackMethod = "error")
    public String hystrix2() {
        //hystrix的超时时间为2000毫秒
        String url = "http://CLIENT/Jan/client2";
        String sayHello = restTemplate.getForEntity(url, String.class).getBody();
        return sayHello;
    }


    @GetMapping("/hystrix3")
    @HystrixCommand(fallbackMethod = "error",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "6000"),
                    @HystrixProperty(name = "execution.timeout.enabled", value = "false")})
    public String hystrix3() {
        //修改hystrix的超时时间为6000毫秒
        String url = "http://CLIENT/Jan/client2";
        String sayHello = restTemplate.getForEntity(url, String.class).getBody();
        return sayHello;
    }

    public String error() {
        return "error";
    }


}
