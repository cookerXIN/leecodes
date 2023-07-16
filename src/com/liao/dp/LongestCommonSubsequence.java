package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/16
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        //输入：text1 = "abcde", text2 = "ace"
        //输出：3
        //解释：最长公共子序列是 "ace" ，它的长度为 3 。

        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        int n1 = chars1.length;
        int n2 = chars2.length;

        int[][] dp = new int[n1+1][n2+1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
               if (chars1[i-1] == chars2[j-1]) {
                   dp[i][j] = dp[i-1][j-1] + 1;
               } else {
                   dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
               }
            }
        }

        return dp[n1][n2];
    }
}
