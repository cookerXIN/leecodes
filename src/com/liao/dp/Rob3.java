package com.liao.dp;

import com.liao.binaryTree.TreeNode;

/**
 * @author liaoguixin
 * @data 2023/7/15
 */
public class Rob3 {
    public static void main(String[] args) {
        //输入: root = [3,2,3,null,3,null,1]
        //输出: 7
        //解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7

        TreeNode root = new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)));
        System.out.println(rob(root));
    }

    public static int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] method = method(root);
        return Math.max(method[0], method[1]);
    }

    public static int[] method(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            return res;
        }

        int[] left = method(root.left);
        int[] right = method(root.right);

        res[0] = Math.max(left[1], left[0]) + Math.max(right[1], right[0]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
