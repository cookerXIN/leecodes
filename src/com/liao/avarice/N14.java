package com.liao.avarice;

import com.liao.binaryTree.TreeNode;

/**
 * @author liaoguixin
 * @data 2023/7/11
 */
public class N14 {
    public static void main(String[] args) {
        //输入：[0,0,null,0,0]
        //输出：1
        //解释：如图所示，一台摄像头足以监控所有节点。
        TreeNode root = new TreeNode(0, new TreeNode(0, new TreeNode(0), new TreeNode(0)),null);
        System.out.println(minCameraCover(root));
    }

    static int res = 0;
    public static int minCameraCover(TreeNode root) {
        if (method(root) == 2) {
            return 1;
        }

        return res;
    }

    public static int method(TreeNode root) {
        if (root == null) {
            return 2;
        }

        int left = method(root.left);
        int right = method(root.right);

        if (left == 2 && right == 2) {
            return 2;
        } else if (left == 0 || right == 0) {
            res++;
            return 1;
        } else {
            return 2;
        }
    }

}
