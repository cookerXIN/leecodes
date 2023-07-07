package com.liao.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguixin
 * @data 2023/7/7
 */
public class C3 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static List<String> resList = new ArrayList<>();

    static String[] charsList = {
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

    static StringBuilder sb = new StringBuilder();
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return resList;
        }

        method(digits, 0);
        return resList;
    }

    public static void method(String digits, int num) {
        if (num == digits.length()) {
            resList.add(sb.toString());
            return;
        }

        String s = charsList[digits.charAt(num) - '0'];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            method(digits, num + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
