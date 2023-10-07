package com.liao.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author liaoguixin
 * @date 2023/10/7
 */
public class Dijkstra {
    public static void main(String[] args) {
        int[][] paths = {
                {1,3,3},
                {3,2,1},
                {2,1,3},
                {0,1,4},
                {3,0,5},
        };
        int dis = 6;
        int a = 1;
        int b = 0;
        int[] charge = {2,10,4,1};
        System.out.println(getMin(paths, dis, a, b, charge));
    }

    /**
     * dijkstra
     * @param paths 各线路的耗费
     * @param distance 电动车的最大电量
     * @param src 起点
     * @param dis 目的地
     * @param change 每个地点的充电耗费
     * @return 最小耗时
     */
    static int getMin(int[][] paths, int distance, int src, int dis, int[] change) {
        int n = change.length;

        // 构建路程图 各点位的距离关系 graph[i]表示当前城市i,其到可以到的临近城市为各个列表集合,
        // 而每个列表第一位表示到另一个城市j,第二位表示到j的距离
        LinkedList<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] path : paths) {
            graph[path[0]].add(new int[] {path[1], path[2]});
            graph[path[1]].add(new int[] {path[0], path[2]});
        }

        // dp dp[i][j]=k 表示在i城市其剩余j电量的最短时间
        int[][] dp = new int[n][distance+1];
        for (int[] item : dp) {
            Arrays.fill(item, Integer.MAX_VALUE);
        }
        dp[src][0] = 0;

        // 采用优先队列 保证每次优先走已用时间最短的路径
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]);
        // 已用时间 当前所在位置 剩余电量
        queue.offer(new int[] {0, src, 0});

        while (!queue.isEmpty()) {
            int[] nums = queue.poll();
            int time = nums[0];
            int cur = nums[1];
            int power = nums[2];

            // 如果时间比之前的时间还长,肯定不是最短路径 因此直接排除
            if (time > dp[cur][power]) {
                continue;
            }

            // 走到终点 直接返回结果
            if (cur == dis) {
                return time;
            }

            // 如果电量没满 则考虑进行充电 每次只充一个进行遍历
            if (power < distance) {
                int after = time + change[cur];
                if (after < dp[cur][power+1]) {
                    dp[cur][power+1] = after;
                    queue.offer(new int[] {after, cur, power+1});
                }
            }

            // 遍历当前点位可以到达的所有临近点位的情况
            for (int[] items : graph[cur]) {
                // 邻近点位置及其距离
                int next = items[0];
                int cost = items[1];

                // 计算耗时及耗能 走到临近点的时间及剩余电量
                int t = time + cost;
                int p = power - cost;
                // 如果可以走到 并且其是最短路径 则更新结果 添加到队列进行遍历
                if (p >= 0 && t < dp[next][p]) {
                    dp[next][p] = t;
                    queue.offer(new int[] {t, next, p});
                }
            }
        }

        return -1;
    }
}
