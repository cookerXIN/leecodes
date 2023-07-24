package com.liao.test;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/7/24
 */
public class H8 {
    public static void main(String[] args) {
        problem3();
    }

    public static void problem1() {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        BigInteger AInt = new BigInteger(A);
        BigInteger BInt = new BigInteger(B);

        String s = BInt.subtract(AInt).toString();

        System.out.println(s + " " + B);
    }

    public static void problem2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];

        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arrB[i] = sc.nextInt();
        }
        // 翻转数组一样等于回文字符串
        // 数组【0，n】 如果判断其【i，j】是否是回文数组，如果是则【0，i-1】和【j+1，n】两个数组的元素相同的话，则将数组翻转实现一致的方案可以加一
        // 而判断回文数组，则如果【i+1，j-1】是回文的话，并且【i】【j】两个位置的数组值分别错位相等的话，则此时的【i，j】也是回文
        int p = -1, s = -1;
        for (int i = 0; i < n; i++) {
            if (arrA[i] == arrB[i]) {
                p = i;
            } else {
                break;
            }
        }

        for (int i = n-1; i >= 0; i--) {
            if (arrA[i] == arrB[i]) {
                s = i;
            } else {
              break;
            }
        }

        boolean[][] dp = new boolean[n][n];
        int res = 0;

        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {
                //一开始对位相等的话，则此位置为回文
                if (i == j) {
                    dp[i][j] = arrA[i] == arrB[j];
                } else if (i + 1 == j) {
                    // 如果区间长度为2 只考虑对称是否相等
                    dp[i][j] = (arrA[i] == arrB[j] && arrA[j] == arrB[i]);
                } else {
                    dp[i][j] = dp[i+1][j-1]   && arrA[i] == arrB[j] && arrA[j] == arrB[i];
                }

                if(dp[i][j] && (i == 0 || p >= i-1) && (j == n-1 || j+1 >= s)) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    public static void problem3() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        if (Math.pow(2, k) > n / 2) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i <= Math.pow(2, k)) {
            sb.append('a');
            i++;
        }
        while (i < n) {
            sb.append('b');
            i++;
        }

        System.out.println(sb.toString());
    }
}
