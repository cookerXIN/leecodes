package com.liao.hot100;

/**
 * @author liaoguixin
 * @date 2023/8/4
 */
public class H695 {
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,1,0}};
        System.out.println(maxAreaOfIsland(grid));
    }

    static int count;

    public static int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    dfs(grid, i, j);
                    res = Math.max(res, count);
                }
            }
        }

        return res;
    }
    public static void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }

        if (grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 2;
        count++;
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
    }
}
