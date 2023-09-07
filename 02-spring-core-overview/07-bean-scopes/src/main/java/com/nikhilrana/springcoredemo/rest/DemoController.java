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
    private Coach anotherCoach;

    // Define a constructor method for dependency injection
    // Autowired tells the spring to inject dependency
    // If we have only one constructor then autowired is optional

    /*
            By default bean scopes are singleton in nature
            Every bean which is created at the start, all should provided
            for every required dependency injection.
     */

    @Autowired
    public DemoController(@Qualifier("badmintonCoach") Coach coach, @Qualifier("badmintonCoach")Coach anotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.coach = coach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/scopeCheck")
    public String getDailyWorkout() {

        return "Comparing beans: coach == anotherCoach: " + (coach == anotherCoach);
    }

}
