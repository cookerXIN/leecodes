package com.liao.redo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/8/16
 */
public class L15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                } else if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    Collections.addAll(list, nums[i], nums[left], nums[right]);
                    res.add(list);
                    while (right > left && nums[right] == nums[right-1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left+1]) {
                        left++;
                    }
                    left++;
                    right--;
                }
            }
        }

        return res;
    }
}
