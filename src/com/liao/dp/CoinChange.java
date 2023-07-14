package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/14
 */
public class CoinChange {

    public static void main(String[] args) {
        //输入：coins = [1, 2, 5], amount = 11
        //输出：3
        //解释：11 = 5 + 5 + 1
        int[] coins = {
                1
        };
        System.out.println(coinChange(coins, 0));
    }


    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int n = coins.length;
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                //如果dp[j - coins[i]]本来就凑不齐，就没有必要继续算下去
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
