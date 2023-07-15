package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/15
 */
public class MaxProfit {
    public static void main(String[] args) {
        //输入：[7,1,5,3,6,4]
        //输出：5
        //解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
        //注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

        int[] prices = {
            7,1,5,3,6,4
        };

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {
            //只可买卖一次 所以每次持有股票都是当前股票价格
            dp[i][0] = Math.max(dp[i-1][0], - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }

        return dp[n-1][1];
    }
}
