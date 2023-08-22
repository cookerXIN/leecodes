package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/8/22
 */
public class L1749 {
    public static void main(String[] args) {
        int[] nums = {2,-5,1,-4,3,-2};
        System.out.println(maxAbsoluteSum(nums));
    }

    public static int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return Math.abs(nums[0]);
        }

        int max = nums[0];
        int min = nums[0];

        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0]+nums[i], nums[i]);
            dp[i][1] = Math.min(dp[i-1][1]+nums[i], nums[i]);
            min = Math.min(min,dp[i][1]);
            max = Math.max(max,dp[i][0]);
        }

        return Math.max(Math.abs(min), Math.abs(max));
    }
}
