package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/16
 */
public class MaxSubArray {
    public static void main(String[] args) {
        //输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
        //输出：6
        //解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

        int[] nums = {
                -2,1,-3,4,-1,2,1,-5,4
        };
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        int res = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
