package com.learn.spring.Chap4.cd;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class TrackCounter {
    Logger logger = LoggerFactory.getLogger(TrackCounter.class);
    private Map<Integer, Integer> map = new HashMap<>();

    @Pointcut(value = "execution(* com.learn.spring.Chap4.cd.CompactDisc.playTrack(int)) && args(trackNumber)")
    public void playTrack(int trackNumber) {

    }

//    @Around("trackerPlay(trackNumber)")
//    public void around(ProceedingJoinPoint joinPoint) {
//        try {
//            logger.info("before ");
//            joinPoint.proceed();
//            logger.info("after");
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//    }

    @Before("playTrack(trackNumber)")
    public void before(int trackNumber ) {
        int currentCount = getPlayCount(trackNumber);
        map.put(trackNumber, currentCount + 1);
        logger.info("got a new trackerPlay:"+trackNumber);
    }

    private int getPlayCount(int trackNumber) {
        return map.get(trackNumber) == null ? 0 : map.get(trackNumber);
    }
}
