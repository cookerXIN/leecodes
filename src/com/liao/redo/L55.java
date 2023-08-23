package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/8/23
 */
public class L55 {
    public static void main(String[] args) {

    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int cover = nums[0];

        for (int i = 1; i < nums.length; i++) {
            cover = Math.max(i + nums[i], cover);
            if (cover >= nums.length) {
                return true;
            }
        }
        return false;
    }
}
