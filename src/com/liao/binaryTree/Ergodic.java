package com.liao.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liaoguixin
 * @date 2023/6/27
 * @apiNote
 */
public class Ergodic {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        //List<Integer> result = new ArrayList<>();
        //inorder(t, result);
        //System.out.println(result);
        List<List<Integer>> hierorder = hierorder(t);
        System.out.println(hierorder);

    }

    public static void preorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        // 根据遍历顺序将节点的值添加到result的逻辑放在要添加的地方，其代表根/中节点添加
        result.add(node.val);
        preorder(node.left, result);
        preorder(node.right, result);
    }

    public static void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    public static void postorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.val);
    }

    public static List<List<Integer>> hierorder(TreeNode node)  {
        List<List<Integer>> result = new ArrayList<>();

        if (node == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int size = queue.size();

            while (size > 0) {
                TreeNode cur = queue.poll();
                itemList.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;
            }

            result.add(itemList);
        }

        return result;
    }
}
