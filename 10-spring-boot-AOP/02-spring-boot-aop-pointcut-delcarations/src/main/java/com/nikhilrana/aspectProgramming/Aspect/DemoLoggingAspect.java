package com.nikhilrana.aspectProgramming.Aspect;

import com.nikhilrana.aspectProgramming.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
@Order(2)
public class DemoLoggingAspect {

    @Around(value = "execution(* com.nikhilrana.aspectProgramming.Service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String method = proceedingJoinPoint.getSignature().toString();
        System.out.println("=>>>>>>> Method signature: " + method);

        System.out.println("=>>>>>>> Executing around successful invoking of getFortune method");

        long start = System.currentTimeMillis();

        // this will execute the method getFortune and stores the result
        // After that we can modify the result also.

        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
            return result;

        } catch (Exception exp) {
            System.out.println("=>>>>> Exception occurs");
            //result = "Exception is handled by around advice. Don't worry";
            //throw new Exception("Kuch galat hai bhai");
            throw exp;
        }

//        long end = System.currentTimeMillis();
//        long duration = end-start;
//
//        System.out.println("=>>>>> Total duration is: " + duration/1000);
        //System.out.println("=>>>>> Result is: " + result);
//        return result;
    }

    @After(value = "execution(* com.nikhilrana.aspectProgramming.Dao.AccountDao.findAccounts(..))")
    public void calledAfterFinallyAdviceFindAccounts(JoinPoint joinPoint) {

        System.out.println("=>>>>>>> Method signature: " + joinPoint.getSignature().toString());
        System.out.println("=>>>>>>> Executing after(Finally) successful invoking of findAccounts method");
    }


    @AfterThrowing(
            pointcut = "execution(* com.nikhilrana.aspectProgramming.Dao.AccountDao.findAccounts(..))",
            throwing = "exception"
    )
    public void calledAfterExceptionOccursInFindAccounts(JoinPoint joinPoint, Throwable exception) {
        System.out.println("=>>>>>>>>>> An exception is occured");
        System.out.println("=>>>>>>> Exception is: " + exception);
    }


    @AfterReturning(
            pointcut = "execution(* com.nikhilrana.aspectProgramming.Dao.AccountDao.findAccounts(..))",
            returning = "accountList"
    )
    public void calledAfterFindAccounts(JoinPoint joinPoint, List<Account>accountList) {

        System.out.println("=>>>>>>> Method signature: " + joinPoint.getSignature().toString());
        System.out.println("=>>>>>>> Executing after successful invoking of findAccounts method");
        //System.out.println("=>>>>>>> " + accountList);
        convertAccountNamesToUpperCase(accountList);
    }

    private void convertAccountNamesToUpperCase(List<Account> accountList) {
        for (Account account: accountList) {
            account.setFirstName(account.getFirstName().toUpperCase());
            account.setLastName(account.getLastName().toUpperCase());
        }
    }

    @Before(value = "com.nikhilrana.aspectProgramming.Aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
    public void calledBeforeAddAccountMethod() {
        System.out.println("called before adding the account");
    }

}
