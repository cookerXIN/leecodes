package com.liao.paperTest.huawei.h0913;
import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/9/18
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        LinkedList<Integer>[] graph = new LinkedList[m];
        for (int i = 0; i < m; i++) {
            graph[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        int count = 0;
        boolean[] visited = new boolean[m];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            if (visited[i]) {
                continue;
            }
            queue.add(i);
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                visited[poll] = true;

                LinkedList<Integer> list = graph[poll];
                for (Integer conn : list) {
                    if (visited[conn]) {
                        continue;
                    }
                    queue.add(conn);
                }
            }
            count++;
        }

        System.out.println(count);
    }
}
