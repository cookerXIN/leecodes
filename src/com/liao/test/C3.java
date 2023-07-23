package com.liao.test;

/**
 * @author liaoguixin
 * @date 2023/7/23
 */
public class C3 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(11));
    }


    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];

        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(2*dp[idx2], Math.min(3*dp[idx3], 5*dp[idx5]));

            if (dp[i] == 2*dp[idx2]) {
                idx2++;
            }
            if (dp[i] == 3 * dp[idx3]) {
                idx3++;
            }
            if (dp[i] == 5 * dp[idx5]) {
                idx5++;
            }
        }

        return dp[n-1];
    }
}
