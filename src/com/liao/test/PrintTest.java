package com.liao.test;

public class PrintTest {
    public static void main(String[] args) {
        System.out.println(Math.round(-11.2));
    }
    PrintTest() {
        PrintTest p1 = this;
        PrintTest p2 = this;
        synchronized (p1) {
            try {
                p2.wait();
                System.out.println("waiting");
            } catch (InterruptedException e) {
                System.out.println("interrupted exception");
            } catch (Exception e) {
                System.out.println("other exception");
            } finally {
                System.out.println("finally");
            }
        }
        System.out.println("finish");
    }
}
