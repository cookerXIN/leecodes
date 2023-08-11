package com.liao.hot100;

import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/8/10
 */
public class H399 {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> equation1 = new ArrayList<>();
        Collections.addAll(equation1, "a", "b");
        List<String> equation2 = new ArrayList<>();
        Collections.addAll(equation2, "b", "c");
        Collections.addAll(equations, equation1, equation2);

        double[] values = {2.0,3.0};

        List<List<String>> queries = new ArrayList<>();
        List<String> queries1 = new ArrayList<>();
        Collections.addAll(queries1, "a", "c");
        List<String> queries2 = new ArrayList<>();
        Collections.addAll(queries2, "b", "a");
        Collections.addAll(queries, queries1, queries2);


        System.out.println(Arrays.toString(calcEquation(equations, values, queries)));
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int index = 0;
        Map<String, Integer> vars = new HashMap<>();

        int size = equations.size();
        for (int i = 0; i < size; i++) {
            if (!vars.containsKey(equations.get(i).get(0))) {
                vars.put(equations.get(i).get(0), index++);
            }
            if (!vars.containsKey(equations.get(i).get(1))) {
                vars.put(equations.get(i).get(1), index++);
            }
        }

        List<Pair>[] edges = new List[index];
        for (int i = 0; i < index; i++) {
            edges[i] = new ArrayList<Pair>();
        }
        for (int i = 0; i < size; i++) {
            int va = vars.get(equations.get(i).get(0)), vb = vars.get(equations.get(i).get(1));
            edges[va].add(new Pair(vb, values[i]));
            edges[vb].add(new Pair(va, 1.0 / values[i]));
        }

        int queriesCount = queries.size();
        double[] res = new double[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            List<String> list = queries.get(i);
            double result = -1.0;

            if (vars.containsKey(list.get(0)) && vars.containsKey(list.get(1))) {
                int ia = vars.get(list.get(0)), ib = vars.get(list.get(1));

                if (ia == ib) {
                    result = 1.0;
                } else {
                    Queue<Integer> points = new LinkedList<>();
                    points.offer(ia);
                    double[] ratios = new double[index];
                    Arrays.fill(ratios, -1.0);
                    ratios[ia] = 1.0;

                    while (!points.isEmpty() && ratios[ib] < 0) {
                        int x = points.poll();
                        for (Pair pair : edges[x]) {
                            int y = pair.index;
                            double val = pair.value;
                            if (ratios[y] < 0) {
                                ratios[y] = ratios[x] * val;
                                points.offer(y);
                            }
                        }
                    }
                    result = ratios[ib];
                }
            }
            res[i] = result;
        }


        return res;
    }

    static class Pair {
        int index;
        double value;

        Pair(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }
}
