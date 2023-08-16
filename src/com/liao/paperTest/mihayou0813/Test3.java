package com.liao.paperTest.mihayou0813;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/16
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double p = in.nextDouble();

        double res = 0.0;
        for (int i = 1; i <= 90; i++) {
            res += i * cal(i, p) / 2;
        }

        for (int i = 1; i <= 90; i++) {
            for (int j = 1; j <= 90; j++) {
                double p1 = cal(i, p) / 2;
                double p2 = cal(j, p);
                res += (i + j) * p1 * p2;
            }
        }

        System.out.println(res);
    }

    static double cal(int x, double p) {
        double pow = Math.pow(1 - p, x - 1);
        if (x < 90) {
            pow *= p;
        }

        return pow;
    }
}
