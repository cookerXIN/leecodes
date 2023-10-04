package com.liao.redo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/10/4
 */
public class L15_2 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i+1;
            int right = n-1;

            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (tmp < 0) {
                    left++;
                } else if (tmp > 0) {
                    right--;
                } else {
                    List<Integer> item = new ArrayList<>();
                    Collections.addAll(item, nums[i], nums[left], nums[right]);
                    list.add(item);

                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
            }
        }

        return list;
    }
}
