package com.liao.paperTest.mihayou0813;

import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/8/16
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        List<LinkedList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < n-1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            // 在彼此添加子节点的连接情况
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);

        int[] dis = new int[n+1];
        Arrays.fill(dis, -1);
        boolean[] leaf = new boolean[n+1];
        Arrays.fill(leaf, true);

        dis[1] = 0;

        while (deque.size() != 0) {
            Integer x = deque.pollFirst();
            for (Integer y : graph.get(x)) {
                if (dis[y] == -1) {
                    leaf[x] = false;
                    dis[y] = dis[x] + 1;
                    deque.addLast(y);
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (dis[i] > k) {
                continue;
            }

            res += 1;
            if (leaf[i]) {
                res += k - dis[i];
            }
        }

        System.out.println(res);
    }
}
