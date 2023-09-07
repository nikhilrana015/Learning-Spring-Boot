package com.nikhilrana.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*
    Component annotation marks the class CricketCoach
    as spring-bean and makes it available for
    dependency injection

    Primary annotation is used when we have multiple classes
    for dependency injection and we don't want to use @Qualifier.
    So to avoid ambiguity for every dependency injection it choose the
    primary annotation class from other class beans/objects

    Can't have multiple primary annotations, it will give error.

 */
@Component
@Primary
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice batting and bowling for 1 hour!!";
    }
}
