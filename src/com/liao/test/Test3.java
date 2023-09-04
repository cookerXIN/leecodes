package com.liao.test;

import java.util.LinkedHashMap;

/**
 * @author liaoguixin
 * @date 2023/8/29
 */
public class Test3 {
    public static void main(String[] args) {
        System.out.println(doubleNum(1000));
    }

    static int doubleNum(long n) {
        int len = String.valueOf(n).length();
        //LinkedHashMap
        int res = 0;
        int res1 = 0;
        for (int i = 1; i <= len/2; i++) {
            res += Math.pow(10, i) - Math.pow(10,i-1);
        }
        for (int i = len/2 + 1; i <= len; i++) {
            res1 += Math.pow(10, i - len/2) - Math.pow(10,i - len/2 - 1);
        }
        if (res < res1) {
            res += 1;
        }
        return res;
    }
}
