package com.liao.redo;

import com.liao.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liaoguixin
 * @date 2023/9/1
 */
public class L105 {
    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        System.out.println(buildTree(pre, in));
    }

    static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    static TreeNode dfs(int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd) {
        if (inBegin >= inEnd || preBegin >= preEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preBegin]);

        Integer idx = map.get(preorder[preBegin]);
        int leftLen = idx - inBegin;
        root.left = dfs(preorder, inorder, preBegin+1, preBegin+1+leftLen, inBegin, idx);
        root.right = dfs(preorder, inorder, preBegin + 1+leftLen, preEnd, idx+1, inEnd);

        return root;
    }
}
