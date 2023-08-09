package com.liao.hot100;

import com.liao.binaryTree.TreeNode;

/**
 * @author liaoguixin
 * @date 2023/8/9
 */
public class H437 {
    public static void main(String[] args) {

    }

    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = backtrack(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    public static int backtrack(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        if (root.val == targetSum) {
            res++;
        }

        res += backtrack(root.left, targetSum - root.val);
        res += backtrack(root.right, targetSum - root.val);

        return res;
    }
}
