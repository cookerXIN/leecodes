package com.liao.test;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/9/3
 */
public class Test8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int u = input.nextInt();
        int v = input.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        double target = (double) u / v;
        System.out.println(calNums(nums, n, target));
    }

    static int calNums(int[] nums, int n, double target) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            int cur = 0;
            int len = 0;
            for (int j = i; j < n; j++) {
                cur += nums[j];
                len = j - i + 1;

                if ((double) cur / len == target) {
                    count++;
                }
            }
        }

        return count;
    }
}
