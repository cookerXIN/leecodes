package com.liao.redo;

import com.liao.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/10/16
 */
public class L94 {
    public static void main(String[] args) {

    }

    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        res.add(node.val);
        dfs(node.right);
    }
}
