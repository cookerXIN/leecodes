package com.liao.paperTest.meituan0819;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/20
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int q = input.nextInt();

        while (q > 0) {

            int m = input.nextInt();
            int x = input.nextInt();

            int y = x % m == 0 ? m : x % m;
            System.out.println(y);

            q--;
        }
    }
}
