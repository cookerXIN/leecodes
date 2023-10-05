package com.liao.redo;

import java.util.Arrays;

/**
 * @author liaoguixin
 * @date 2023/10/5
 */
public class L31_3 {
    public static void main(String[] args) {

    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;

        for (int i = len-1; i >= 0; i--) {
            if (nums[i] > nums[i-1]) {
                Arrays.sort(nums, i, len);
                for (int j = i; j < len; j++) {
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
    }
}
