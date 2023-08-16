package com.liao.redo;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/8/16
 */
public class L49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] nums = new int[26];
            for (int i = 0; i < str.length(); i++) {
                nums[str.charAt(i) - 'a'] += 1;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] > 0) {
                    sb.append((char) ('a' + i));
                    nums[i] -= 1;
                }
            }

            String key = sb.toString();
            List<String> item = map.getOrDefault(key, new ArrayList<String>());
            item.add(str);
            map.put(key, item);
        }

        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
            list.add(stringListEntry.getValue());
        }

        return list;
    }
}
