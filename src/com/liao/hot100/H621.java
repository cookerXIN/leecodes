package com.liao.hot100;

import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/8/9
 */
public class H621 {
    public static void main(String[] args) {
        char[] tasks = {'a', 'a', 'a', 'b', 'b'};
        leastInterval(tasks, 2);
    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int size = map.size();
        List<Integer> nextValid = new ArrayList<>();
        List<Integer> rest = new ArrayList<>();
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            Integer value = entry.getValue();
            nextValid.add(1);
            rest.add(value);
        }

        int time = 0;

        for (int i = 0; i < tasks.length; i++) {
            time++;
            int minNextValid = Integer.MAX_VALUE;
            for (int j = 0; j < size; j++) {
                if (rest.get(j) != 0) {
                    minNextValid = Math.min(minNextValid, nextValid.get(j));
                }
            }
            time = Math.max(time, minNextValid);
            int best = -1;
            for (int j = 0; j < size; j++) {
                if (rest.get(j) != 0 && nextValid.get(j) <= time) {
                    if (best == -1 || rest.get(j) > rest.get(best)) {
                        best = j;
                    }
                }
            }
            nextValid.set(best, time+n+1);
            rest.set(best, rest.get(best)-1);
        }

        return time;
    }

    public static int leastInterval1(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int maxExec = 0;
        for (char task : tasks) {
            int val = map.getOrDefault(task, 0) + 1;
            maxExec = Math.max(maxExec, val);
            map.put(task, val);
        }

        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            Integer value = entry.getValue();
            if (value == maxExec) {
                maxCount++;
            }
        }

        return Math.max((maxExec - 1) * (n+1) + maxCount, tasks.length);
    }

}
