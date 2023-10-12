package com.liao.paperTest.huawei.h1011;

import com.liao.dp.Change;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/10/11
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] in1 = input.nextLine().split(" ");
        int m = Integer.parseInt(in1[0]);
        int n = Integer.parseInt(in1[1]);
        int x = Integer.parseInt(input.nextLine());
        String[] in2 = input.nextLine().split(" ");
        int[] nums = new int[x];
        for (int i = 0; i < x; i++) {
            nums[i] = Integer.parseInt(in2[i]);
        }

        int res = 0;
        int cur = 0;
        int lo = 0;
        for (int i = 0; i < x; i++) {
            cur += nums[i];
            if (i == m + lo - 1) {
                if (cur > n) {
                    res += cur - n;
                    change(nums, i, cur - n);
                    cur = n;
                }
                cur -= nums[lo];
                lo++;
            }
        }

        System.out.println(res);
    }

    static void change(int[] nums, int idx, int n) {
        while (n > 0) {
            if (nums[idx] <= n) {
                n -= nums[idx];
                nums[idx] = 0;
            } else {
                nums[idx] -= n;
                n = 0;
            }

            idx--;
        }
    }
}
