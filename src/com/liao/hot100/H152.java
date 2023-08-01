package com.liao.hot100;

/**
 * @author liaoguixin
 * @date 2023/8/1
 */
public class H152 {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int n = nums.length;
        // 0：当前的乘积最大值
        // 1：当前的乘积最小值
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int res = nums[0];

        // 当当前nums【i】为负数时，希望前一个的值负的更小更好 dp[i-1][1]*nums[i]
        // 当当前nums【i】为正数时，希望前一个的值正的更大更好
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(Math.max(dp[i-1][0]*nums[i], nums[i]), dp[i-1][1]*nums[i]);
            dp[i][1] = Math.min(Math.min(dp[i-1][1]*nums[i], nums[i]), dp[i-1][0]*nums[i]);
            res = Math.max(res, dp[i][0]);
        }

        return res;
    }
}
