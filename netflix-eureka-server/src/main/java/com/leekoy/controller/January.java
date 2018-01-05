package com.leekoy.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author leekoy
 */
@RestController
public class January {

    @GetMapping("/sayHello")
    @ResponseBody
    public String sayHello() {
        return "80-> hello january !";
    }


    @PostMapping("/sayWords")
    @ResponseBody
    public String sayWords(@RequestParam("words") String words) {
        return "80->" + words;
    }

}
