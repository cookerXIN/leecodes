package com.liao.paperTest.elema0817;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author liaoguixin
 * @date 2023/8/17
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.next();
        Set<Character> set = new HashSet<>();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            set.add(str.charAt(i));
        }

        Set<Character> have = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            for (Character ch : set) {
                if (!ch.equals(str.charAt(i)) && (!have.contains(ch) || have.size() == set.size())) {
                    sb.append(ch);
                    have.add(ch);
                    break;
                }
            }
        }

        if (sb.length() < len) {
            System.out.println(-1);
        } else {
            System.out.println(sb.toString());
        }
    }
}
