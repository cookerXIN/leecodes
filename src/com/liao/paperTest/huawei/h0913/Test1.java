package com.liao.paperTest.huawei.h0913;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/9/18
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = input.nextInt();
        }

        System.out.println(minCount(weights, n, k));
    }

    static int minCount(int[] weights, int n, int k) {
        int pre = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int remain = weights[i] - (k - pre);
            count += remain / k + 1;
            pre = remain % k;
        }

        if (pre != 0) {
            count++;
        }

        return count;
    }
}
