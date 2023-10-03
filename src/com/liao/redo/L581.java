package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/9/25
 */
public class L581 {
    public static void main(String[] args) {

    }

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxVal = Integer.MIN_VALUE, right = -1;
        int minVal = Integer.MAX_VALUE, left = -1;

        for (int i = 0; i < n; i++) {
            if (maxVal > nums[i]) {
                right = i;
            } else {
                maxVal = nums[i];
            }

            if (minVal < nums[n-i-1]) {
                left = n-i-1;
            } else {
                minVal = nums[n-i-1];
            }
        }

        return right == -1 ? 0 : right-left+1;
    }
}
