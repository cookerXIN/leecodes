package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/8/17
 */
public class L70 {
    public static void main(String[] args) {

    }

    public static int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n-1];
    }
}
