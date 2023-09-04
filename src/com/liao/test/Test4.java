package com.liao.test;

import java.util.Scanner;
import java.util.SortedMap;

/**
 * @author liaoguixin
 * @date 2023/8/29
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String[] s = input.nextLine().split(" ");
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (left <= right) {
                left += Integer.parseInt(s[i]);
            } else {
                right += Integer.parseInt(s[i]);
            }
        }

        System.out.println(Math.max(left,right));
    }
}
