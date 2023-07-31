package com.liao.hot100;

/**
 * @author liaoguixin
 * @date 2023/7/31
 */
public class H33 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n-1;
        int mid;
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        if (target < nums[left] && target > nums[right]) {
            return -1;
        }

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n-1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
