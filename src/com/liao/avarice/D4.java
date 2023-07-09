package com.liao.avarice;

import java.util.Arrays;

/**
 * @author liaoguixin
 * @data 2023/7/9
 */
public class D4 {
    public static void main(String[] args) {
        //输入：nums = [4,2,3], k = 1
        //输出：5
        //解释：选择下标 1 ，nums 变为 [4,-2,3] 。
        int[] nums = {3,-1,0,2};
        System.out.println(largestSumAfterKNegations(nums, 3));
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
        nums = Arrays.stream(nums).sorted().boxed().sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1)).mapToInt(Integer::intValue).toArray();

        for (int i = 0; i < nums.length; i++) {
            if (k > 0 && nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        if (k % 2 == 1) {
            nums[nums.length - 1] = -nums[nums.length - 1];
        }

        return Arrays.stream(nums).sum();
    }
}
