package com.liao.redo;

import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/9/13
 */
public class L399 {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        Collections.addAll(l1,"a","b");
        List<String> l2 = new ArrayList<>();
        Collections.addAll(l2,"b","c");

        List<List<String>> list = new ArrayList<>();
        Collections.addAll(list, l1,l2);

        double[] values = {2.0,3.0};
        List<String> q1 = new ArrayList<>();
        Collections.addAll(q1,"a","c");
        List<String> q2 = new ArrayList<>();
        Collections.addAll(q2,"b","a");
        List<String> q3 = new ArrayList<>();
        Collections.addAll(q3,"a","e");
        List<String> q4 = new ArrayList<>();
        Collections.addAll(q4,"a","a");
        List<String> q5 = new ArrayList<>();
        Collections.addAll(q5,"x","x");

        List<List<String>> qLists = new ArrayList<>();
        Collections.addAll(qLists, q1,q2,q3,q4,q5);

        System.out.println(Arrays.toString(calcEquation(list, values, qLists)));

    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();
        UnionFind union = new UnionFind(2*size);
        Map<String, Integer> hashMap = new HashMap<>(2*size);

        int id = 0;
        for (int i = 0; i < size; i++) {
            List<String> equ = equations.get(i);
            String var1 = equ.get(0);
            String var2 = equ.get(1);

            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }
            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }
            union.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        int qSize = queries.size();
        double[] res = new double[qSize];
        for (int i = 0; i < qSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);

            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = union.isConnected(id1, id2);
            }
        }

        return res;
    }

    static class UnionFind {
        int[] parents;

        double[] weight;

        public UnionFind(int n) {
            this.parents = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parents[rootX] = rootY;
            weight[rootX] = weight[y] * value / weight[x];
        }

        public int find(int x) {
            if (x != parents[x]) {
                int origin = parents[x];
                parents[x] = find(parents[x]);
                weight[x] *= weight[origin];
            }
            return parents[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }
}
