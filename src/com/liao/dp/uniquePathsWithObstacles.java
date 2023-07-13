package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/12
 */
public class uniquePathsWithObstacles {
    public static void main(String[] args) {
        //输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
        //输出：2
        //解释：3x3 网格的正中间有一个障碍物。
        //从左上角到右下角一共有 2 条不同的路径：
        //1. 向右 -> 向右 -> 向下 -> 向下
        //2. 向下 -> 向下 -> 向右 -> 向右

        int[][] obstacleGrid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
