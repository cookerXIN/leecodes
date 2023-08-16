package com.liao.paperTest.meituan0812;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/14
 */
public class Test5 {
    //小美拿到了一棵树，每个节点有一个权值。初始每个节点都是白色。
    //小美有若干次操作，每次操作可以选择两个相邻的节点，如果它们都是白色且权值的乘积是完全平方数，小美就可以把这两个节点同时染红。
    //小美想知道，自己最多可以染红多少个节点？
    //输入描述
    //第一行输入一个正整数n，代表节点的数量。
    //第二行输入n个正整数ai，代表每个节点的权值。接下来的n-1行，
    //每行输入两个正整数u，v，代表节点u和节点v有一条边连接。
    //输出描述
    //输出一个整数，表示最多可以染红的节点数量。

    // 输入例子：
    // 3
    // 3 3 12
    // 1 2
    // 2 3
    // 输出结果：
    // 2

    static List<List<Integer>> graph;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] value = new int[n+1];
        for (int i = 1; i <= n; i++) {
            value[i] = in.nextInt();
        }
        // 构建连接图
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            // 在彼此添加子节点的连接情况
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dp = new int[n+1][2];
        dfs(1, 0, value);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    static void dfs(int node, int pre, int[] value) {
        for (int next : graph.get(node)) {
            if (next != pre) {
                // 遍历到叶子节点开始计算
                dfs(next, node, value);
                // 添加当前子节点情况
                dp[node][0] += Math.max(dp[next][0], dp[next][1]);
            }
        }

        for (int next : graph.get(node)) {
            // 保证是子节点
            if (next != pre) {
                // 保证满足完全平方数条件
                if (isAns(value[next], value[node])) {
                    // 当前节点染色的最大值 = max（其本身，不染色时+2）
                    // 不染色要保证其子节点不染色 因为其不染色的方案数里可能包括子节点染色情况 因此先减去这个可能性 -Math.max(dp[next][0], dp[next][1])
                    // 则此时节点不染色情况不包含子节点不染色情况，因此加上子节点不染色情况，+dp[next][0]
                    // 再加上将其和子节点染色 +2
                    dp[node][1] = Math.max(dp[node][0] - Math.max(dp[next][0], dp[next][1])+2+dp[next][0], dp[node][1]);
                }
            }
        }
    }

    static boolean isAns(int a, int b) {
        if (a < 0 || b < 0) return false;
        long c = (long) a * b;
        int sq = (int) Math.sqrt(c);
        return (long) sq *sq == c;
    }
}


