package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/9/4
 */
public class L200_1 {
    public static void main(String[] args) {

    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
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
        int[][] directs = {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };

        for (int[] direct : directs) {
            int newI = i + direct[0];
            int newJ = j + direct[1];
            if (newI < 0 || newJ < 0 || newI >= grid.length || newJ >= grid[0].length) {
                continue;
            }
            dfs(grid, newI, newJ);
        }
    }
}
