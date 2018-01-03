package com.leekoy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author leekoy
 */
@RestController
public class January {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/sayHello")
    @ResponseBody
    public String sayHello() {
        String url = "http://EUREKA-SERVER-A/sayHello";
        String sayHello = restTemplate.getForEntity(url, String.class).getBody();
        return sayHello;
    }

}
