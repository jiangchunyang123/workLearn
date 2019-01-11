package com.learn.spring.Chap4;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EncoreableIntroducer {

    @DeclareParents(value="com.learn.spring.Chap4.Performance+",defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
