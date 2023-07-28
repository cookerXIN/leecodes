package com.liao.test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/7/25
 */
public class I9 {
    public static void main(String[] args) {
        problem2();
    }

    public static void problem1() {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        BigInteger bigN = new BigInteger(n);
        String k = sc.next();
        BigInteger bigK = new BigInteger(k);

        String res = (bigN.add(new BigInteger("1"))).multiply(bigN).multiply(bigK).divide(new BigInteger("2")).toString();
        System.out.println(res);
    }

    public static void problem2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (a,b) -> a[0] - b[0]);

        int[] pres = new int[m+1];
        for (int i = 1; i <= m; i++) {
            pres[i] = pres[i-1] + (arr[i-1][1] - arr[i-1][0]);
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            int l = i;
            int r = m;
            while (l < r) {
                int mid = l + (r - l)/2;
                if (arr[mid][1] >= arr[i][0] + k) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            if (r < m && arr[r][0] <= arr[i][0] + k) {
                res = Math.max(res, pres[r+1] - pres[i] - (arr[r][1] - arr[i][0] - k));
            } else {
                res = Math.max(res, pres[r] - pres[i]);
            }
        }

        System.out.println(res);
    }
}
