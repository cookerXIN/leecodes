package com.liao.binaryTree;

/**
 * @author liaoguixin
 * @date 2023/6/29
 * @apiNote
 */
public class HasPathSum {
    public static void main(String[] args) {
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        TreeNode t20 = new TreeNode(20, t15, t7);

        TreeNode t5 = new TreeNode(5);
        TreeNode t9 = new TreeNode(9, t5, null);

        TreeNode node = new TreeNode(3, t9, t20);

        System.out.println(hasPathSum(node, 16));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null || targetSum < 0) {
            return false;
        }

        return method(root, targetSum);
    }
    private static int res = 0;
    public static boolean method(TreeNode root, int target) {
        res += root.val;

        if (root.left == null && root.right == null) {
            if (res != target) {
                return false;
            } else {
                return true;
            }
        }

        if (root.left != null) {
            boolean lr = method(root.left, target);
            if (lr) {
                return lr;
            }
            res -= root.left.val;
        }

        if (root.right != null) {
            boolean lr = method(root.right, target);
            if (lr) {
                return lr;
            }
            res -= root.right.val;
        }

        return false;
    }


}
