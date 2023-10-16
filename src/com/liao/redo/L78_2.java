package com.liao.redo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/10/12
 */
public class L78_2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> items = new ArrayList<>();
    public static void dfs(int[] nums, int start) {
        res.add(new ArrayList<>(items));

        for (int i = start; i < nums.length; i++) {
            items.add(nums[i]);
            dfs(nums, i+1);
            items.remove(items.size() - 1);
        }
    }
}
