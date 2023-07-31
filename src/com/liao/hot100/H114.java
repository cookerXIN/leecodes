package com.liao.hot100;

import com.liao.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/7/31
 */
public class H114 {
    public static void main(String[] args) {
        TreeNode t15 = new TreeNode(15);
        TreeNode t21 = new TreeNode(21);
        TreeNode t7 = new TreeNode(7, t21, null);
        TreeNode t20 = new TreeNode(20, t15, t7);

        TreeNode t5 = new TreeNode(5);
        TreeNode t9 = new TreeNode(9, null, null);

        TreeNode node = new TreeNode(3, t9, t20);
        flatten(node);
    }

    public static void flatten(TreeNode root) {
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                TreeNode pre = next;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }

            cur = cur.right;
        }
    }

}
