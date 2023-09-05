package com.liao.redo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/9/4
 */
public class L1020 {
    public static void main(String[] args) {
        int[][] grid = {
                {0,1,1,0}, {0,0,1,0}, {0,0,1,0}, {0, 0, 0, 0}
        };
        System.out.println(numEnclaves(grid));
    }

    public static int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            if (grid[i][n-1] == 1) {
                dfs(grid, i, n-1);
            }
        }

        for (int j = 1; j < n; j++) {
            if (grid[0][j] == 1) {
                dfs(grid, 0, j);
            }
            if (grid[m-1][j] == 1) {
                dfs(grid, m-1, j);
            }
        }

        count = 0;

        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                dfs(grid,i,j);
            }
        }

        return count;
    }
    static int count = 0;
    static int[][] directs = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    static void dfs(int[][] grid, int i, int j) {
        if (grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 0;
        count++;

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
