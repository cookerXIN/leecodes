package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/12
 */
public class A1 {
    public static void main(String[] args) {
        //输入：cost = [1,100,1,1,1,100,1,1,100,1]
        //输出：6
        //解释：你将从下标为 0 的台阶开始。
        //- 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
        //- 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
        //- 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
        //- 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
        //- 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
        //- 支付 1 ，向上爬一个台阶，到达楼梯顶部。
        //总花费为 6 。

        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {

        int[]  dp = new int[cost.length];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
