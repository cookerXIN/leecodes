package com.liao.avarice;

import java.util.Arrays;

/**
 * @author liaoguixin
 * @data 2023/7/10
 */
public class J10 {
    public static void main(String[] args) {
        //输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
        //输出: 1
        //解释: 移除 [1,3] 后，剩下的区间没有重叠

        int[][] intervals = {
                {1,2},
                {2,3},
                {3,4},
                {1,3}
        };

        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[i-1][1]) {
                count++;
            } else {
                intervals[i][1] = Math.min(intervals[i-1][1], intervals[i][1]);
            }
        }


        return intervals.length - count;
    }
}
