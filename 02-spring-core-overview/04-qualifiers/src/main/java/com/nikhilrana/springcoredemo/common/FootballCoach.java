package com.nikhilrana.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Play football for 2 hours";
    }
}
