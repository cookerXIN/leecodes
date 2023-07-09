package com.liao.avarice;

/**
 * @author liaoguixin
 * @data 2023/7/9
 */
public class C3 {
    public static void main(String[] args) {
        //输入：nums = [2,3,1,1,4]
        //输出：true
        //解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
        int[] nums = {
                3,2,1,0,4
        };
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int cover = nums[0];
        if (nums.length == 1) {
            return true;
        }

        for (int i = 0; i <= cover; i++) {
            cover = Math.max(i + nums[i], cover);
            if (cover >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
