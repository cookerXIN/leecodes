package com.liao.paperTest.huawei.h0830;

import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/9/9
 */
public class Test3 {
/*
9
50 50 80 40 40 40 60 60 60
0 0 0 0 0 0 0 0 0
1 0 0 0 0 0 0 0 0
0 1 0 0 0 0 0 0 0
0 0 1 0 0 1 0 0 0
0 0 0 1 0 0 0 0 0
0 1 0 0 0 0 0 0 0
0 0 0 0 1 0 0 0 0
0 0 0 1 0 0 0 0 0
0 0 0 0 0 0 1 1 0
 */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] memory = new int[n];
        for (int i = 0; i < n; i++) {
            memory[i] = input.nextInt();
        }

        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = input.nextInt();
            }
        }

        int[] inDegree = new int[n];
        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i][j] == 1) {
                    graph[j].add(i);
                    inDegree[i]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int need = 0;
            while (size > 0) {
                Integer poll = queue.poll();
                size--;
                need += memory[poll];

                LinkedList<Integer> items = graph[poll];
                for (Integer item : items) {
                    inDegree[item]--;
                    if (inDegree[item] == 0) {
                        queue.add(item);
                    }
                }
            }

            res = Math.max(res, need);
        }

        System.out.println(res);
    }
}
