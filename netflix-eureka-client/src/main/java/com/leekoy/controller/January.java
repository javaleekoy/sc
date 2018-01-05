package com.leekoy.controller;

import com.leekoy.service.FeignServerFallback2;
import com.leekoy.service.FeignService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author leekoy
 */
@RestController
public class January {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    FeignService feignService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private FeignServerFallback2 feignServerFallback2;

    @GetMapping("/sayHello")
    @ResponseBody
    public String sayHello() {
        String url = "http://EUREKA-SERVER-A/sayHello";
        String sayHello = restTemplate.getForEntity(url, String.class).getBody();
        return sayHello;
    }


    @GetMapping("/sayHello2")
    @ResponseBody
    public String sayHello2() {
        String sayHello = feignService.sayHello();
        return sayHello;
    }

    @GetMapping("/sayHello3")
    @ResponseBody
    public String sayHello3() {
        String sayHello = feignServerFallback2.sayHello();
        return sayHello;
    }

    @GetMapping("/sayHello4")
    @ResponseBody
    public String sayHello4() {
        String sayHello = feignServerFallback2.sayHello("hello");
        return sayHello;
    }

    @GetMapping("/serverUrl")
    @ResponseBody
    public String serviceUrl() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("EUREKA-SERVER-A", false);
        System.out.println(instance.getHomePageUrl());
        System.out.println(instance.getAppName());
        System.out.println(instance.getHealthCheckUrl());
        System.out.println(instance.getIPAddr());
        System.out.println(instance.getInstanceId());
        return instance.getHomePageUrl();
    }

    @GetMapping("/serverUri")
    @ResponseBody
    public String serviceUri(@RequestParam(value = "name",required = false) String serviceName) {
        if (serviceName == null) {
            serviceName = "EUREKA-SERVER-A";
        }
        List<ServiceInstance> list = discoveryClient.getInstances(serviceName);
        if (list != null && list.size() > 0) {
            for (ServiceInstance s : list) {
                System.out.println(s.getServiceId());
                System.out.println(s.getPort());
                System.out.println(s.getHost());
                System.out.println(s.getUri().getHost());
            }
        }
        return "serverUri";
    }

}
