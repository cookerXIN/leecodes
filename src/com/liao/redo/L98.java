package com.liao.redo;

import com.liao.binaryTree.TreeNode;

/**
 * @author liaoguixin
 * @date 2023/9/21
 */
public class L98 {
    public static void main(String[] args) {

    }

    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }

        if (max != null && max.val < root.val) {
            return false;
        }

        max = root;

        return isValidBST(root.right);
    }
}
