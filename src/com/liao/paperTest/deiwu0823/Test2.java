package com.liao.paperTest.deiwu0823;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/25
 */
public class Test2 {
    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in);
        //int n = input.nextInt();
        //int target = input.nextInt();
        //
        //int[] nums = new int[n];
        //for (int i = 0; i < n; i++) {
        //    nums[i] = input.nextInt();
        //}

        int n = 5;
        int target = 5;
        int[] nums = {1,3,2,1,1};

        Arrays.sort(nums);
        dfs(target, 0, nums);
        if (res == Integer.MAX_VALUE) {
            System.out.println("No solution");
            return;
        }
        System.out.println(res);

    }

    static List<Integer> list = new ArrayList<Integer>();
    static int res = Integer.MAX_VALUE;

    static void dfs(int target, int idx, int[] nums) {
        if (target == 0) {
            int size = list.size();
            res = Math.min(res, size);
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            target -= nums[i];
            list.add(nums[i]);
            dfs(target, i+1, nums);
            list.remove(list.size() - 1);
            target += nums[i];
        }
    }
}
