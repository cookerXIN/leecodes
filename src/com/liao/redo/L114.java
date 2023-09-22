package com.liao.redo;

import com.liao.binaryTree.TreeNode;

/**
 * @author liaoguixin
 * @date 2023/9/21
 */
public class L114 {
    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left != null) {
                // 左子树
                TreeNode next = cur.left;

                // 将右子树接到左子树的最右节点的右边
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;

                // 将左子树接到右边
                cur.left = null;
                cur.right = next;
            }

            // 重新开始递归右子树
            cur = cur.right;
        }
    }
}
