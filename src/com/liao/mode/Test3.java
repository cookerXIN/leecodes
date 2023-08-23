package com.liao.mode;

/**
 * @author liaoguixin
 * @date 2023/8/23
 */
public class Test3 {
    private static Test3 unique = new Test3();

    private Test3() {

    }

    public static Test3 getInstance() {
        return unique;
    }
}
