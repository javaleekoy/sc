package com.leekoy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pd 2018/3/27.
 */
@RestController
@RequestMapping("/apr")
public class April {

      @Autowired
      private Environment env;

    @Value("${app.env}")
    private String app_env;

    @GetMapping("/client")
    public String client() {
        System.out.println(app_env);
        return "success";
    }


    @GetMapping("/client2")
    public String client2() {
        System.out.println(env.getProperty("app.env","haha"));
        return "success";
    }

}
