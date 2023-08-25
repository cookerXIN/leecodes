package com.liao.paperTest.huawei0823;

import java.util.*;
/**
 * @author liaoguixin
 * @date 2023/8/25
 */
public class Test3 {
    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in);

        //int n = input.nextInt();
        //int m = input.nextInt();
        //int x = input.nextInt();
        //int y = input.nextInt();
        //
        //int[][] groups = new int[m][n];
        //for (int i = 0; i < m; i++) {
        //    for (int j = 0; j < n; j++) {
        //        groups[i][j] = input.nextInt();
        //    }
        //}

        int n = 3, m = 3, x = 1, y = 0;
        int[][] group = {
                 {0,1,2},
                 {1,2,1},
                 {0,1,2},
        };
        boolean[][] visited = new boolean[m][n];
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[x][y] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b)->a[0]-b[0]);
        queue.add(new int[] {0,x,y});

        while (!queue.isEmpty()) {
            int[] ints = queue.poll();
            int extra = ints[0];
            int i = ints[1];
            int j = ints[2];

            if (visited[i][j]) {
                continue;
            }
            visited[i][j] = true;

            int[][] directs = {
                    {1,0},
                    {-1,0},
                    {0,1},
                    {0,-1}
            };
            for (int[] direct : directs) {
                int newI = i + direct[0];
                int newJ = j + direct[1];

                if (newI < 0 || newJ < 0 || newI >= m || newJ >= n || group[newI][newJ] == 0) {
                    continue;
                }

                if (dp[newI][newJ] > extra + group[i][j]) {
                    dp[newI][newJ] = extra + group[i][j];
                    queue.add(new int[] {dp[newI][newJ], newI, newJ});
                }

            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (group[i][j] != 0) {
                    if (dp[i][j] == Integer.MAX_VALUE) {
                        System.out.println(-1);
                        return;
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        System.out.println(res);
    }
}
