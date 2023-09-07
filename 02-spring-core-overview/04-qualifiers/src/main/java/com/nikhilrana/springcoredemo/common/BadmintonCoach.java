package com.nikhilrana.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BadmintonCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Play badminton for 30 minutes";
    }
}
