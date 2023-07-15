package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/15
 */
public class MaxProfit3 {
    public static void main(String[] args) {
        //输入：prices = [3,3,5,0,0,3,1,4]
        //输出：6
        //解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
        //随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。

        int[] prices = {
                2,1,4,5,2,9,7
        };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = -prices[0];
        dp[0][3] = 0;

        for (int i = 1; i < n; i++) {
            //dp[i][0] 是第一次买股票的状态，其为当天是第一次买，或者前一天已经买好了股票
            dp[i][0] = Math.max(-prices[i], dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] + prices[i]);
        }

        return dp[n-1][3];
    }
}
