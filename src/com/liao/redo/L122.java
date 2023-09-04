package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/9/1
 */
public class L122 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][0] + prices[i], dp[i-1][1]);
        }

        return dp[len-1][1];
    }
}
