package com.liao.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liaoguixin
 * @date 2023/7/21
 */
public class B2 {
    public static void main(String[] args) {
        /**
         * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
         * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（
         * 不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
         * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
         * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
         *
         * 输入：m = 2, n = 3, k = 1
         * 输出：3
         */

        System.out.println(movingCount(2,3,1));
    }

    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0,0,0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0];
            int j = poll[1];
            int si = poll[2];
            int sj = poll[3];

            if (i >= m || j >= n || si + sj > k || visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            res++;

            queue.add(new int[] {i+1, j, sum(i+1), sum(j)});
            queue.add(new int[] {i, j+1, sum(i), sum(j+1)});
        }

        return res;
    }

    public static int sum(int i) {
        int res = 0;
        while (i > 0) {
            res += i % 10;
            i /= 10;
        }

        return res;
    }
}
