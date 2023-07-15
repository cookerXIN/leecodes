package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/15
 */
public class MaxProfitWithFee {
    public static void main(String[] args) {
        //输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
        //输出：8
        //解释：能够达到的最大利润:
        //在此处买入 prices[0] = 1
        //在此处卖出 prices[3] = 8
        //在此处买入 prices[4] = 4
        //在此处卖出 prices[5] = 9
        //总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
        int[] prices = {
                1, 3, 2, 8, 4, 9
        };
        System.out.println(maxProfit(prices, 2));
    }

    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i] - fee);
        }

        return dp[n-1][1];
    }
}
