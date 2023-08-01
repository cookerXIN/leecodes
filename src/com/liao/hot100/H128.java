package com.liao.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author liaoguixin
 * @date 2023/7/31
 */
public class H128 {
    public static void main(String[] args) {
        int[] nums = {
                0,3,7,2,5,8,4,6,0,1
        };
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        int count = 1;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur + 1) {
                count++;
                cur = nums[i];
            } else if (nums[i] == cur) {
            } else {
                cur = nums[i];
                count = 1;
            }
            res = Math.max(res, count);
        }

        return res;
    }


    public static int longestConsecutive1(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (Integer num : set) {
            if (!set.contains(num-1)) {
                int count = 1;
                int cur = num;

                while (set.contains(cur+1)) {
                    cur += 1;
                    count++;
                }

                res = Math.max(res, count);
            }
        }

        return res;
    }
}
