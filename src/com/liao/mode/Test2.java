package com.liao.mode;

/**
 * @author liaoguixin
 * @date 2023/8/23
 */
public class Test2 {
    private static Test2 unique;

    private Test2() {

    }

    public static Test2 getInstance() {
        if (unique == null) {
            unique = new Test2();
        }

        return unique;
    }
}
