package com.liao.redo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liaoguixin
 * @date 2023/10/5
 */
public class L49_3 {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] nums = new int[26];
            for (char c : str.toCharArray()) {
                nums[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i]; j++) {
                    sb.append((char) ('a' + i));
                }
            }

            String s = sb.toString();
            if (map.containsKey(s)) {
                List<String> list = map.get(s);
                list.add(str);
                map.put(s, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
