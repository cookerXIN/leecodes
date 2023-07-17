package com.liao.dp;

/**
 * @author liaoguixin
 * @date 2023/7/17
 */
public class CountSubstrings {
    public static void main(String[] args) {
        //输入：s = "aaa"
        //输出：6
        //解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"

        String s = "aaa";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (chars[i] == chars[j]) {
                    if (j - i <= 1) {
                        res++;
                        dp[i][j] = true;
                    } else if (dp[i+1][j-1]){
                        res++;
                        dp[i][j] = true;
                    }
                }
            }
        }

        return res;

    }
}
