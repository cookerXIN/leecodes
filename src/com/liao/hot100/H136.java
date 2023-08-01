package com.liao.hot100;

import java.util.Arrays;

/**
 * @author liaoguixin
 * @date 2023/8/1
 */
public class H136 {
    public static void main(String[] args) {
        int[] nums = {2,2,1};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int tmp = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == tmp) {
                count++;
            } else {
                if (count == 2) {
                    tmp = nums[i];
                    count = 1;
                } else {
                    return tmp;
                }
            }
        }

        return tmp;
    }
}
