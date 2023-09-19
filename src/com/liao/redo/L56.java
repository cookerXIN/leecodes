package com.liao.redo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/9/19
 */
public class L56 {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        merge(nums);
    }

    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        List<int[]> res = new ArrayList<int[]>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < len; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                res.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[] {start, end});
        return res.toArray(new int[res.size()][]);
    }
}
