package com.liao.mode;

/**
 * @author liaoguixin
 * @date 2023/6/27
 * @apiNote
 */
public class Singleton3 {
    private static Singleton3 uniqueInstance = new Singleton3();

    private Singleton3() {

    }

    public static Singleton3 getUniqueInstance() {
        return uniqueInstance;
    }
}
