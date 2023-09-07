package com.nikhilrana.aspectProgramming.Aspect;

import com.nikhilrana.aspectProgramming.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Aspect
@Order(1)
public class MyCloudLogInAspect {

    @Before(value = "com.nikhilrana.aspectProgramming.Aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
    public void calledLogToCloud(JoinPoint joinPoint) {
        System.out.println("Performing logging to cloud first");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        Object[] objects = joinPoint.getArgs();
        System.out.println("Parameters: ");

        for (Object obj: objects) {
            System.out.println(obj);

//            if(obj instanceof Account) {
//                Account account = (Account) obj;
//                System.out.println("Account first name: " + account.getFirstName());
//                System.out.println("Account last name: " + account.getLastName());
//                System.out.println("Account last name: " + account.getEmail());
//            }
        }

    }
}
