package com.liao.redo;

import java.util.Arrays;

/**
 * @author liaoguixin
 * @date 2023/9/1
 */
public class L14 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (a,b)->a.length() - b.length());
        StringBuilder sb = new StringBuilder(strs[0]);

        for (int i = 0; i < sb.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (sb.charAt(i) != strs[j].charAt(i)) {
                    return sb.delete(i,sb.length()).toString();
                }
            }
        }


        return sb.toString();
    }
}
