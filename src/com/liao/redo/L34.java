package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/9/12
 */
public class L34 {
    public static void main(String[] args) {
        int[] nums = {
            5,7,7,8,8,10
        };
        System.out.println(searchRange(nums, 6));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1,-1};
        } else if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[] {1, 1};
            } else {
                return new int[] {-1,-1};
            }
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
                right = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        if (nums[left] != target) {
            return new int[] {-1,-1};
        }

        while (left >= 1 && nums[left-1]==nums[left]) {
            left--;
        }
        while (right <= nums.length - 2 && nums[right+1] == nums[right]) {
            right++;
        }

        return new int[] {left, right};
    }
}
