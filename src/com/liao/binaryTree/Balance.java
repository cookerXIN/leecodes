package com.liao.binaryTree;

/**
 * @author liaoguixin
 * @date 2023/6/27
 * @apiNote
 */
public class Balance {
    public static void main(String[] args) {
        TreeNode t15 = new TreeNode(15);
        TreeNode t21 = new TreeNode(21);
        TreeNode t7 = new TreeNode(7, t21, null);
        TreeNode t20 = new TreeNode(20, t15, t7);

        TreeNode t5 = new TreeNode(5);
        TreeNode t9 = new TreeNode(9, null, null);

        TreeNode node = new TreeNode(3, t9, t20);
        System.out.println(isBalance(node));

    }

    public static boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftDepth = depth(root.left, 0);
        int rightDepth = depth(root.right, 0);

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }

        return isBalance(root.left) && isBalance(root.right);
    }

    public static int depth(TreeNode root, int res) {
        if (root == null) {
            return res;
        }

        int leftDepth = 0;
        int rightDepth = 0;
        if (root.left != null) {
            leftDepth = depth(root.left, res);
        }
        if (root.right != null) {
            rightDepth = depth(root.right, res);
        }

        res = Math.max(leftDepth, rightDepth) + 1;

        return res;
    }
}
