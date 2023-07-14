package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/14
 */
public class Change {
    public static void main(String[] args) {
        //输入：amount = 5, coins = [1, 2, 5]
        //输出：4
        //解释：有四种方式可以凑成总金额：
        //5=5
        //5=2+2+1
        //5=2+1+1+1
        //5=1+1+1+1+1
        int[] coins = {
                1,2,5
        };
        System.out.println(change(5, coins));
    }

    public static int change(int amount, int[] coins) {

        int n = coins.length;

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                //有一张1元 组成5元的方法有dp【4】种
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }
}
