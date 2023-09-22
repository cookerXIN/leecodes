package com.liao.redo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/9/21
 */
public class L301 {
    public static void main(String[] args) {

    }

    public static List<String> removeInvalidParentheses(String s) {
        int leftCount = 0;
        int rightCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (s.charAt(i) == ')') {
                if (leftCount > 0) {
                    leftCount--;
                } else {
                    rightCount++;
                }
            }
        }

        dfs(s, 0, leftCount, rightCount);
        return res;
    }

    static List<String> res = new ArrayList<String>();

    public static void dfs(String s, int start, int leftCount, int rightCount) {
        if (leftCount == 0 && rightCount == 0) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i) == s.charAt(i-1)) {
                continue;
            }

            if (leftCount + rightCount > s.length() - i) {
                return;
            }

            if (leftCount > 0 && s.charAt(i) == '(') {
                dfs(s.substring(0,i) + s.substring(i+1), i, leftCount-1, rightCount);
            }
            if (rightCount > 0 && s.charAt(i) == ')') {
                dfs(s.substring(0,i) + s.substring(i+1), i, leftCount, rightCount-1);
            }
        }
    }

    static boolean isValid(String s) {
        int leftCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (s.charAt(i) == ')') {
                leftCount--;
                if (leftCount < 0) {
                    return false;
                }
            }
        }

        return leftCount == 0;
    }
}
