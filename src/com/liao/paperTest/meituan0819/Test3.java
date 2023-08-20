package com.liao.paperTest.meituan0819;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/20
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();

        int len = str.length();
        int res = 0;
        for (int i = 2; i < len; i++) {
            for (int j = 0; j < len - i + 1; j++) {
                String substring = str.substring(j, j + i);
                res += calValue(substring);
            }
        }

        System.out.println(res);
    }

    static int calValue(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i-1]) {
                chars[i] = chars[i-1] == '0' ? '1' : '0';
                count++;
            }
        }


        return count;
    }


}
