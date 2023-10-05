package com.liao.redo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/10/5
 */
public class L39_2 {
    public static void main(String[] args) {

    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> items = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(items));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            target -= candidates[i];
            items.add(candidates[i]);
            dfs(candidates, target, i);
            items.remove(items.size()-1);
            target += candidates[i];
        }
    }
}
