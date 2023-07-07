package com.liao.binaryTree;

import java.util.*;

/**
 * @author liaoguixin
 * @data 2023/7/1
 */
public class GetMin {
    public static void main(String[] args) {
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        TreeNode t20 = new TreeNode(20, t15, t7);

        TreeNode t5 = new TreeNode(5);
        TreeNode t9 = new TreeNode(9, t5, null);

        TreeNode node = new TreeNode(3, t9, t20);

        TreeNode root = new TreeNode(1, new TreeNode(0), new TreeNode(48, new TreeNode(12), new TreeNode(49)));

        System.out.println(getMinimumDifference(root));

    }

    public static int getMinimumDifference(TreeNode root) {
        method(root);
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < list.size() - 1; i++) {
            min = Math.min(min, Math.min(list.get(i) - list.get(i-1), list.get(i+1) - list.get(i)));
        }
        return min;
    }

    static ArrayList<Integer> list = new ArrayList<Integer>();
    public static void method(TreeNode root) {
        if (root == null) {
            return;
        }
        method(root.left);
        list.add(root.val);
        method(root.right);

    }


}
