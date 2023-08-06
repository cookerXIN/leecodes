package com.liao.hot100;

import java.util.Arrays;

/**
 * @author liaoguixin
 * @date 2023/8/5
 */
public class H338 {
    public static void main(String[] args) {
        System.out.println(4&1);
        //System.out.println(bit(5));
    }

    public static int[] countBits(int n) {
        int[] res = new int[n+1];
        if (n == 0) {
            return res;
        }

        for (int i = 1; i <= n; i++) {
            res[i] = bit(i);
        }


        return res;
    }

    public static int bit(int n) {
        int count = 0;

        int cur = 1;
        while (cur * 2 <= n) {
            cur *= 2;
        }

        while (n > 0) {
            if (n >= cur) {
                n -= cur;
                count++;
            }
            cur /= 2;
        }

        return count;
    }
}
