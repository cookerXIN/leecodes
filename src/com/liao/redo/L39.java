package com.liao.redo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/8/22
 */
public class L39 {
    public static void main(String[] args) {
        int[] candidates = {
                2,3,6,7
        };
        System.out.println(combinationSum(candidates, 7));
    }

    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> item = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return list;
    }

    static void dfs(int[] candidates, int target, int start) {
        if (target == 0) {
            List<Integer> tmp = new ArrayList<>(item);
            list.add(tmp);
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            item.add(candidates[i]);
            target -= candidates[i];
            dfs(candidates, target, i);
            target += candidates[i];
            item.remove(item.size() - 1);
        }
    }
}
