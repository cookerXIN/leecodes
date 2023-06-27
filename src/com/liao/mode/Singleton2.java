package com.liao.mode;

/**
 * @author liaoguixin
 * @date 2023/6/27
 * @apiNote
 */
public class Singleton2 {
    private static Singleton2 uniqueInstance;

    private Singleton2() {

    }

    private static Singleton2 getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton2();
        }

        return uniqueInstance;
    }
}
