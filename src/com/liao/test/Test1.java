package com.liao.test;

import com.liao.hot100.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/23
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (n <= 2) {
            System.out.println(1);
            return;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1; // 第一个月有一对兔子
        nums[2] = 1; // 第二个月有一对兔子

        for (int i = 4; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }

        System.out.println(nums[n]);
    }

    public int cal(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1; // 第一个月有一对兔子
        nums[2] = 1; // 第二个月有一对兔子

        for (int i = 4; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }
}
