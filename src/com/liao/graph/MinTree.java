package com.liao.graph;


import com.sun.javafx.geom.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author liaoguixin
 * @date 2023/10/6
 */
public class MinTree {
    public static void main(String[] args) {
        int[][] nums = {
                {0,2,3},
                {0,1,1},
                {1,2,1}
        };
        // 点的个数
        int n = 3;
        // 建立关系图
        int[][] graph = new int[n][n];
        for (int[] num : nums) {
            graph[num[0]][num[1]] = num[2];
            graph[num[1]][num[0]] = num[2];
        }
        // 已经添加过的点
        boolean[] visited = new boolean[n];
        // 添加的点集合
        List<Integer> have = new ArrayList<Integer>();
        int min = getMin(0, n, graph, have, visited);
        System.out.println(min);

        kruskal(n, 3, nums);
    }

    /**
     * prim方法 每次找到未走过点的最小权值边添加花费
     * @param start 当前点位置
     * @param n 点总数
     * @param graph 关联图
     * @param have 已经走过的点
     * @param visited 判断是否已经走过当前点
     * @return 最小生成树的花费
     */
    static int getMin(int start, int n, int[][] graph, List<Integer> have, boolean[] visited) {
        // 花费
        int cost = 0;
        // n个点 只用添加n-1条边
        for (int i = 0; i < n - 1; i++) {
            // 添加当前点
            have.add(start);
            visited[start] = true;
            // 当前边的权值
            int val = Integer.MAX_VALUE;
            // 遍历找最小的权值边
            for (Integer item : have) {
                for (int j = 0; j < graph.length; j++) {
                    // 不符合的点进行过滤
                    if (visited[j] || graph[item][j] > val || graph[item][j] == 0) {
                        continue;
                    }
                    // 更新当前点
                    start = j;
                    val = graph[item][j];
                }
            }
            // 添加花费
            cost += val;
        }

        return cost;
    }


    // TODO
    public static void kruskal(int n, int edgeNum, int[][] graph) {
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = i;
        }

        int index = 0;
        int[] ends = new int[edgeNum];
        EData[] rets = new EData[edgeNum];

        int cost = 0;
        for (int i = 0; i < graph.length; i++) {
            rets[index++] = new EData(graph[i][0], graph[i][1], graph[i][2]);
        }

        Arrays.sort(rets, (a,b)-> a.weight - b.weight);
        for (int i = 0; i < edgeNum; i++) {
            int p1 = getPos(rets[i].start, pos);
            int p2 = getPos(rets[i].end, pos);

            int e1 = getEnd(ends, p1);
            //获取p2这个顶点在已有最小生成树中的终点
            int e2 = getEnd(ends, p2);
            //是否构成回路
            if(e1 != e2) { //没有构成回路
                ends[e1] = e2; // 设置m 在"已有最小生成树"中的终点
                cost += rets[i].weight;
            }
        }

        System.out.println(cost);
    }

    static int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }

        return i;
    }

    static int getPos(int now, int[] pos) {
        for (int i = 0; i < pos.length; i++) {
            if (pos[i] == now) {
                return i;
            }
        }

        return -1;
    }

    static class EData {
        int start;
        int end;
        int weight;

        public EData(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
