package com.liao.huisu;

import java.util.*;

/**
 * @author liaoguixin
 * @data 2023/7/8
 */
public class K10 {
    public static void main(String[] args) {

        //输入：nums = [1,2,3]
        //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        int[] nums = {
            1,1,2
        };
        System.out.println(permute(nums));
    }

    static Set<List<Integer>> resSet = new HashSet<>();
    static LinkedList<Integer> items = new LinkedList<>();



    public static List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        method(nums, used);
        List<List<Integer>> resList = new ArrayList<>();
        for (List<Integer> list : resSet) {
            resList.add(list);
        }
        return resList;
    }

    public static void method(int[] nums,  boolean[] used) {
        if (items.size() == nums.length) {
            resSet.add(new ArrayList<>(items));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            items.add(nums[i]);
            used[i] = true;
            method(nums, used);
            used[i] = false;
            items.removeLast();
        }
    }
}
