package com.nikhilrana.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
public class BadmintonCoach implements Coach {

    public BadmintonCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // define init method using postConstruct annotation which invoked after bean creation
    @PostConstruct
    public void afterBeanCreation() {
        System.out.println("Invoked after bean creation: " + getClass().getSimpleName());
    }

    // define destroy method using preDestroy annotation which invoked just before bean deletion
    @PreDestroy
    public void beforeBeanDeletion() {
        System.out.println("Invoked before bean deletion: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Play badminton for 30 minutes";
    }



}
