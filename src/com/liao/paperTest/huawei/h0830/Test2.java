package com.liao.paperTest.huawei.h0830;

import java.applet.Applet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/9/9
 */
public class Test2 {
    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in);
        //int n = input.nextInt();
        //int[] nums = new int[n];
        //
        //for (int i = 0; i < n; i++) {
        //    nums[i] = input.nextInt();
        //}

        int n = 4;
        int[] nums = {18, 24, 2, 4};

        int left = 0;
        int right = n-1;

        cal(nums, left, right, 0);
        int len = (list.size() - 1 )/ 2;
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0)).append(" ");

        int idx = 1;
        int cnt = 0;
        int cntL = 0;
        int cntR = 0;
        while (cnt < list.size() - 1) {
            for (int i = cntL; i < cntL + idx; i++) {
                sb.append(list.get(i+1)).append(" ");
            }
            cntL+=idx;
            for (int i = cntR; i < cntR + idx; i++) {
                sb.append(list.get(i+1+len)).append(" ");
            }
            cntR+=idx;
            cnt = cntL + cntR;
            idx *= 2;
        }

        System.out.println(sb.toString());
    }
    static List<Integer> list = new ArrayList<>();
    static void cal(int[] nums, int left, int right, int fa) {
        if (left == right) {
            list.add(nums[left] - fa);
            return;
        }
        int cur = calAvg(nums, left, right) - fa;
        list.add(cur);
        fa += cur;
        int mid = left + right;
        cal(nums, left, mid / 2, fa);
        cal(nums, mid / 2 + 1, right, fa);
    }

    static int calAvg(int[] nums, int left, int right) {
        int max = nums[left];
        int min = nums[left];

        for (int i = left+1; i <= right; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        return (max + min) / 2;
    }
}
