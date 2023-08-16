package com.liao.paperTest.mihayou0813;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/16
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int x3 = in.nextInt();
        int y3 = in.nextInt();

        int res = cal(x1, x2, n) + cal(y1, y2, m) + cal(x2, x3, n) + cal(y2, y3, m);

        System.out.println(res);
    }

    static int cal(int x1, int x2, int n) {
        return Math.min(Math.abs(x1-x2), n-x2);
    }
}
