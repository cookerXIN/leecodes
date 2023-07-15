package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/15
 */
public class Rob {
    public static void main(String[] args) {
        //输入：[1,2,3,1]
        //输出：4
        //解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
        //偷窃到的最高金额 = 1 + 3 = 4 。

        int[] nums = {
            1,2,3,1
        };
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[n-1];
    }
}
