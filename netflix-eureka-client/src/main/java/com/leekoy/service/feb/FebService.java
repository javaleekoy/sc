package com.leekoy.service.feb;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author leekoy
 */
@Service
public class FebService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    public String FebHystrix() {
        String url = "http://CLIENT/Jan/client";
        String sayHello = restTemplate.getForEntity(url, String.class).getBody();
        return sayHello;
    }


    public String error() {
        return "error";
    }

}
