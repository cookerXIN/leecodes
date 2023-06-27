package com.liao.binaryTree;

/**
 * @author liaoguixin
 * @date 2023/6/27
 * @apiNote
 */
public class Balance {
    public static void main(String[] args) {
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        TreeNode t20 = new TreeNode(20, t15, t7);

        TreeNode t5 = new TreeNode(5);
        TreeNode t9 = new TreeNode(9, t5, null);

        TreeNode node = new TreeNode(3, t9, t20);
    }
}
