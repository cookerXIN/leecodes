package com.liao.binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liaoguixin
 * @date 2023/6/29
 * @apiNote
 */
public class BuildTree {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7}, postorder = {9,15,7,20,3};
        buildTree(inorder, postorder);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return new TreeNode();
        }
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return method(inorder, postorder, 0, inorder.length, 0, postorder.length, inMap);

    }


    public static TreeNode method(int[] inorder, int[] postorder, int leftIn, int rightIn, int leftPost, int rightPost, Map<Integer, Integer> inMap) {
        if (leftIn >= rightIn || leftPost >= rightPost) {
            return null;
        }

        int rootIndex = inMap.get(postorder[rightPost - 1]);
        TreeNode node = new TreeNode(inorder[rootIndex]);
        int leftNum = rootIndex - leftIn;

        node.left = method(inorder, postorder, leftIn, rootIndex, leftPost, leftPost + leftNum, inMap);
        node.right = method(inorder, postorder, rootIndex+1, rightIn, leftPost+leftNum, rightPost-1, inMap);

        return node;
    }
}
