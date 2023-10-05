package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/10/5
 */
public class L33_2 {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[0]) {
                if (nums[mid] > target && target >= nums[0]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                if (target <= nums[len-1] && target > nums[mid]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }

        return -1;
    }
}
