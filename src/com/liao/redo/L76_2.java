package com.liao.redo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liaoguixin
 * @date 2023/10/9
 */
public class L76_2 {
    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if (lenS < lenT) {
            return "";
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0)+1);
        }

        int left = 0;
        int right = -1;
        int minLen = Integer.MAX_VALUE;
        int resLeft = -1;
        int resRight = -1;

        while (right < lenS) {
            right++;

            if (right < lenS && tMap.containsKey(s.charAt(right))) {
                sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0)+1);
            }

            while (check(tMap, sMap) && left <= right) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    resLeft = left;
                    resRight = left + minLen;
                }

                if (tMap.containsKey(s.charAt(left))) {
                    sMap.put(s.charAt(left), sMap.getOrDefault(s.charAt(left), 0)-1);
                }
                left++;
            }
        }

        return resLeft == -1 ? "" : s.substring(resLeft, resRight);
    }

    boolean check(Map<Character, Integer> tMap, Map<Character, Integer> sMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (sMap.getOrDefault(key, 0) < value) {
                return false;
            }
        }

        return true;
    }
}
