package com.liao.redo;

import java.util.Stack;

/**
 * @author liaoguixin
 * @date 2023/10/5
 */
public class L32 {
    public static void main(String[] args) {

    }

    public static int longestValidParentheses(String s) {
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
