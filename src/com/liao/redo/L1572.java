package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/8/25
 */
public class L1572 {
    public static void main(String[] args) {

    }

    public static int diagonalSum(int[][] mat) {
        int len = mat.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j || i + j == len - 1) {
                    res += mat[i][j];
                }
            }
        }

        return res;
    }
}
