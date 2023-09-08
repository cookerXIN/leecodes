package com.liao.redo;

import java.util.Arrays;

/**
 * @author liaoguixin
 * @date 2023/9/7
 */
public class L31 {
    public static void main(String[] args) {

    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;

        for (int i = n-1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                Arrays.sort(nums, i, n);
                for (int j = i; j < n; j++) {
                    if (nums[j] > nums[i-1]) {
                        int tmp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = tmp;
                        return;
                    }
                }
            }
        }

        Arrays.sort(nums);
        return;
    }
}
