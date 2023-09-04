package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/8/26
 */
public class L849 {
    public static void main(String[] args) {
        int[] seats = {1,0,0,0,1,0,1};
        System.out.println(maxDistToClosest(seats));
    }

    public static int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int res = Integer.MIN_VALUE;

        int pre = 0;
        int tmp;
        for (int i = 0; i < len; i++) {
            if (seats[i] == 1 && i != pre) {
                if (seats[pre] == 0) {
                    tmp = i - pre;
                } else {
                    tmp = (i- pre) / 2;
                }
                res = Math.max(res, tmp);
                pre = i;
            }
        }
        if (seats[len-1] != 1) {
            tmp = len-1 - pre;
            res = Math.max(res, tmp);
        }
        return res;
    }
}
