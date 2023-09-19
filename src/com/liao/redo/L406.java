package com.liao.redo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author liaoguixin
 * @date 2023/9/15
 */
public class L406 {
    public static void main(String[] args) {
        int[][] people = {
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        };
        System.out.println(Arrays.stream(reconstructQueue(people)).toString());
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,
                (a,b) -> {
                    if (a[0] == b[0]) {
                        return a[1] - b[1];
                    }
                    return b[0] - a[0];
                });


        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[people.length][]);
    }
}
