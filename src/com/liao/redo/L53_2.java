package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/10/5
 */
public class L53_2 {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;

        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = dp[0];

        for (int i = 1; i < len; i++) {
            if (dp[i-1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i-1] + nums[i];
            }
            res = Math.max(dp[i], res);
        }

        return res;
    }
}
