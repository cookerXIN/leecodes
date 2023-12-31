package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/12
 */
public class uniquePaths {
    public static void main(String[] args) {
        //输入：m = 3, n = 2
        //输出：3
        //解释：
        //从左上角开始，总共有 3 条路径可以到达右下角。
        //1. 向右 -> 向下 -> 向下
        //2. 向下 -> 向下 -> 向右
        //3. 向下 -> 向右 -> 向下

        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
