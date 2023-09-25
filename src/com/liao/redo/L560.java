package com.liao.redo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liaoguixin
 * @date 2023/9/22
 */
public class L560 {
    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        int pre = 0;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);

        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];

            // 前缀和：pre[i] - pre[j] = k 因此只要找到j到i之间的连续子数组有多少个就行
            // 因此可以：pre[i] - k = pre[j] 只要找到pre[j]的个数
            if (map.containsKey(pre - k)) {
                cnt += map.get(pre - k);
            }

            map.put(pre, map.getOrDefault(pre,0)+1);
        }

        return cnt;
    }
}
