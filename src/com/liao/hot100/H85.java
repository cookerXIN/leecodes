package com.liao.hot100;

/**
 * @author liaoguixin
 * @date 2023/8/5
 */
public class H85 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][][] dp = new int[m][n][2];
        dp[0][0][0] = matrix[0][0] == '1' ? 1 : 0;
        dp[0][0][1] = matrix[0][0] == '1' ? 1 : 0;

        int res = dp[0][0][0] * dp[0][0][1];

        // 0:上 1:左
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == '1') {
                if (matrix[i-1][0] != '1') {
                    dp[i][0][0] = 1;
                    dp[i][0][1] = 1;
                } else {
                    dp[i][0][0] = dp[i-1][0][0] + 1;
                    dp[i][0][1] = 1;
                }
                res = Math.max(res, dp[i][0][0] * dp[i][0][1]);
            }
        }

        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == '1') {
                if (matrix[0][i-1] != '1') {
                    dp[0][i][0] = 1;
                    dp[0][i][1] = 1;
                } else {
                    dp[0][i][0] = dp[0][i-1][0] + 1;
                    dp[0][i][1] = 1;
                }

                res = Math.max(res, dp[0][i][0] * dp[0][i][1]);
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (matrix[i][j-1] != '1') {
                        dp[i][j][1] = 1;
                    } else {
                        dp[i][j][1] = dp[i][j-1][1] + 1;
                    }

                    if (matrix[i-1][j] != '1') {
                        dp[i][j][0] = 1;
                    } else {
                        dp[i][j][0] = dp[i-1][j][0] + 1;
                    }

                    res = Math.max(res, dp[i][j][0] * dp[i][j][1]);
                }
            }
        }

        return res;
    }
}
