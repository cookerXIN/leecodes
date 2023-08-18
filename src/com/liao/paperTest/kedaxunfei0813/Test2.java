package com.liao.paperTest.kedaxunfei0813;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/18
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String str = in.next();

        for (int i = 1; i < n; i++) {
            int cur = str.charAt(i) - str.charAt(i - 1);
            k -= cur;
            if (k < 0) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(k);
    }
}
