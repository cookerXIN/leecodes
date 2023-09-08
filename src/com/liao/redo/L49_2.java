package com.liao.redo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liaoguixin
 * @date 2023/9/7
 */
public class L49_2 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

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
            if (map.containsKey(sb.toString())) {
                List<String> list = map.get(sb.toString());
                list.add(str);
                map.put(sb.toString(), list);
            } else {
                List<String> item = new ArrayList<>();
                item.add(str);
                map.put(sb.toString(), item);
            }
        }

        for (Map.Entry<String, List<String>> listEntry : map.entrySet()) {
            res.add(listEntry.getValue());
        }

        return res;
    }
}
