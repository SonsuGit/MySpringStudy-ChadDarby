package com.suha.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // lets' start with a @Befroe advice

    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice(){

        System.out.println("\n====>>> EXECUTING @Before ADVICE ON addAccount()");

    }
}
