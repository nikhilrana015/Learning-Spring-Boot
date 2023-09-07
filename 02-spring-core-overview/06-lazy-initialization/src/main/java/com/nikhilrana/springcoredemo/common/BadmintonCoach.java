package com.nikhilrana.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BadmintonCoach implements Coach {

    public BadmintonCoach() {
        System.out.println("Inside constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Play badminton for 30 minutes";
    }
}
