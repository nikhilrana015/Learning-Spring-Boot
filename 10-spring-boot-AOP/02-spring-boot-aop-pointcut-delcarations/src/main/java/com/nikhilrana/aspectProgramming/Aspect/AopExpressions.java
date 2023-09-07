package com.nikhilrana.aspectProgramming.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    // Applying the pointcut annotation to prevent code duplication by applying @before on methods

    @Pointcut(value = "execution(* com.nikhilrana.aspectProgramming.Dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut(value = "execution(* com.nikhilrana.aspectProgramming.Dao.*.get*(..))")
    public void getter() {};

    @Pointcut(value = "execution(* com.nikhilrana.aspectProgramming.Dao.*.set*(..))")
    public void setter() {};

    @Pointcut(value = "forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterAndSetter() {};

}
