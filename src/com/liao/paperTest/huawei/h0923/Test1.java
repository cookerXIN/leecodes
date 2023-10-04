package com.liao.paperTest.huawei.h0923;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/10/4
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int res = 0;
        int i = 1;
        while (Math.round((double) n / i) != 1.0) {
            i += 1;
            res++;
        }

        System.out.println(res);
    }
}
