package com.liao.paperTest.zijie0820;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/21
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
            sum += nums[i];
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }
        Arrays.sort(nums);

        int a1 = cal(n / 2, nums);
        int a2 = cal(n / 2 - 1, nums);
        int a3 = cal(n / 2 + 1, nums);

        System.out.println(Math.min(Math.min(a1,a2),a3));
    }

    static int cal(int idx, int[] nums) {
        if (idx < 0 || idx >= nums.length) {
            return 0;
        }

        int aim = nums[idx];
        int dif = 0;
        int res = 0;

        for (int num : nums) {
            dif = Math.max(dif, Math.abs(num - aim));
            res += (Math.abs(num - aim));
        }

        res -= dif;
        return res;
    }
}
