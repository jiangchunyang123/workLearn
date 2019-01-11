package com.learn.spring.Chap4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import static com.learn.base.Log4jTestLogger.*;
/**
 * 观众类切面
 */
@Aspect
@Component
public class Audience {

    @Pointcut("execution(* com.learn.spring.Chap4.Performance.perform(..))")
    public void performance(){

    }

    @Before("performance()")
    public void silenceCellPhones() {
        infoLog("Slienceing cell phones ...");
    }

    @Before("performance()")
    public void takeSeats() {
        infoLog("Taking seats ...");
    }

    @AfterReturning("performance()")
    public void applause() {
        infoLog("applause after perform");
    }

    @AfterThrowing("performance()")
    public void domainRefund() {
        infoLog("Domaining a refund");
    }

    @Around("performance()")
    public void aroundAspect(ProceedingJoinPoint proceedingJoinPoint){
        try {
            infoLog("proceed before");
            proceedingJoinPoint.proceed();
            infoLog("proceed after !");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
