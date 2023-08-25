package com.liao.redo;

import com.liao.binaryTree.TreeNode;

/**
 * @author liaoguixin
 * @date 2023/8/25
 */
public class L437 {
    public static void main(String[] args) {

    }

    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int res = dfs(root, targetSum);
        return res + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }



    static int dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        if (root.val == targetSum) {
            res++;
        }

        targetSum -= root.val;
        res += dfs(root.left, targetSum);
        res += dfs(root.right, targetSum);
        targetSum += root.val;

        return res;
    }
}
