package com.liao.redo;

import java.util.Arrays;

/**
 * @author liaoguixin
 * @date 2023/9/21
 */
public class L283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int noIdx = -1;

        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[noIdx+1] = nums[i];
                noIdx++;
            }
        }

        for (int i = noIdx+1; i < len; i++) {
            nums[i] = 0;
        }
    }
}
