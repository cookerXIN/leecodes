package com.liao.binaryTree;

/**
 * @author liaoguixin
 * @data 2023/7/1
 */
public class InsertTrees {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));


    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }



        return root;
    }

    public static void method(TreeNode root, int val) {
        if (root.left == null && root.right == null) {

            return;
        }

        if (root.val > val) {
            method(root.left, val);
        } else {
            method(root.right, val);
        }

    }
}
