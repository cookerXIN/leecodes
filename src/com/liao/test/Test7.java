package com.liao.test;

import java.util.*;
/**
 * @author liaoguixin
 * @date 2023/9/3
 */
public class Test7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }

        int res = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }else {
                while (set.contains(nums[i])) {
                    nums[i] += 1;
                    res++;
                }
                set.add(nums[i]);
            }
        }

        System.out.println(res);
    }
}
