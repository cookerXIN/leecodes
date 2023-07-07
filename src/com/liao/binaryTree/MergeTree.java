package com.liao.binaryTree;

/**
 * @author liaoguixin
 * @data 2023/6/30
 */
public class MergeTree {
    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(5);
        TreeNode t3 = new TreeNode(3, t5, null);
        TreeNode root1 = new TreeNode(1, t3, new TreeNode(2));

        TreeNode t4 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t1 = new TreeNode(1, null, t4);
        TreeNode t31 = new TreeNode(3, null, t7);
        TreeNode root2 = new TreeNode(2, t1, t31);
        TreeNode treeNode = mergeTrees(root1, root2);
        System.out.println("1");
    }


    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        int r1;
        int r2;
        TreeNode left1;
        TreeNode left2;
        TreeNode right1;
        TreeNode right2;

        if (root1 == null) {
            r1 = 0;
            left1 = null;
            right1 = null;
        } else {
            r1 = root1.val;
            left1 = root1.left;
            right1 = root1.right;
        }

        if (root2 == null) {
            r2 = 0;
            left2 = null;
            right2 = null;
        } else {
            r2 = root2.val;
            left2 = root2.left;
            right2 = root2.right;
        }

        TreeNode root = new TreeNode(r1 + r2);
        root.left = mergeTrees(left1, left2);
        root.right = mergeTrees(right1, right2);

        return root;
    }


}
