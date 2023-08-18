package com.liao.redo;

import java.util.Arrays;

/**
 * @author liaoguixin
 * @date 2023/8/18
 */
public class L238 {
    public static void main(String[] args) {

    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);

        for (int i = 1; i < n; i++) {
            res[i] = nums[i-1] * res[i-1];
        }

        int R = 1;
        for (int i = n-2; i >= 0; i--) {
            res[i] = res[i] * R;
            R *= nums[i];
        }

        return res;
    }
}
