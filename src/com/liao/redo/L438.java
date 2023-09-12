package com.liao.redo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/9/8
 */
public class L438 {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int[] sNum = new int[26];
        int[] pNum = new int[26];
        int lenP = p.length();
        int lenS = s.length();

        List<Integer> list = new ArrayList<Integer>();
        if (lenS < lenP) {
            return list;
        }

        for (int i = 0; i < lenP; i++) {
            pNum[p.charAt(i) - 'a'] += 1;
            sNum[s.charAt(i) - 'a'] += 1;
        }

        if (Arrays.equals(sNum, pNum)) {
            list.add(0);
        }

        for (int i = 0; i < lenS - lenP; i++) {
            sNum[s.charAt(i) - 'a'] -= 1;
            sNum[s.charAt(i+lenP) - 'a'] += 1;
            if (Arrays.equals(sNum, pNum)) {
                list.add(i+1);
            }
        }

        return list;
    }
}
