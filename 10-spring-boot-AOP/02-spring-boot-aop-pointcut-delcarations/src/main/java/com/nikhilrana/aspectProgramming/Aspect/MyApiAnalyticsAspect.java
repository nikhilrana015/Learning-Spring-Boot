package com.nikhilrana.aspectProgramming.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class MyApiAnalyticsAspect {

    @Before(value = "com.nikhilrana.aspectProgramming.Aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
    public void calledApiAnalytics() {
        System.out.println("Performing api analytics method first");
    }

}
