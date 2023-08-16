package com.liao.paperTest.dajiang0813;

import java.util.SortedMap;

/**
 * @author liaoguixin
 * @date 2023/8/15
 */
public class Test1 {
    // 加油站改
    // https://leetcode.cn/problems/gas-station/
    // 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
    // 输出: 3
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        int curSum = 0;
        int totalSum = 0;
        int idx = 0;

        int n = gas.length;
        for (int i = 0; i < n; i++) {
            curSum += (gas[i] - cost[i]);
            totalSum += (gas[i] - cost[i]);
            // 如果当前下于0 则无法达到当前点
            if (curSum < 0) {
                idx = (i + 1) % n;
                curSum = 0;
            }
        }

        // 如果总数小于0,则肯定走不完一圈
        if (totalSum < 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(idx);
    }
}
