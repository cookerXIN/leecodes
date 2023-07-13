package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/12
 */
public class integerBreak {
    public static void main(String[] args) {
        //输入: n = 10
        //输出: 36
        //解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。

        System.out.println(integerBreak(10));
    }

    public static int integerBreak(int n) {

        int[] dp = new int[n + 1];

        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[j] * (i-j), j * (i-j)));
            }
        }

        return dp[n];
    }
}
