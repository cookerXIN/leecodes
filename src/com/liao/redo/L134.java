package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/9/12
 */
public class L134 {
    public static void main(String[] args) {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cur = 0;
        int all = 0;

        int idx = 0;
        for (int i = 0; i < cost.length; i++) {
            cur += (gas[i] - cost[i]);
            all += (gas[i] - cost[i]);
            if (cur < 0) {
                idx = (i+1) % cost.length;
                cur = 0;
            }

        }

        if (all < 0) {
            return -1;
        }
        return idx;
    }
}
