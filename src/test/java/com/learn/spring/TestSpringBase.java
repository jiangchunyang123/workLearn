package com.learn.spring;

import com.learn.spring.Chap4.AppConfig;
import com.learn.spring.Chap4.Performance;
import com.learn.spring.Chap4.cd.CDPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class,AppConfig.class})
public class TestSpringBase {

    @Autowired
    private Performance performance;

    @Autowired
    CDPlayer cdPlayer;

    @Test
    public void test(){
//        performance.perform();
        cdPlayer.play();
    }
}
