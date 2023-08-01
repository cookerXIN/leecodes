package com.liao.test.ke0729;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/1
 */
public class A01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int idx = 0;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] == -1) {
                idx = i;
            }
        }

        int minL = Integer.MAX_VALUE;
        int minR = Integer.MAX_VALUE;

        for (int i = 0; i < idx; i++) {
            minL = Math.min(minL, arr[i]);
        }
        for (int i = idx+1; i < n; i++) {
            minR = Math.min(minR, arr[i]);
        }

        System.out.println(minL+minR);
    }
}
