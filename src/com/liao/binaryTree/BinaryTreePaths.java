package com.liao.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author liaoguixin
 * @date 2023/6/27
 * @apiNote
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        TreeNode t20 = new TreeNode(20, t15, t7);

        TreeNode t5 = new TreeNode(5);
        TreeNode t9 = new TreeNode(9, t5, null);

        TreeNode node = new TreeNode(3, t9, t20);


        System.out.println(method(node));
    }

    public static List<String> method(TreeNode root) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        md(root, new ArrayList<>());
        return res;
    }

    static List<String> res = new ArrayList<>();
    public static void md(TreeNode root, List<Integer> item) {
        item.add(root.val);

        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < item.size() - 1; i++) {
                sb.append(item.get(i));
                sb.append("->");
            }
            sb.append((item.get(item.size() - 1)));
            res.add(sb.toString());
            return;
        }

        if (root.left != null) {
            md(root.left, item);
            item.remove(item.size()-1);
        }

        if (root.right != null) {
            md(root.right, item);
            item.remove(item.size() - 1);
        }

    }
}
