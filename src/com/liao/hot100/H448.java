package com.liao.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/8/3
 */
public class H448 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        for (int num : nums) {
            int x = (num - 1) % n; //得到num值对应的下标
            nums[x] += n;   //num-1下标位置的数+n放入nums数组中
        }

        return null;
    }
}
