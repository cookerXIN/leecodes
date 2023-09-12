package com.liao.paperTest.huawei.h0906;

import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/9/8
 */
public class Test3 {
    public static void main(String[] args) {
        int n = 5;
        int[][] nums = {
                {1, -1, -1},
                {2, -1, 2},
                {3, 1, 3},
                {4, 4, -1},
                {5, 4, 5}
        };


        List<Integer> res = new ArrayList<Integer>();
        // 关系图
        LinkedList<Integer>[] graph = new LinkedList[n+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<Integer>();
        }
        // 度矩阵
        int[] inDegree = new int[n+1];

        int first = -1;
        int last = -1;
        // 前后关系
        Map<Integer, Integer> sortMethod = new HashMap<Integer, Integer>();
        int idx = 0;

        // 根据关系建立关系图和度矩阵
        for (int[] num : nums) {
            int i = num[0];
            int j = num[1];
            int k = num[2];
            sortMethod.put(i, idx++);
            if (j != -1 && k != -1) {
                graph[j].add(k);
                inDegree[k]++;
            } else if (k == -1 && i == j) {
                first = i;
            } else if (j == -1 && i == k) {
                last = i;
            }
        }

        // 构建队列
        Queue<Integer> queue = new LinkedList<Integer>();

        // 将度为0的添加到队列中
        for (int i = 1; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt += size;
            List<Integer> tmp = new ArrayList<Integer>();
            while (size != 0) {
                Integer poll = queue.poll();
                size--;

                if (poll != first && poll != last) {
                    tmp.add(poll);
                }
                // 更新度矩阵
                LinkedList<Integer> items = graph[poll];
                for (Integer item : items) {
                    inDegree[item]--;
                    // 添加当前度为0的节点进队列中
                    if (inDegree[item] == 0) {
                        queue.add(item);
                    }
                }
            }
            // 根据前后关系 改变排序
            tmp.sort((a,b) -> sortMethod.get(a) - sortMethod.get(b));
            res.addAll(tmp);
        }

        // 判断是否所有节点都排完啦， 如果存在某些节点没排，则无法构成前后关系的排列顺序
        if (cnt != idx) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        if (first != -1) {
            sb.append(first).append(" ");

        }
        for (Integer re : res) {
            sb.append(re).append(" ");
        }
        if (last != -1) {
            sb.append(last);
        } else {
            sb.deleteCharAt(sb.length() - 1);
        }

        System.out.println(sb.toString());
    }
}
