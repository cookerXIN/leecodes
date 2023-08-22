package com.liao.redo;

import com.liao.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/8/22
 */
public class L102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),new TreeNode(3));
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> item = new ArrayList<>();

            while (size > 0) {
                TreeNode poll = deque.poll();
                item.add(poll.val);
                if (poll.left != null) {
                    deque.offerLast(poll.left);
                }
                if (poll.right != null) {
                    deque.offerLast(poll.right);
                }
                size--;
            }

            list.add(item);
        }

        return list;
    }
}
