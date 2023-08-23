package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/8/23
 */
public class L136 {
    public static void main(String[] args) {

        int num = 2 ^ 2 ^ 1;

        int[] nums = {
                2,2,1
        };
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }

        return res;
    }
}
