package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/10/5
 */
public class L48 {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3}, {4, 5, 6}, {7,8,9}
        };
        rotate(nums);
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int tmp;

        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
