package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/10/4
 */
public class L330 {
    public static void main(String[] args) {

    }

    public int minPatches(int[] nums, int n) {
        int res = 0;
        long x = 1;
        int len = nums.length;
        int idx = 0;

        while (x <= n) {
            if (idx < len && nums[idx] <= x) {
                x += nums[idx];
                idx++;
            } else {
                x *= 2;
                res++;
            }
        }

        return res;
    }
}
