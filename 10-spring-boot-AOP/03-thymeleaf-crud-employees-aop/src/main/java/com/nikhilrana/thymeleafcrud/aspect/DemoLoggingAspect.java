package com.nikhilrana.thymeleafcrud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    // logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // for controller package
    @Pointcut(value = "execution(* com.nikhilrana.thymeleafcrud.controller.*.*(..))")
    private void forControllerPackage() {};

    // for dao package
    @Pointcut(value = "execution(* com.nikhilrana.thymeleafcrud.dao.*.*(..))")
    private void forDaoPackage() {};

    // for service package
    @Pointcut(value = "execution(* com.nikhilrana.thymeleafcrud.service.*.*(..))")
    private void forServicePackage() {};

    @Pointcut(value = "forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFlow() {};

    @Before(value = "forAppFlow()")
    private void beforeCallAdvice(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        logger.info("=======>> in @Before advice: calling-method: " + method);

        Object[] args = joinPoint.getArgs();

        for(Object currArg: args) {
            logger.info("=======>> Arguments: " + currArg);
        }
    }


    @AfterReturning(value = "forAppFlow()", returning = "result")
    private void afterCallAdvice(JoinPoint joinPoint, Object result) {

        String method = joinPoint.getSignature().toShortString();
        logger.info("=======>> in @afterReturning advice: from-method: " + method);

        logger.info("=======>> result: " + result);
    }

}
