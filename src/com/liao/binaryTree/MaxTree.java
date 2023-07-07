package com.liao.binaryTree;

import java.lang.invoke.ConstantCallSite;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author liaoguixin
 * @data 2023/6/30
 */
public class MaxTree {
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};

        TreeNode treeNode = constructMaximumBinaryTree(nums);
    }


    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        method(nums, 0, nums.length);

        return new TreeNode();
    }

    public static TreeNode method(int[] nums, int begin, int end) {
        if (begin >= end) {
            return null;
        }
        int idx = begin;
        int max = nums[idx];
        for (int i = begin + 1; i < end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                idx = i;
            }
        }

        TreeNode node = new TreeNode(max);
        node.left = method(nums, begin, idx);
        node.right = method(nums, idx + 1, end);


        return node;
    }


}
