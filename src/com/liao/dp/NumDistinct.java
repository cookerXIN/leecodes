package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/16
 */
public class NumDistinct {
    public static void main(String[] args) {
        //输入：s = "rabbbit", t = "rabbit"
        //输出：3
        //解释：
        //如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
        //rabbbit
        //        rabbbit
        //rabbbit

        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(numDistinct(s, t));
    }


    public static int numDistinct(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        int n1 = chars1.length;
        int n2 = chars2.length;

        int[][] dp = new int[n1+1][n2+1];

        for (int i = 0; i < n1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (chars1[i-1] == chars2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n1][n2];
    }
}
