package com.leekoy.controller;

import com.leekoy.service.mar.FeginOne;
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
    private FeginOne feginOne;

    @GetMapping("/client")
    public String client() {
        return feginOne.client1();
    }

}
