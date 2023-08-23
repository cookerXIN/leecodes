package com.liao.redo;

import com.liao.binaryTree.TreeNode;

/**
 * @author liaoguixin
 * @date 2023/8/23
 */
public class L230 {
    public static void main(String[] args) {

    }

    public static int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }
    static int idx = 0;
    static int res;

    static void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }



        dfs(root.left, k);
        idx++;
        if (idx == k) {
            res = root.val;
            return;
        }
        dfs(root.right, k);
    }
}
