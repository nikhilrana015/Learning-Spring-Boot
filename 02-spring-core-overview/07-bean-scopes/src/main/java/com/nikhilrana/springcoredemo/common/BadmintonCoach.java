package com.nikhilrana.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/*
    Scope of badminton changes from singleton to prototype. By default scope
    of every bean is singleton or single instance. When chooses prototype then
    for every dependency injection of badminton-coach, it creates a new bean
    every time.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BadmintonCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Play badminton for 30 minutes";
    }
}
