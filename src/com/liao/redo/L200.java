package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/8/18
 */
public class L200 {
    public static void main(String[] args) {

    }

    public static int numIslands(char[][] grid) {
        int count = 0;

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    static void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '2';

        int[][] direct = {
                {0,1},
                {0,-1},
                {-1,0},
                {1,0},
        };

        for (int[] ints : direct) {
            int newI = i + ints[0];
            int newJ = j + ints[1];

            if (newI >= 0 && newJ >= 0 && newI < grid.length && newJ < grid[0].length) {
                dfs(grid, newI, newJ);
            }
        }
    }
}
