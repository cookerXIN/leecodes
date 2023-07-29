package com.liao.hot100;

import com.liao.binaryTree.TreeNode;

/**
 * @author liaoguixin
 * @date 2023/7/29
 */
public class H543 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(6)), new TreeNode(3));
        System.out.println(diameterOfBinaryTree(root));
    }

    static int res = Integer.MIN_VALUE;
    public static int diameterOfBinaryTree(TreeNode root) {
        method(root);

        return res-1;
    }

    public static int method(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = method(root.left);
        int right = method(root.right);

        res = Math.max(left+right+1, res);

        return Math.max(left, right) + 1;
    }
}
