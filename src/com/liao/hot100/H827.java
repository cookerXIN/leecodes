package com.liao.hot100;

import com.liao.huisu.J9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liaoguixin
 * @date 2023/8/4
 */
public class H827 {
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,1}};
        System.out.println(largestIsland(grid));
    }

    public static int largestIsland(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(idx, grid, i, j);
                    map.put(idx, count);
                    idx++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = addAreas(grid, i, j);
                    if (set.size() != 0) {
                        int area = 1;
                        for (Integer a :set){
                            area += map.get(a);
                        }

                        res = Math.max(res, area);
                    }

                }
            }
        }

        return res;
    }

    public static int dfs(int idx, int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = idx;

        return 1 + dfs(idx, grid, i, j-1) +  dfs(idx, grid, i, j+1) +  dfs(idx, grid, i-1, j) +  dfs(idx, grid, i+1, j);
    }

    public static Set<Integer> addAreas(int[][] grid, int i, int j) {
        Set<Integer> set = new HashSet<Integer>();
        if (isLegal(grid, i+1, j) && grid[i+1][j] != 0) {
            set.add(grid[i+1][j]);
        }
        if (isLegal(grid, i-1, j) && grid[i-1][j] != 0) {
            set.add(grid[i-1][j]);
        }
        if (isLegal(grid, i, j+1) && grid[i][j+1] != 0) {
            set.add(grid[i][j+1]);
        }
        if (isLegal(grid, i, j-1) && grid[i][j-1] != 0) {
            set.add(grid[i][j-1]);
        }

        return set;
    }

    public static boolean isLegal(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false;
        }
        return true;
    }
}
