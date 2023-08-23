package com.liao.mode;

/**
 * @author liaoguixin
 * @date 2023/8/23
 */
public class Test1 {

    private volatile static Test1 unique;

    private Test1() {}

    public static Test1 getInstance() {
        if (unique == null) {
            synchronized (Test1.class) {
                if (unique == null) {
                    unique = new Test1();
                }
            }
        }
        return unique;
    }

}
