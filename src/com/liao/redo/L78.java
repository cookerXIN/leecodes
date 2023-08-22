package com.liao.redo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/8/22
 */
public class L78 {
    public static void main(String[] args) {
        int[] nums = {
            1,2,3
        };
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        dfs(nums, new ArrayList<>(), 0);
        return list;
    }

    static List<List<Integer>> list = new ArrayList<>();
    static void dfs(int[] nums, List<Integer> item,  int idx) {

        List<Integer> tmp = new ArrayList<>(item);
        list.add(tmp);

        for (int i = idx; i < nums.length; i++) {

            item.add(nums[i]);
            dfs(nums, item, i+1);
            item.remove(item.size()-1);

        }
    }
}
