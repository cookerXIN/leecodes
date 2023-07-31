package com.liao.hot100;

import java.util.Arrays;

/**
 * @author liaoguixin
 * @date 2023/7/30
 */
public class H48 {
    public static void main(String[] args) {

        int[][] matrix = {
                {5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7},{15,14,12,16}
        };

        rotate1(matrix);
        System.out.println(Arrays.deepToString(matrix));
        rotate1(matrix);
        rotate(matrix);
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotate(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int index = m / 2;
        int loop = 0;
        int tmp;
        while (loop < index) {
            for (int j = n-1-loop; j >= loop; j--) {
                tmp = matrix[loop][j];
                matrix[loop][j] = matrix[j][n-1-loop];
                matrix[j][n-1-loop] = tmp;
            }

            for (int j = loop; j < n - 1 - loop; j++) {
                tmp = matrix[j][loop];
                matrix[j][loop] = matrix[m-1-loop][j];
                matrix[m-1-loop][j] = tmp;
            }

            int left = loop + 1, right = n-2 - loop;
            while (left <= right) {
                if (left == right) {
                    tmp = matrix[loop][left];
                    matrix[loop][left] = matrix[m-1-loop][right];
                    matrix[m-1-loop][right] = tmp;
                } else {
                    tmp = matrix[loop][left];
                    matrix[loop][left] = matrix[m-1-loop][right];
                    matrix[m-1-loop][right] = tmp;

                    tmp = matrix[loop][right];
                    matrix[loop][right] = matrix[m-1-loop][left];
                    matrix[m-1-loop][left] = tmp;
                }
                left++;
                right--;
            }
            loop++;
        }
    }

    public static void rotate1(int[][] matrix) {
        int n = matrix.length;
        int tmp;
        for (int i = 0; i < n / 2; i++) {
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
