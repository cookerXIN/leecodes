package com.liao.hot100;


import java.util.HashMap;
import java.util.HashSet;

/**
 * @author liaoguixin
 * @date 2023/7/29
 */
public class H560 {
    public static void main(String[] args) {
        int[] nums = {-1,-1,1};
        System.out.println(subarraySum(nums,  2));
    }

    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int pre = 0;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        for (int i = 0; i < n; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre,0)+1);
        }

        return count;
    }
}
