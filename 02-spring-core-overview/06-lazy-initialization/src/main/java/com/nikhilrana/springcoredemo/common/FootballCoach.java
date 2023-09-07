package com.nikhilrana.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/*
    Lazy annotation means that it didn't create the bean
    of the class until not required. Without lazy, spring
    creates the bean or object of the class either is required
    or not in future.
 */
@Component
@Lazy
public class FootballCoach implements Coach{

    public FootballCoach() {
        System.out.println("Inside constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Play football for 2 hours";
    }
}
