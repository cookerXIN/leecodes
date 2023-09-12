package com.liao.paperTest.huawei.h0906;

import java.util.Scanner;
import java.util.SortedMap;

/**
 * @author liaoguixin
 * @date 2023/9/8
 */
public class Test2 {
    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in);
        //int m = input.nextInt();
        //int n = input.nextInt();
        //
        //int[][] graph = new int[m][n];
        //for (int i = 0; i < m; i++) {
        //    for (int j = 0; j < n; j++) {
        //        graph[i][j] = input.nextInt();
        //    }
        //}
        //

        int m = 2;
        int n = 2;
        int[][] graph = {
                {1,2},
                {4,3}
        };
        boolean[][] visited = new boolean[m][n];
        int res = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cur = dfs(i, j, 0, visited, graph, m, n);
                visited[i][j] = false;
                res = Math.max(res, cur);
            }
        }

        System.out.println(res);
    }

    static int[][] directs = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1},
    };
    static int dfs(int i, int j, int flag, boolean[][] visited, int[][] graph, int m, int n) {
        visited[i][j] = true;
        int res = 0;
        for (int[] direct : directs) {
            int newI = i + direct[0];
            int newJ = j + direct[1];

            if (newI < 0 || newJ < 0 || newI >= m || newJ >= n || visited[newI][newJ]) {
                continue;
            }

            if (graph[newI][newJ] == graph[i][j]) {
                continue;
            }

            if (flag == 0) {
                flag = graph[newI][newJ] > graph[i][j] ? 1 : -1;
                res = Math.max(res, dfs(newI, newJ, flag, visited, graph, m, n)+1);
                visited[newI][newJ] = false;
            } else if (flag == 1) {
                if (graph[newI][newJ] > graph[i][j]) {
                    continue;
                } else {
                    flag = -1;
                    res = Math.max(res, dfs(newI, newJ, flag, visited, graph, m, n)+1);
                    visited[newI][newJ] = false;
                }
            } else {
                if (graph[newI][newJ] < graph[i][j]) {
                    continue;
                } else {
                    flag = 1;
                    res = Math.max(res, dfs(newI, newJ, flag, visited, graph, m, n)+1);
                    visited[newI][newJ] = false;
                }
            }
        }
        return res;
    }
}
