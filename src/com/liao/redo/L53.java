package com.liao.redo;

import java.util.SortedMap;

/**
 * @author liaoguixin
 * @date 2023/8/20
 */
public class L53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = nums[0];

        int len = nums.length;
        int[] dp = new int[len];

        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }

        System.out.println(res);
    }
}
