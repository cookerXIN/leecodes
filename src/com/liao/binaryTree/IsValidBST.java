package com.liao.binaryTree;

import java.time.temporal.ValueRange;

/**
 * @author liaoguixin
 * @data 2023/6/30
 */
public class IsValidBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return method(root, root.val) && method(root.left, root.val) && method(root.right, root.val);
    }

    public static boolean method(TreeNode root, int val) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null) {
            if (root.left.val >= root.val || root.left.val < val) {
                return false;
            }
        }

        if (root.right != null) {
            if (root.right.val <= root.val || root.right.val < val) {
                return false;
            }
        }

        return true;
    }
}
