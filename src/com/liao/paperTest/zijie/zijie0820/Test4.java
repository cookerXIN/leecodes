package com.liao.paperTest.zijie.zijie0820;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/21
 */
public class Test4 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String str = input.next();
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                String substring = str.substring(j, j + i);
                res += cal(substring);
            }
        }

        System.out.println(res);
    }

    static int cal(String substring) {
        int len = substring.length();
        char pre = substring.charAt(0);
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (pre != substring.charAt(i)) {
                count++;
            }
            pre = substring.charAt(i);
        }
        return count;
    }
}
