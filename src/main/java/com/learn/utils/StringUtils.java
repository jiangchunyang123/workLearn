package com.learn.utils;

public class StringUtils {
    public static boolean isEmpty(Object o ){
        return o==null||o.toString().equals("");
    }
}
