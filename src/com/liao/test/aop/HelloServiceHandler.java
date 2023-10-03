package com.liao.test.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liaoguixin
 * @date 2023/9/30
 */
public class HelloServiceHandler implements InvocationHandler {
    private Object target;

    public HelloServiceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method call 11111111111");
        Object result = method.invoke(target, args);
        System.out.println("After method call");
        return result;
    }
}

