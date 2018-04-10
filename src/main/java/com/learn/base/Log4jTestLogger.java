package com.learn.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jTestLogger {
    static Logger logger = LoggerFactory.getLogger(Log4jTestLogger.class);

    public static void errorLog(String log) {
        logger.error(log);
    }

    public static void warnLog(String log) {
        logger.warn(log);
    }

    public static void infoLog(String log) {
        logger.info(log);
    }

    public static void debugLog(String log) {
        logger.debug(log);
    }
}
