package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/16
 */
public class FindLengthOfLCIS {
    public static void main(String[] args) {
        //输入：nums = [1,3,5,4,7]
        //输出：3
        //解释：最长连续递增序列是 [1,3,5], 长度为3。
        //尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。

        int[] nums = {
                1,3,5,4,7
        };
        System.out.println(findLengthOfLCIS(nums));
    }

    public static int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = 1;
        int res = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] > nums[i-1] ? dp[i-1] + 1 : 1;
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
