package com.liao.redo;

import java.util.HashSet;

/**
 * @author liaoguixin
 * @date 2023/8/17
 */
public class L128 {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int count = 1;
                while (set.contains(cur+1)) {
                    cur = cur+1;
                    count++;
                }
                res = Math.max(res, count);
            }
        }

        return res;
    }

}
