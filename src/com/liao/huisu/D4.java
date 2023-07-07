package com.liao.huisu;

import java.util.*;

/**
 * @author liaoguixin
 * @data 2023/7/7
 */
public class D4 {
    public static void main(String[] args) {
        int[] cand = {2,3,6,7};
        System.out.println(combinationSum(cand, 7));
    }

    static List<List<Integer>> resList = new ArrayList<>();
    static LinkedList<Integer> itemList = new LinkedList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        method(candidates, target, 0);

        return resList;
    }

    public static void method(int[] candidates, int target, int start) {
        if (target == 0) {
            resList.add(new ArrayList<>(itemList));
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            itemList.add(candidates[i]);
            target -= candidates[i];
            method(candidates, target, i);
            target += candidates[i];
            itemList.removeLast();
        }
    }
}
