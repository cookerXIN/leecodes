package com.liao.paperTest.baidu;

import java.util.*;
/**
 * @author liaoguixin
 * @date 2023/9/12
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t > 0) {
            int n = input.nextInt();
            int m = input.nextInt();

            boolean check = check(m, n);
            if (check) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            t--;
        }
    }

    static boolean check(int m, int n) {
        if (m == 1 && n == 1) {
            return false;
        }
        if (m == 1) {
            return (n - 1) % 2 == 1;
        }
        if (n == 1) {
            return (m - 1) % 2 == 1;
        }

        return ((n - 1) % 2 == 1 && (m - 1) % 2 == 0) || ((n - 1) % 2 == 0 && (m - 1) % 2 == 1) ;
    }
}
