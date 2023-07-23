package com.liao.test;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/7/23
 */
public class E5 {
    public static void main(String[] args) {
        problem2();
    }

    public static int problem1() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        // 统计偶数数量
        int num = 0;

        if (x % 2 == 0) {
            num++;
        }
        if (y % 2 == 0) {
            num++;
        }
        if (z % 2 == 0) {
            num++;
        }

        return Math.min((3-num), num);
    }


    public static void problem2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        int[] cnts = new int[1001];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
            cnts[b[i]]++;
        }

        int num = 0;
        for (int x = 2000; x > 0; x-=2) {
            int[] tmpCnts = Arrays.copyOf(cnts, cnts.length);
            int cur = 0;
            for (int i = 0; i < n; i++) {
                if (x - a[i] < 0 || x - a[i] > 1000) {
                    continue;
                }
                if (tmpCnts[x-a[i]] > 0) {
                    cur++;
                    tmpCnts[x-a[i]]--;
                }
            }
            num = Math.max(num, cur);
        }

        System.out.println(num);
    }


}
