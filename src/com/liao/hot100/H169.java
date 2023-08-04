package com.liao.hot100;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liaoguixin
 * @date 2023/8/4
 */
public class H169 {
    public static void main(String[] args) {
        System.out.println(Math.ceil(5.0/2.0));
    }

    public int majorityElement(int[] nums) {
        int n = nums.length;

        int target = n % 2 == 0 ? n/2 : n/2 + 1;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
                if (map.get(num) >= target) {
                    return num;
                }
            } else {
                map.put(num, 1);
            }
        }

        return -1;
    }
}
