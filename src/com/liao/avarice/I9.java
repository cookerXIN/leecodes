package com.liao.avarice;

import java.util.Arrays;

/**
 * @author liaoguixin
 * @data 2023/7/10
 */
public class I9 {
    public static void main(String[] args) {
        //输入：points = [[10,16],[2,8],[1,6],[7,12]]
        //输出：2
        //解释：气球可以用2支箭来爆破:
        //-在x = 6处射出箭，击破气球[2,8]和[1,6]。
        //-在x = 11处发射箭，击破气球[10,16]和[7,12]。

        int[][] points = {
         {10,16},
         {2,8},
         {1,6},
         {7,12},
        };
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0],b[0]));

        int count = 1;
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                end = Math.min(end, points[i][1]);
            } else {
                count++;
                end = points[i][1];
            }
        }

        return count;
    }
}
