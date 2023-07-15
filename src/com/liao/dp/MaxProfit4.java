package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/15
 */
public class MaxProfit4 {
    public static void main(String[] args) {
        //输入：k = 2, prices = [3,2,6,5,0,3]
        //输出：7
        //解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
        //随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。

        int[] prices = {
                3,2,6,5,0,3
        };
        System.out.println(maxProfit(2, prices));
    }

    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2*k + 1];

        dp[0][0] = 0;
        for (int i = 1; i <= 2 * k; i += 2) {
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0];
            for (int j = 1; j <= 2 * k; j += 2) {
                dp[i][j] = Math.max(dp[i][j-1] - prices[i], dp[i-1][j]);
                dp[i][j+1] = Math.max(dp[i][j] + prices[i], dp[i-1][j+1]);
            }
        }

        return dp[n-1][2*k];

    }
}
