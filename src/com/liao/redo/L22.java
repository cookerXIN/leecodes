package com.liao.redo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/8/16
 */
public class L22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }


    public static List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0);
        return list;
    }

    static List<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void backtrack(int n, int left, int right) {
        if (n == left && n == right) {
            String s = sb.toString();
            list.add(s);
        }

        if (left < n) {
            sb.append("(");
            left++;
            backtrack(n, left, right);
            left--;
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) {
            sb.append(")");
            right++;
            backtrack(n, left, right);
            right--;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
