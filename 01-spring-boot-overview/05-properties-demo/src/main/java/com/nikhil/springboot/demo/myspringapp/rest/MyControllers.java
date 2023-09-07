package com.nikhil.springboot.demo.myspringapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyControllers {

    // inject properties for author.name and author.github

    @Value("${author.name}")
    private String authorName;

    @Value("${author.github}")
    private String githubUsername;

    @GetMapping("/author")
    public String getAuthor() { return authorName; }

    @GetMapping("/githubUsername")
    public String getGithubUsername() { return githubUsername; }

    @GetMapping("/")
    public String sayHello() {
        return "My first spring app";
    }

    @GetMapping("/doLeetcode")
    public  String doLeetcodeDaily() { return "Solve Leetcode questions"; }

    
}
