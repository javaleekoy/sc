package com.leekoy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author leekoy
 */
@RestController
@ConditionalOnClass
public class January {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/client")
    @ResponseBody
    public String client1() {
        return "client2";
    }

    @GetMapping("/ribbon")
    @ResponseBody
    public String ribbon() {
        String url = "http://CLIENT/client";
        String sayHello = restTemplate.getForEntity(url, String.class).getBody();
        return sayHello;
    }

}
