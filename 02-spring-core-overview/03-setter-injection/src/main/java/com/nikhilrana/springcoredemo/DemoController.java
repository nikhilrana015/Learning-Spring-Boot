package com.nikhilrana.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Define the field for dependency injection
    private Coach coach;

    // Define a settor method for dependency injection
    // Autowired tells the spring to inject dependency
    // If we have only one constructor then autowired is optional
    // You can give any method name. Not compulsory to give setVariableName
    @Autowired
    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

}
