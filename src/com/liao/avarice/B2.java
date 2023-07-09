package com.liao.avarice;

/**
 * @author liaoguixin
 * @data 2023/7/9
 */
public class B2 {
    public static void main(String[] args) {
        //输入：nums = [1,7,4,9,2,5]
        //输出：6
        //解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
        int[] nums = {1,7,4,9,2,5};
        System.out.println(wiggleMaxLength(nums));
    }

    public static int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        } else if (nums.length == 2) {
            if (nums[0] != nums[1]) {
                return 2;
            } else {
                return 1;
            }
        }

        int count = 1;
        int preDif = 0;
        int curDif = 0;

        for (int i = 1; i < nums.length; i++) {
            curDif = nums[i] - nums[i-1];
            if ((curDif > 0 && preDif <= 0) || (curDif < 0 && preDif >= 0)){
                count++;
                preDif = curDif;
            }
        }

        return count;
    }
}
