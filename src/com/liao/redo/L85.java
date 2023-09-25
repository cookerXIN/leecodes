package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/9/22
 */
public class L85 {
    public static void main(String[] args) {
        char[][] chars = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(chars));
    }

    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];

        // 先按照每一行去取当前行的最大矩形
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j-1]) + 1;
                }
            }
        }

        // 再去按每一列的最小宽度与当前满足的高度求最大矩形
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }

                int width = left[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, (i - k + 1) * width);
                }

                res = Math.max(res, area);
            }
        }

        return res;
    }
}
