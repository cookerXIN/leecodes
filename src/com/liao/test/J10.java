package com.liao.test;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/7/25
 */
public class J10 {
    public static void main(String[] args) {
        problem1();
    }

    public static void problem1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int[][] dp = new int[n+1][3];
        dp[n][0] = 1;

        int mod = (int) 1e9 + 7;
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                // 当前i位置 余数j的方案数 等于i+1位置 j+当前i正反面对3取余的方案数
                dp[i][j] = (dp[i+1][(j + arr[i][0]) % 3] % mod + dp[i+1][(j + arr[i][1]) % 3] % mod) % mod;
            }
        }

        System.out.println(dp[0][0]);

        
    }
}
