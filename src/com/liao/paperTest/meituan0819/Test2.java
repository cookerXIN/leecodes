package com.liao.paperTest.meituan0819;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/20
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }

        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + nums[i];
            dp[i][1] = Math.max((dp[i-1][0] - nums[i-1]) + nums[i] * nums[i-1], dp[i-1][1] + nums[i]);
        }

        System.out.println(dp[n-1][1]);
    }
}
