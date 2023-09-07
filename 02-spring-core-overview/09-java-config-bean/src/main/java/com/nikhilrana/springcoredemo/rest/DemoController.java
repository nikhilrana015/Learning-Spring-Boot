package com.nikhilrana.springcoredemo.rest;

import com.nikhilrana.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Define the field for dependency injection
    private Coach coach;

    // Define a constructor method for dependency injection
    // Autowired tells the spring to inject dependency
    // If we have only one constructor then autowired is optional

    @Autowired
    public DemoController(@Qualifier("nikhilBean") Coach coach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.coach = coach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {

        return coach.getDailyWorkout();
    }

}
