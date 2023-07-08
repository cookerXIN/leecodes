package com.liao.huisu;

import java.util.*;

/**
 * @author liaoguixin
 * @data 2023/7/7
 */
public class E5 {
    public static void main(String[] args) {
        int[] can = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(can, 8));
    }
    static List<List<Integer>> resList = new ArrayList<>();
    static LinkedList<Integer> itemList = new LinkedList<>();

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if ( i > start && candidates[i] == candidates[i - 1] ) {
                continue;
            }
            itemList.add(candidates[i]);
            target -= candidates[i];
            method(candidates, target, i + 1);
            target += candidates[i];
            itemList.removeLast();
        }
    }
}
