package com.liao.avarice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liaoguixin
 * @data 2023/7/11
 */
public class L12 {
    public static void main(String[] args) {
        //输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        //输出：[[1,6],[8,10],[15,18]]
        //解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

        int[][] intervals = {
            {1,3},
            {2,6},
            {8,10},
            {15,18},
        };

        System.out.println(merge(intervals));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            return a[0] - b[0];
        });

        List<Integer[]> list = new ArrayList< Integer[]>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                list.add(new Integer[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        list.add(new Integer[] {start, end});

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 2; j++) {
                res[i][j] = list.get(i)[j];
            }
        }


        return res;
    };
}
