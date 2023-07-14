package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/14
 */
public class NumSquares {
    public static void main(String[] args) {
        //输入：n = 12
        //输出：3
        //解释：12 = 4 + 4 + 4

        System.out.println(numSquares(13));
    }

    public static int numSquares(int n) {

        int[] dp = new int[n+1];

        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n/2; i++) {
            for (int j = i*i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i*i] + 1);
            }
        }

        return dp[n];
    }
}
