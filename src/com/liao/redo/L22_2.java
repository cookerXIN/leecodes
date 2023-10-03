package com.liao.redo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/9/25
 */
public class L22_2 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        dfs(new StringBuilder(), 0, 0, n);
        return res;
    }

    static List<String> res = new ArrayList<>();

    static void dfs(StringBuilder sb, int left, int right, int n) {
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append("(");
            left++;
            dfs(sb, left, right, n);
            sb.deleteCharAt(sb.length() - 1);
            left--;
        }

        if (right < left) {
            sb.append(")");
            right++;
            dfs(sb, left, right, n);
            sb.deleteCharAt(sb.length() - 1);
            right--;
        }
    }
}
