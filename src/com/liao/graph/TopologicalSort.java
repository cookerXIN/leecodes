package com.liao.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liaoguixin
 * @date 2023/10/8
 */
public class TopologicalSort {
    public static void main(String[] args) {
        int n = 2;
        int[][] nums = {
                {1, 0},
                {0, 1},
        };

        System.out.println(topologicalSort(n, nums));
    }

    /**
     * 拓扑排序
     * @param n 点的总数
     * @param paths 依赖关系
     * @return 是否可以完成所有依赖的排序
     */
    public static boolean topologicalSort(int n, int[][] paths) {
        // 建立度矩阵和关系图
        int[] inDegree = new int[n];
        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] path : paths) {
            // 在当前点依赖的点集合中添加当前点
            graph[path[1]].add(path[0]);
            // 当前点的度+1
            inDegree[path[0]]++;
        }

        // 将度为0 即没有依赖的点添加进当前队列中
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 统计已排序的点
        int visited = 0;
        while (!queue.isEmpty()) {
            // 弹出当前点
            Integer cur = queue.poll();
            visited++;
            // 遍历当前点的集合 将其依赖点的度-1 如果度为0 则添加到队列里
            LinkedList<Integer> items = graph[cur];
            for (Integer item : items) {
                inDegree[item]--;
                if (inDegree[item] == 0) {
                    queue.offer(item);
                }
            }
        }

        // 判断是否所有点都添加过了
        return visited == n;
    }
}
