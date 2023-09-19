package com.liao.paperTest.qunaer;

/**
 * @author liaoguixin
 * @date 2023/9/15
 */
public class Test2 {
    public static void main(String[] args) {
        int[][] nums = {
                {1,2,1}, {1, 3, 4}, {5, 7, 8}
        };
        System.out.println(minCount(nums));
    }

    public static int minCount (int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = nums[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + nums[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + nums[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + nums[i][j];
            }
        }

        return dp[m-1][n-1];
    }
}
