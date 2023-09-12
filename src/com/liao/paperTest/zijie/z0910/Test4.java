package com.liao.paperTest.zijie.z0910;

import java.util.HashMap;
import java.util.Map;
import java.util.*;
/**
 * @author liaoguixin
 * @date 2023/9/10
 */
public class Test4 {


    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i] * b[j] == k * gcd(a[i], b[j])) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }
}

