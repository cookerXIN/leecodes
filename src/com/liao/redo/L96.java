package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/9/25
 */
public class L96 {
    public static void main(String[] args) {

    }

    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];
    }
}
