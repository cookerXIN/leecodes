package com.liao.redo;

import com.liao.binaryTree.TreeNode;

/**
 * @author liaoguixin
 * @date 2023/9/12
 */
public class L104_2 {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        return Math.max(left, right) + 1;
    }
}
