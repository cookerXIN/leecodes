package com.liao.paperTest.elema0817;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/17
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        while (n > 0) {
            String t1 = in.next();
            String t2 = in.next();
            String t3 = in.next();



            if (transformed(t2) > add(t1) || transformed(t3) > add(t1)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

            n--;
        }
    }

    static int transformed(String s) {
        String[] split = s.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    static int add(String s) {
        String[] split = s.split(":");
        if (Integer.parseInt(split[0]) < 22) {
            return (Integer.parseInt(split[0]) + 2) * 60 + Integer.parseInt(split[1]);
        } else {
            return Integer.parseInt(split[1]);
        }
    }
}
