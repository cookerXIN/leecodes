package com.liao.redo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/9/4
 */
public class L797 {
    public static void main(String[] args) {
        int[][] graph = {
                {1,2},
                {3},
                {3},
                {}
        };
        System.out.println(allPathsSourceTarget(graph));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        List<Integer> item = new ArrayList<>();
        item.add(0);
        dfs(graph, visited, 0, item);
        return res;
    }

    static List<List<Integer>> res = new ArrayList<>();
    static void dfs(int[][] graph, boolean[] visited, int cur, List<Integer> item) {
        if (cur == graph.length - 1) {
            res.add(new ArrayList<>(item));
            return;
        }

        int[] dot = graph[cur];
        for (int d : dot) {
            if (visited[d]) {
                continue;
            }
            item.add(d);
            cur = d;
            visited[cur] = true;
            dfs(graph, visited, cur, item);
            visited[cur] = false;
            item.remove(item.size() - 1);
        }
    }
}
