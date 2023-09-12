package com.liao.paperTest.zijie;

import com.liao.binaryTree.TreeNode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/9/10
 */
public class Test1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(0);


        int result = countSpecialPaths(root);
        System.out.println(result);
    }

    static int countSpecialPaths(TreeNode root) {
        return dfs(root, 0, 0);
    }

    static int dfs(TreeNode node, int zeros, int ones) {
        if (node == null) {
            return 0;
        }
        if (node.val == 0) {
            zeros++;
        } else {
            ones++;
        }
        if (node.left == null && node.right == null) {
            if (ones - zeros == 1) {
                return 1;
            }
            return 0;
        }
        return dfs(node.left, zeros, ones) + dfs(node.right, zeros, ones);
    }

    /**
     * @author liaoguixin
     * @date 2023/9/10
     */
    public static class Test3 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            Arrays.sort(a);
            long res = a[n-1];
            int i = 0;
            for (; i < ((n-1) / 2); i++) {
                res += a[n-1-i] - a[i];
            }
            System.out.println(res);
        }
    }
}
