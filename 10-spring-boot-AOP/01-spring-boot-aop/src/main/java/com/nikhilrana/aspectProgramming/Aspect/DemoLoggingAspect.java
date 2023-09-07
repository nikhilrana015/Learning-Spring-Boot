package com.nikhilrana.aspectProgramming.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoLoggingAspect {


    //@Before(value = "execution(* add*(com.nikhilrana.aspectProgramming.Account, ..))")
    @Before(value = "execution(* com.nikhilrana.aspectProgramming.Dao.*.*(..))")
    void calledBeforeAddAccountMethod() {
        System.out.println("called before adding the account");
    }

}
