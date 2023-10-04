package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/10/4
 */
public class L312_3 {
    public static void main(String[] args) {

    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] val = new int[n+2];
        val[0] = 1;
        val[n+1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i-1];
        }

        int[][] dp = new int[n+2][n+2];

        for (int i = n-1; i >= 0; i--) {
            for (int j = i + 2; j <= n+1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int num = val[i] * val[k] * val[j];
                    num += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], num);
                }
            }
        }

        return dp[0][n+1];
    }
}
