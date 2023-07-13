package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/13
 */
public class FindTargetSumWays {
    public static void main(String[] args) {
        //输入：nums = [1,1,1,1,1], target = 3
        //输出：5
        //解释：一共有 5 种方法让最终目标和为 3 。
        //-1 + 1 + 1 + 1 + 1 = 3
        //+1 - 1 + 1 + 1 + 1 = 3
        //+1 + 1 - 1 + 1 + 1 = 3
        //+1 + 1 + 1 - 1 + 1 = 3
        //+1 + 1 + 1 + 1 - 1 = 3

        /*
            正的数 + 负的数 = 全部数的和
            正的数 - 负的数 = 目标和
            2 * 正的数 - 目标和 = 全部数的和
            因此所求目标只要是正的数多少，凑到正的数要几个
         */

        int[] nums = {
                1,1,1,1,1
        };
        System.out.println(findTargetSumWays(nums, 3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (target > sum || sum < -target) {
            return 0;
        }

        int positive = (sum + target);
        if (positive % 2 == 1) {
            return 0;
        }

        positive /= 2;
        int[] dp = new int[positive + 1];

        //有几种方法
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = positive; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[positive];
    }
}
