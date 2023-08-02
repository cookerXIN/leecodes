package com.liao.hot100;

import java.util.Arrays;

/**
 * @author liaoguixin
 * @date 2023/8/2
 */
public class H31 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            // 找需要交换的地方 满足大数和小数的地方
            if (nums[i] > nums[i-1]) {
                // 则转折点后面的序列得按升序排列
                Arrays.sort(nums, i , n);
                // 找到与转折点（i-1）要交换的地方
                for (int j = i; j < n; j++) {
                    if (nums[j] > nums[i-1]) {
                        int tmp = nums[j];
                        nums[j] = nums[j-1];
                        nums[j-1] = tmp;
                        return;
                    }
                }
            }
        }
        // 如果没有比起大的排列 则排序到最前
        Arrays.sort(nums);
        return;
    }


}
