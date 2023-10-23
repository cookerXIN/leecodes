package com.liao.redo;

import com.liao.binaryTree.TreeNode;

/**
 * @author liaoguixin
 * @date 2023/10/16
 */
public class L98_2 {
    public static void main(String[] args) {
        System.out.println((11+3*8)/4%3);
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

        if (max != null && max.val >= root.val) {
            return false;
        }
        max = root;

        return isValidBST(root.right);
    }
}
