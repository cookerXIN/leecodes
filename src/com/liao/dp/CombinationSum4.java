package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/14
 */
public class CombinationSum4 {
    public static void main(String[] args) {
        //输入：nums = [1,2,3], target = 4
        //输出：7
        //解释：
        //所有可能的组合为：
        //(1, 1, 1, 1)
        //(1, 1, 2)
        //(1, 2, 1)
        //(1, 3)
        //(2, 1, 1)
        //(2, 2)
        //(3, 1)
        //请注意，顺序不同的序列被视作不同的组合。

        int[] nums = {
                1,2,3
        };
        System.out.println(combinationSum4(nums, 4));
    }

    public static int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];

        dp[0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < n; i++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }

        return dp[target];
    }
}
