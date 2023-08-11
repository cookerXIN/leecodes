package com.liao.redo;

import java.util.Stack;

/**
 * @author liaoguixin
 * @date 2023/8/11
 */
public class L20 {
    public static void main(String[] args) {
        System.out.println(isValid("(]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop != s.charAt(i)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
