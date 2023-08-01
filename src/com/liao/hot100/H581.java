package com.liao.hot100;

/**
 * @author liaoguixin
 * @date 2023/8/1
 */
public class H581 {
    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxNum = Integer.MIN_VALUE, right = -1;
        int minNum = Integer.MAX_VALUE, left = -1;
        // right 是小于最大值的最后一个数
        // left 是大于最小值的最后一个数
        for (int i = 0; i < n; i++) {
            if (maxNum > nums[i]) {
                right = i;
            } else {
                maxNum = nums[i];
            }

            if (minNum < nums[n-i-1]) {
                left = n-i-1;
            } else {
                minNum = nums[n-i-1];
            }
        }

        return right == -1 ? 0 : right-left+1;
    }
}
