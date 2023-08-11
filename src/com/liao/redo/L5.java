package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/8/11
 */
public class L5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome1("bb"));
    }

    public static String longestPalindrome1(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int start = 0;

        for (int l = 2; l <= len; l++) {
            for (int i = 0; i < len; i++) {
                int j = l + i - 1;

                if (j >= len) {
                    break;
                }

                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j] && j-i+1 > maxLen) {
                    maxLen = j-i+1;
                    start = i;
                }
            }
        }
        return s.substring(start, start+maxLen);
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 1) {
            return s;
        }

        int left = 0;
        int right = 0;

        for (int i = 0; i < len; i++) {
            int len1 = strLength(s, i, i);
            int len2 = strLength(s, i, i+1);

            int maxLen = Math.max(len1, len2);
            if (maxLen  > right - left) {
                left = i - (maxLen-1) / 2;
                right = i + maxLen / 2;
            }
        }



        return s.substring(left, right+1);
    }


    public static int strLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
