package com.liao.redo;

import com.liao.binaryTree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/9/26
 */
public class L297 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return firstSerial(root, "");
        }

        public String firstSerial(TreeNode root, String str) {
            if (root == null) {
                str += "None,";
            } else {
                str += String.valueOf(root.val) + ",";
                firstSerial(root.left, str);
                firstSerial(root.right, str);
            }

            return str;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] split = data.split(",");
            List<String> dataList = new LinkedList<String>(Arrays.asList(split));
            return firstDeSerial(dataList);
        }

        public TreeNode firstDeSerial(List<String> dataList) {
            if (dataList.get(0).equals("None")) {
                dataList.remove(0);
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
            dataList.remove(0);
            root.left = firstDeSerial(dataList);
            root.right = firstDeSerial(dataList);

            return root;
        }
    }
}
