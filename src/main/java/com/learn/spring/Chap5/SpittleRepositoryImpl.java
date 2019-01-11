package com.learn.spring.Chap5;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpittleRepositoryImpl implements SpittleRepository{
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }
}
