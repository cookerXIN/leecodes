package com.liao.redo;

import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/10/4
 */
public class L313 {
    public static void main(String[] args) {
        int[] primes = {2,7,13,19};
        System.out.println(nthSuperUglyNumber(12, primes));
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n+1];
        int len = primes.length;
        int[] points = new int[len];
        long[] val = new long[len];
        Arrays.fill(val, 1);

        for (int i = 1; i <= n; i++) {
            long minNum = Arrays.stream(val).min().getAsLong();
            dp[i] = minNum;
            for (int j = 0; j < len; j++) {
                if (val[j] == minNum) {
                    points[j]++;
                    val[j] = dp[points[j]] * primes[j];
                }
            }
        }

        return (int) dp[n];
    }

}
