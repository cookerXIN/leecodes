package com.liao.mode;

/**
 * @author liaoguixin
 * @date 2023/6/27
 * @apiNote
 */
public class Singleton1  {

    /**
     为了防止指令重排，存在多线程环境下导致一个线程获得还未实例化的对象
     */
    private volatile static Singleton1 uniqueInstance;

    private Singleton1() {}

    public static Singleton1 getUniqueInstance() {
        // 先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            // 类对象加锁
            synchronized (Singleton1.class) {
                if (uniqueInstance == null) {
                    /*
                        1.为 uniqueInstance 分配内存空间
                        2.初始化 uniqueInstance
                        3.将 uniqueInstance 指向分配的内存地址
                     */
                    uniqueInstance = new Singleton1();
                }
            }
        }

        return uniqueInstance;
    }

}
