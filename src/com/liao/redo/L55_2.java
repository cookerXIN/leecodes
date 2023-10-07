package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/10/5
 */
public class L55_2 {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return true;
        }
        int cover = nums[0];

        for (int i = 1; i <= cover; i++) {
            cover = Math.max(i+nums[i], cover);
            if (cover >= len-1) {
                return true;
            }
        }

        return false;
    }
}
