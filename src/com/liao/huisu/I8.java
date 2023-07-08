package com.liao.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liaoguixin
 * @data 2023/7/7
 */
public class I8 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    static List<List<Integer>> resList = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        method(nums, 0);
        return resList;
    }

    static LinkedList<Integer> items = new LinkedList<>();
    public static void method(int[] nums, int start) {
        resList.add(new ArrayList<>(items));

        for (int i = start; i < nums.length; i++) {
            items.add(nums[i]);
            method(nums, i+1);
            items.removeLast();
        }
    }

}
