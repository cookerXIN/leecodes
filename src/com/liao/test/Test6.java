package com.liao.test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author liaoguixin
 * @date 2023/9/3
 */
public class Test6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }

        Set<Integer> set = new HashSet<Integer>();
        int idx = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[idx];
            while (set.contains(num)) {
                set.remove(nums[idx]);
                idx++;
            }
            set.add(num);
            res = Math.max(res, i - idx + 1);
        }
        System.out.println(res);
    }
}
