package com.liao.paperTest.meituan0819;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/20
 */
public class Test5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
            sum += nums[i];
        }
        Arrays.sort(nums);
        int ans = sum / n;
        int yu = sum % n;
        int res = 0;
        if (yu == 0) {
            for (int i = 0; i < n; i++) {
                res += Math.abs(nums[i] - ans);
            }
        } else {


            res = cal(nums);

        }

        System.out.println(res);
    }

    static int cal(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftS = sum - nums[0];
        int rightS = sum - nums[nums.length - 1];
        int l = (leftS % nums.length - 1 == 0) ? 0 : 1;
        int avgL = leftS / (nums.length - 1) + l;
        int r = (rightS % nums.length - 1 == 0) ? 0 : 1;
        int avgR = rightS / (nums.length - 1) + r;
        int left = 0;
        int right = 0;
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < avgL) {
                left += avgL - nums[i];
            } else {
                right += nums[i] - avgL;
            }
        }

        res =  Math.max(left, right);
        left = 0;
        right = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < avgR) {
                left += avgR - nums[i];
            } else {
                right += nums[i] - avgR;
            }
        }

        res =  Math.min(Math.max(left, right), res);
        return res;
    }
}
