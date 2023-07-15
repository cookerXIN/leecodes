package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/15
 */
public class Rob2 {
    public static void main(String[] args) {
        //输入：nums = [1,2,3,1]
        //输出：4
        //解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
        //偷窃到的最高金额 = 1 + 3 = 4 。

        int[] nums = {
            2,3,2
        };
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int res1 = robWithIdx(nums, 0, n - 2);
        int res2 = robWithIdx(nums, 1, n - 1);

        return Math.max(res1, res2);
    }

    public static int robWithIdx(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int n = end - start + 1;
        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start],nums[start+1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[start+i]);
        }

        return dp[n-1];
    }


}
