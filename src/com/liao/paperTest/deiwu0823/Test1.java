package com.liao.paperTest.deiwu0823;

import java.util.*;
/**
 * @author liaoguixin
 * @date 2023/8/25
 */
public class Test1 {
    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in);
        //int n = input.nextInt();
        //int[] nums = new int[n];
        //for (int i = 0; i < n; i++) {
        //    nums[i] = input.nextInt();
        //}

        int n = 5;
        int[] nums = {2,1,1,3,2};
        if (n == 2) {
            System.out.println(Math.abs(nums[1] - nums[0]));
            return;
        }
        Arrays.sort(nums);
        int left = nums[n-1], right = nums[n-1];
        int idx = n-1;
        int res = Integer.MIN_VALUE;
        while (idx > 0) {
            int leftDiff = left - nums[idx-1];
            left = nums[idx - 1];
            res = Math.max(res, leftDiff);
            idx--;
            if (idx <= 0) {
                break;
            }
            int rightDiff = right - nums[idx-1];
            right = nums[idx - 1];
            res = Math.max(res, rightDiff);
            idx--;
        }

        res = Math.max(res, nums[1] - nums[0]);
        System.out.println(res);
    }
}
