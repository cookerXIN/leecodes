package com.liao.paperTest.meituan0819;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/20
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
            sum += nums[i];
        }

        dfs(nums, 0, 0, sum);
        System.out.println(result % 1000000007);

    }
    static int result = 0;
    static void dfs(int[] nums, int idx, int pre, int sum) {
        if (idx == nums.length) {
            if (pre == sum) {
                result++;
                result = result % 1000000007;
            }
            return;
        }

        for (int i = 1; i <= sum - nums.length + 1; i++) {
            if (nums[idx] == i) {
                continue;
            }
            pre += i;
            idx += 1;
            dfs(nums, idx, pre, sum);
            idx -= 1;
            pre -= i;
        }
    }
}
