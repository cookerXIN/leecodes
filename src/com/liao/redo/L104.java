package com.liao.redo;

import com.liao.binaryTree.TreeNode;

/**
 * @author liaoguixin
 * @date 2023/8/23
 */
public class L104 {
    public static void main(String[] args) {

    }


    public static int maxDepth(TreeNode root) {
        return dfs(root,0);
    }

    static int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth += 1;

        int left = dfs(root.left, depth);
        int right = dfs(root.right, depth);

        return Math.max(left, right);
    }
}
