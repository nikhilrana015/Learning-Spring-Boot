package com.nikhil.springboot.demo.myspringapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyControllers {

    @GetMapping("/")
    public String sayHello() {
        return "My first spring app";
    }

    @GetMapping("/doLeetcode")
    public  String doLeetcodeDaily() { return "Solve Leetcode questions"; }

    
}
