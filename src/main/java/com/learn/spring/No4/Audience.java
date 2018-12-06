package com.learn.spring.No4;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 观众类切面
 */
@Aspect
public class Audience {

    @Before("execution(** com.learn.spring.No4.Performance.perform(..))")
    public void silenceCellPhones(){
        System.out.println("Slienceing cell phones ...");
    }
    @Before("execution(** com.learn.spring.No4.Performance.perform(..))")
    public void takeSeats(){
        System.out.println("Taking seats ...");
    }
    @AfterReturning("execution(** com.learn.spring.No4.Performance.perform(..))")
    public void applause(){
        System.out.println("applause after perform");
    }
    @AfterThrowing("execution(** com.learn.spring.No4.Performance.perform(..))")
    public void domainRefund(){
        System.out.println("Domaining a refund");
    }
}
