package com.liao.redo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liaoguixin
 * @date 2023/9/9
 */
public class L207 {
    public static void main(String[] args) {
        int[][] nums = {{1,0},{1,2},{0,1}};
        System.out.println(canFinish(3, nums));
    }


    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] graph = new LinkedList[numCourses];
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        int len = prerequisites.length;
        for (int[] prerequisite : prerequisites) {
            int x = prerequisite[0];
            int y = prerequisite[1];
            if (graph[y].contains(x)) {
                continue;
            }
            graph[y].add(x);
            inDegree[x]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            Integer poll = queue.poll();
            LinkedList<Integer> edge = graph[poll];
            for (Integer point : edge) {
                inDegree[point]--;
                if (inDegree[point] == 0) {
                    queue.offer(point);
                }
            }
        }

        return visited == numCourses;
    }
}
