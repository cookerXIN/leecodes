package com.liao.paperTest.elema0817;

import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/8/17
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int p = in.nextInt();

        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            int src = in.nextInt();
            int des = in.nextInt();
            int d = in.nextInt();
            graph.get(src).add(new int[] {des, d});
            graph.get(des).add(new int[] {src, d});
        }

        int[] schools = new int[p];
        for (int i = 0; i < p; i++) {
            schools[i] = in.nextInt();
        }

        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        boolean[] vst = new boolean[n+1];
        dis[1] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> a[0] - b[0]);
        queue.add(new int[] {0, 1});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int d = arr[0];
            int cur = arr[1];

            if (vst[cur]) {
                continue;
            }
            vst[cur] = true;

            for (int[] ints : graph.get(cur)) {
                int next = ints[0];
                int nextDis = ints[1];

                if (dis[next] > d + nextDis) {
                    dis[next] = d + nextDis;
                    queue.add(new int[] {dis[next], next});
                }
            }
        }

        int res = 0;
        for (int i = 1; i < dis.length; i++) {
            res += dis[i] * 2;
        }

        System.out.println(res);

    }
}
