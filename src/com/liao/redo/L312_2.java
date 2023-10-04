package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/10/3
 */
public class L312_2 {
    public static void main(String[] args) {

    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+2][n+2];
        int[] val = new int[n+2];
        val[0] = 1;
        val[n+1] = 1;
        for (int i = 1; i < n+1; i++) {
            val[i] = nums[i-1];
        }
        int sum = 0;
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+2; j <= n+1; j++) {
                for (int k = i+1; k < j; k++) {
                    sum = val[i] * val[k] * val[j];
                    sum += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }

        return dp[0][n+1];
    }
}
