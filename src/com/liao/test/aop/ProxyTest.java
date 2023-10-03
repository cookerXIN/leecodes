package com.liao.test.aop;

import java.lang.reflect.Proxy;

/**
 * @author liaoguixin
 * @date 2023/9/30
 */
public class ProxyTest {
    public static void main(String[] args) {
        HelloService target = new HelloServiceImpl();
        HelloService proxy = (HelloService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new HelloServiceHandler(target)
        );
        proxy.sayHello();
    }
}
