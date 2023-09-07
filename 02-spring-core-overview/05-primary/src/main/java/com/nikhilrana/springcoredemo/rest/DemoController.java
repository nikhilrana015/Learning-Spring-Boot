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
    /*
        If we don't want to use Qualifier then in that case we have to use
        primary annotation to avoid ambiguity. We can also use the Qualifier and
        primary annotation at the same time. Qualifier annotation is of higher
        priority then primary, so it overrides the primary dependency injection

        It is best to choose Qualifier only

     */
    @Autowired
    public DemoController(@Qualifier("footballCoach") Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

}
