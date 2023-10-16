package com.liao.paperTest;

import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/9/23
 */
public class MaxSubsequenceSum {
    public static int maxSubsequenceSum(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSum = 0;
        for (int num : a) {
            if (map.containsKey(num - 1)) {
                map.put(num, map.get(num - 1) + num);
            } else {
                map.put(num, num);
            }
            maxSum = Math.max(maxSum, map.get(num));
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {1,3,2,4,3};
        System.out.println(maxSubsequenceSum(a));  // Expected output: 28 (because 1+2+3+4+6+7+8=31 is the max sum)
    }
}

