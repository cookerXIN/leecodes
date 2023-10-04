package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/10/4
 */
public class L5_2 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int left = 0;
        int right = 0;

        for (int i = 0; i < len; i++) {
            int len1 = check(s, i, i);
            int len2 = check(s, i, i+1);

            int maxLen = Math.max(len1, len2);
            if (maxLen > right - left) {
                left = i - (maxLen-1) / 2;
                right = i + maxLen / 2;
            }
        }

        return s.substring(left, right+1);
    }

    public static int check(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}
