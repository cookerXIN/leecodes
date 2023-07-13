package com.liao.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author liaoguixin
 * @data 2023/7/13
 */
public class canPartition {
    public static void main(String[] args) {
        //输入：nums = [1,5,11,5]
        //输出：true
        //解释：数组可以分割成 [1, 5, 5] 和 [11] 。

        int[] nums = {
                1,5,11,5
        };

        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        //int sum = Arrays.stream(nums).sum();

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;

        int[] dp = new int[target + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[target] == target;
    }
}
