package com.learn.base;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Log4jTestLogger.debugLog("testdebug..");
        Log4jTestLogger.errorLog("testerror...");
        Log4jTestLogger.infoLog("testinfo...");
        Log4jTestLogger.warnLog("testwarn...");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
    }
}
