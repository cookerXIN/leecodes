package com.liao.redo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/9/5
 */
public class L417 {
    public static void main(String[] args) {

    }

    static int[][] directs = {
            {1,0},
            {-1,0},
            {0,-1},
            {0,1}
    };
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][][] visited = new boolean[m][n][2];
        for (int i = 0; i < m; i++) {
            visited[i][0][0] = true;
            visited[i][n-1][1] = true;
            dfs(heights, i, 0, 0, visited);
            dfs(heights, i, n-1, 1, visited);
        }

        for (int i = 0; i < n; i++) {
            visited[0][i][0] = true;
            visited[m-1][i][1] = true;
            dfs(heights, 0, i, 0, visited);
            dfs(heights, m-1, i, 1, visited);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j][0] && visited[i][j][1]) {
                    List<Integer> item = new ArrayList<>();
                    item.add(i);
                    item.add(j);
                    res.add(item);
                }
            }
        }

        return res;
    }

    static void dfs(int[][] heights, int i, int j, int sign, boolean[][][] visited) {
        for (int[] direct : directs) {
            int newI = i + direct[0];
            int newJ = j + direct[1];

            if (newI < 0 || newJ < 0 || newI >= heights.length || newJ >= heights[0].length) {
                continue;
            }
            if (heights[newI][newJ] < heights[i][j] || visited[newI][newJ][sign]) {
                continue;
            }
            visited[newI][newJ][sign] = true;
            dfs(heights, newI, newJ, sign, visited);
        }
    }


}
