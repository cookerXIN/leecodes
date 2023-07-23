package com.liao.test;

import com.liao.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liaoguixin
 * @date 2023/7/21
 */
public class A1 {
    public static void main(String[] args) {
        //Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        //Output: [3,9,20,null,null,15,7]

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        System.out.println(buildTree(preorder, inorder));

    }

    static Map<Integer, Integer> inorderMap = new HashMap<>();
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        TreeNode method = method(preorder, 0, 0, preorder.length - 1);
        return method;
    }

    public static TreeNode method(int[] preorder, int preorderMid, int start, int end) {
       if (start > end) {
           return null;
       }

       TreeNode root = new TreeNode(preorder[preorderMid]);
       int inorderMid = inorderMap.get(preorder[preorderMid]);

       root.left = method(preorder, preorderMid+1, start, inorderMid-1);
       root.right = method(preorder, preorderMid + inorderMid - start + 1, inorderMid+1, end);

       return root;
    }


}
