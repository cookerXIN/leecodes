package com.liao.redo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/10/4
 */
public class L17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static List<String> resList = new ArrayList<>();
    static String[] nums = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    public static List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return resList;
        }

        dfs(digits, new StringBuilder(), n, 0);
        return resList;
    }

    public static void dfs(String digits, StringBuilder sb, int n, int idx) {
        if (idx == n) {
            resList.add(sb.toString());
            return;
        }

        String num = nums[digits.charAt(idx) - '0'];
        for (char c : num.toCharArray()) {
            sb.append(c);
            idx++;
            dfs(digits, sb, n, idx);
            idx--;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
