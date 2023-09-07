package com.nikhilrana.springcoredemo.common;

import org.springframework.stereotype.Component;

/*
    Component annotation marks the class CricketCoach
    as spring-bean and makes it available for
    dependency injection
 */
@Component
public class CricketCoach implements Coach{
    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice batting and bowling for 1 hour!!";
    }
}
