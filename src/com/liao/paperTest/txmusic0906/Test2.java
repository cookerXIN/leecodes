package com.liao.paperTest.txmusic0906;

import java.util.Arrays;

/**
 * @author liaoguixin
 * @date 2023/9/8
 */
public class Test2 {
    public static void main(String[] args) {
        for (int i = 0; i < memory.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        for (int m = 0; m < 8; m++) {
                            memory[i][j][k][l][m] = -1;
                        }
                    }
                }
            }
        }

        System.out.println(helper(0, 0, 0, 0, 0, 5));
    }

    static long mod = 1000000007;
    static long[][][][][] memory = new long[100005][2][2][2][8];

    static long helper(int i, int r, int e, int d, int f, int n) {
        if (i >= n) return d;
        if (memory[i][r][e][d][f] != -1) {
            return memory[i][r][e][d][f];
        }

        long res = 0;
        res = (res + helper(i+1, 1, e, d, 1, n)) % mod;

        int newF = 2;
        if (f == 1) {
            newF = 3;
        }
        res = (res + helper(i+1, r, r, d, newF, n)) % mod;

        if (f != 3) {
            int newD = r&e;
            res = (res + helper(i+1, r, e, newD,4, n)) % mod;
        }

        return res;
    }

}
