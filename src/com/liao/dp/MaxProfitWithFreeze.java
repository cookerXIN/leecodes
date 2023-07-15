package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/15
 */
public class MaxProfitWithFreeze {
    public static void main(String[] args) {
        //输入: prices = [1,2,3,0,2]
        //输出: 3
        //解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
        int[] prices = {
                1,2,3,0,2
        };
        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];

        dp[0][0] = -prices[0];
        dp[0][1] = dp[0][2] = dp[0][3] = 0;

        for (int i = 1; i < n; i++) {
           dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][3], dp[i-1][2]) - prices[i]);
           dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
           dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]);
           dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2]);
        }

        return Math.max(dp[n-1][1], Math.max(dp[n-1][2], dp[n-1][3]));
    }
}
