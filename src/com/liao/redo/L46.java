package com.liao.redo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/10/5
 */
public class L46 {
    public static void main(String[] args) {

    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> items = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited);
        return res;
    }

    public void dfs(int[] nums, boolean[] visited) {
        if (items.size() == nums.length) {
            res.add(new ArrayList<>(items));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            items.add(nums[i]);
            dfs(nums, visited);
            items.remove(items.size() - 1);
            visited[i] = false;
        }
    }
}
