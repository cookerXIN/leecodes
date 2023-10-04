package com.liao.redo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liaoguixin
 * @date 2023/10/4
 */
public class L3_2 {
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

            res = Math.max(res, set.size());
        }

        return res;
    }
}
