package com.liao.hot100;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author liaoguixin
 * @date 2023/8/5
 */
public class H394 {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }


    static int idx = 0;
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (idx < s.length()) {

            char c = s.charAt(idx);
            if (c >= '0' && c <= '9') {
                count = 0;
                int cur = 0;
                while (c >= '0' && c <= '9') {
                    cur = c - '0';
                    count = count * 10 + cur;
                    idx++;
                    c = s.charAt(idx);
                }
            } else if (c == '[') {
                idx++;

                String s1 = decodeString(s);

                for (int i = 0; i < count; i++) {
                    sb.append(s1);
                }
                continue;
            } else if (s.charAt(idx) == ']') {
                idx++;
                return sb.toString();
            } else {
                sb.append(c);
                idx++;
            }

        }

        return sb.toString();
    }

    public String decodeString1(String s) {
        LinkedList<String> stack = new LinkedList<String>();

        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (Character.isDigit(c)) {
                String digit = getDigits(s);
                stack.addLast(digit);
            } else if (c == '[' || Character.isLetter(c)) {
                stack.addLast(String.valueOf(c));
                idx++;
            } else {
                idx++;
                LinkedList<String> list = new LinkedList<String>();
                while (!"[".equals(stack.peekLast())) {
                    list.addLast(stack.pollLast());
                }
                Collections.reverse(list);
                stack.pollLast();

                int count = Integer.parseInt(stack.pollLast());
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    for (String s1 : list) {
                        sb.append(s1);
                    }
                }
                stack.addLast(sb.toString());
            }
        }

        StringBuilder res = new StringBuilder();
        for (String s1 : stack) {
            res.append(s1);
        }
        return res.toString();
    }

    public String getDigits(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(idx))) {
            sb.append(s.charAt(idx++));
        }

        return sb.toString();
    }
}
