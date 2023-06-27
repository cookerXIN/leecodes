package com.liao.binaryTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/6/27
 * @apiNote
 */
public class NMax {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static void main(String[] args) {
        Node r5 = new Node(5);
        Node r6 = new Node(6);
        List<Node> l1 = new ArrayList<>();
        Collections.addAll(l1, r5, r6);
        Node r3 = new Node(3, l1);
        Node r2 = new Node(2);
        Node r4 = new Node(4);
        List<Node> l2 = new ArrayList<>();
        Collections.addAll(l2, r3, r2, r4);
        Node root = new Node(1, l2);
        method(root, 0);
    }

    public static int method (Node root, int res) {
        if (root == null) {
            return res;
        }

        res++;

        List<Node> children = root.children;
        if (children == null) {
            return res;
        }
        int maxVal = 0;
        for (int i = 0; i < children.size(); i++) {
            int curVal = method(children.get(i), res);
            maxVal = maxVal > curVal ? maxVal : curVal;
        }


        return maxVal;
    }
}
