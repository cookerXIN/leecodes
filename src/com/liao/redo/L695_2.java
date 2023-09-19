package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/9/12
 */
public class L695_2 {
    public static void main(String[] args) {

    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int cur = dfs(grid, i, j);
                    res = Math.max(res, cur);
                }
            }
        }

        return res;
    }
    int[][] directs = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1},
    };
    int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = 2;
        int res = 1;

        for (int[] direct : directs) {
            int newI = i + direct[0];
            int newJ = j + direct[1];

            res += dfs(grid, newI, newJ);
        }

        return res;
    }
}
