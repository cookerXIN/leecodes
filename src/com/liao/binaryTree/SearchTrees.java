package com.liao.binaryTree;

/**
 * @author liaoguixin
 * @data 2023/6/30
 */
public class SearchTrees {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));

        TreeNode treeNode = searchBST(root, 2);
        System.out.println("1");
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }

    }
}
