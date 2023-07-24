package com.liao.test;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/7/23
 */
public class F6 {
    public static void main(String[] args) {
        //3
        //5 10
        //5 -1 -5 -3 2
        //2 -3
        //-5 -2
        //6 10
        //4 -2 -11 -1 4 -1
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] res = new int[t];

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int x = sc.nextInt();

            int[] arr = new int[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = sc.nextInt();
            }

            /**
             * 两个状态 0：表示没有替换 1：表示替换
             * 0状态 当前的最大值为max（前一个最大值+当前值，当前值）
             * 1状态 分为前一个值已经替换的情况，前一个值没有替换现在替换的情况
             * 如果已经替换 当前的最大值为max（前一个已经替换的最大值+当前值，当前值）
             * 如果没有替换 当前的最大值为max（前一个没有替换最大值+替换值，替换值）
             * 则1状态是两种的情况的最大值
             */
            int[][] dp = new int[n][2];
            int max = arr[0];
            dp[0][0] = arr[0];
            dp[0][1] = Math.max(x, arr[0]);
            for (int j = 1; j < n; j++) {
                dp[j][0] = Math.max(dp[j-1][0] + arr[j], arr[j]);
                dp[j][1] = Math.max(Math.max(dp[j-1][1] + arr[j], arr[j]), Math.max(dp[j-1][0] + x, x));
                max = Math.max(max, Math.max(dp[j][0], dp[j][1]));
            }

            res[i] = max;
        }

        for (int i = 0; i < t; i++) {
            System.out.println(res[i]);
        }
    }
}
