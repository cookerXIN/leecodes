package com.liao.hot100;

/**
 * @author liaoguixin
 * @date 2023/8/3
 */
public class H221 {
    public static void main(String[] args) {

    }

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int res = 0;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 1) {
                dp[i][0] = 1;
            }
            res = Math.max(dp[i][0], res);
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 1) {
                dp[0][i] = 1;
            }
            res = Math.max(dp[0][i], res);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                }

                res = Math.max(dp[i][j], res);
            }
        }

        return res;
    }
}
