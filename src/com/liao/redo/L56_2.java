package com.liao.redo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/10/7
 */
public class L56_2 {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        System.out.println(merge(intervals));
    }

    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < len; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                list.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[] {start, end});
        int size = list.size();
        int[][] res = new int[size][2];
        int idx = 0;
        for (int[] items : list) {
            res[idx++] = items;
        }

        return res;
    }
}
