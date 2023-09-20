package com.liao.paperTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/9/19
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = "3,3,[[1,3,3],[1,2,1],[2,3,1]]";
        String[] split = s.split(",");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);


        //int n = input.nextInt();
        //int m = input.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < m; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            graph[a-1][b-1] = c;
            graph[b-1][a-1] = c;
        }

        List<Integer> arr = new ArrayList<>();
        boolean[] vis = new boolean[n];
        System.out.println(cal(0, n, graph, arr, vis));
    }

    static int cal(int start, int n, int[][] graph, List<Integer> arr, boolean[] vis ) {
        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            arr.add(start);
            vis[start] = true;
            int val = Integer.MAX_VALUE;
            for (int row : arr) {
                for (int j = 0; j < n; j++) {
                    if (!vis[j]) {
                        if (graph[row][j] < val && graph[row][j] > 0) {
                            start = j;
                            val = graph[row][j];
                        }
                    }
                }
            }
            ans += val;
        }
        return ans;
    }

    class Node implements Comparable<Node> {
        int x;
        int y;
        int val;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }
}
