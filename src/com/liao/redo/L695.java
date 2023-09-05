package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/9/4
 */
public class L695 {
    public static void main(String[] args) {
        int[][] grid = {
           {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},{
            0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0
        },{
            0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0
        },{
            0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0
        },
        {
            0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0
        },
        {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0
        },
        {
            0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0
        },
        {
            0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0
        }
        };
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int cur = dfs(grid, i, j);
                    res = Math.max(res, cur);
                }
            }
        }

        return res;
    }

    static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = 2;

        int[][] directs = {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };
        int res = 1;
        for (int[] direct : directs) {
            int newI = i + direct[0];
            int newJ = j + direct[1];

            res += dfs(grid, newI, newJ);
        }

        return res;
    }
}
