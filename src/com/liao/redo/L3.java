package com.liao.redo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liaoguixin
 * @date 2023/8/22
 */
public class L3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        int j = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {

            if (i != 0) {
                set.remove(s.charAt(i-1));
            }

            while (j < len && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }
            res = Math.max(res, j-i);
        }

        return res;
    }
}
