package com.liao.test.aop;

/**
 * @author liaoguixin
 * @date 2023/9/30
 */
public class HelloServiceImpl implements HelloService {
    public void sayHello() {
        System.out.println("Hello from the actual implementation!");
    }
}
