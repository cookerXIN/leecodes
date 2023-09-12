package com.liao.paperTest.zijie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/9/10
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt();
            List<Pair> a = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                a.add(new Pair(i, scanner.nextInt()));
            }

            int[] b = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                b[i] = scanner.nextInt();
            }

            Collections.sort(a);

            for (int i = 0; i < n - 1; i++) {
                System.out.print(getMedian(a) + " ");
                a.remove(getPairByIndex(a, b[i]));
            }
            System.out.println(getMedian(a)); // For the last remaining element
        }

        scanner.close();
    }

    private static Pair getPairByIndex(List<Pair> list, int index) {
        for (Pair pair : list) {
            if (pair.index == index) {
                return pair;
            }
        }
        return null;
    }

    private static String getMedian(List<Pair> list) {
        int size = list.size();
        if (size % 2 == 1) {
            return String.valueOf(list.get(size / 2).value);
        } else {
            double median = (list.get(size / 2 - 1).value + list.get(size / 2).value) / 2.0;
            return String.format("%.1f", median);
        }
    }

    static class Pair implements Comparable<Pair> {
        int index;
        int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.value, other.value);
        }
    }
}
