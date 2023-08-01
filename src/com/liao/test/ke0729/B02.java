package com.liao.test.ke0729;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/1
 */
public class B02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];

        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arrB[i] = sc.nextInt();
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (arrA[i] < 0 && arrB[i] > 0) {
                arrA[i] = -arrA[i];
            } else if (arrA[i] > 0 && arrB[i] < 0) {
                arrB[i] = -arrB[i];
            }

            res += Math.abs(arrA[i] - arrB[i]);
        }

        System.out.println(res);
    }
}
