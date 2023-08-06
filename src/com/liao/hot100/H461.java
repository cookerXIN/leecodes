package com.liao.hot100;

/**
 * @author liaoguixin
 * @date 2023/8/6
 */
public class H461 {
    public static void main(String[] args) {
        bit(7);
    }

    public static int hammingDistance(int x, int y) {
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        char[] bitX = bit(x);
        char[] bitY = bit(y);
        int idx = 0;

        char Xc;
        char Yc;
        int res = 0;
        while (idx < bitX.length) {
            if (idx < bitY.length) {
              Yc = bitY[idx];
            } else {
                Yc = '0';
            }
            Xc = bitX[idx];
            if (Xc != Yc) {
                res++;
            }
            idx++;
        }

        return res;
    }

    public static char[] bit(int val) {
        int cur = 1;
        while (cur * 2 <= val) {
            cur *= 2;
        }

        StringBuilder sb = new StringBuilder();
        while (cur > 0) {
            if (val >= cur) {
                val -= cur;
                sb.append(1);
            } else {
                sb.append(0);
            }
            cur /= 2;
        }
        char[] chars = sb.reverse().toString().toCharArray();

        return chars;
    }
}
