package com.danieljyc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by daniel on 2017/10/30.
 */
@RestController
public class HelloWorld {
    @Value("${com.dudu.name}")
    private String name;
    @Value("${com.dudu.want}")
    private String want;

    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot3";
    }


    @RequestMapping("/msg")
    public String hexo() {
        return name + "," + want;
    }

}
