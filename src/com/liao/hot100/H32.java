package com.liao.hot100;

import java.util.Stack;

/**
 * @author liaoguixin
 * @date 2023/8/2
 */
public class H32 {
    public static void main(String[] args) {

    }

    public static int longestValidParentheses(String s) {
        int n = s.length();
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
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
