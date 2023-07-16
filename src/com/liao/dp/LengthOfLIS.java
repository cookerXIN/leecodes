package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/16
 */
public class LengthOfLIS {
    public static void main(String[] args) {
        //输入：nums = [10,9,2,5,3,7,101,18]
        //输出：4
        //解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

        int[] nums = {
                10,9,2,5,3,7,101,18
        };
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(dp[i], res);
        }

        return res;
    }
}
