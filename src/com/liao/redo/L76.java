package com.liao.redo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author liaoguixin
 * @date 2023/9/13
 */
public class L76 {
    public static void main(String[] args) {
        System.out.println(minWindow("aa", "aa"));
    }

    public static String minWindow(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        if (lenS < lenT) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> cnt = new HashMap<>();
        for (int i = 0; i < lenT; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1);
        }

        int left = 0;
        int right = -1;
        int len = Integer.MAX_VALUE;
        int resL = -1;
        int resR = -1;

        while (right < lenS) {
            right++;

            if (right < lenS && map.containsKey(s.charAt(right))) {
                cnt.put(s.charAt(right), cnt.getOrDefault(s.charAt(right), 0)+1);
            }

            while (check(map, cnt) && left <= right) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    resL = left;
                    resR = left + len;
                }
                if (map.containsKey(s.charAt(left))) {
                    cnt.put(s.charAt(left), cnt.getOrDefault(s.charAt(left), 0)-1);
                }
                left++;
            }
        }

        return resL == -1 ? "" : s.substring(resL, resR);
    }

    static boolean check(Map<Character, Integer> map, Map<Character, Integer> cnt) {
        for (Map.Entry<Character, Integer> next : map.entrySet()) {
            Character key = (Character) next.getKey();
            Integer val = (Integer) next.getValue();

            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }

        return true;
    }
}
