package com.nikhilrana.springcoredemo;

import org.springframework.stereotype.Component;

/*
    Component annotation marks the class CricketCoach
    as spring-bean and makes it available for
    dependency injection
 */
@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice batting for 1 hour!!";
    }
}
