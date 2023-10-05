package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/10/5
 */
public class L34_2 {
    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        int mid;

        int start = -1;
        int end = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                start = mid;
                end = mid;

                while (start >= 1 && nums[start] == nums[start-1]) {
                    start--;
                }
                while (end < len-1 && nums[end] == nums[end+1]) {
                    end++;
                }
                break;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return new int[]{start, end};
    }
}
