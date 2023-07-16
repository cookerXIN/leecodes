package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/16
 */
public class IsSubsequence {
    public static void main(String[] args) {
        //输入：s = "abc", t = "ahbgdc"
        //输出：true

        String s = "axc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));

    }

    public static boolean isSubsequence(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        int[][] dp = new int[n1+1][n2+1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (chars1[i-1] == chars2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return n1 == dp[n1][n2];
    }
}
