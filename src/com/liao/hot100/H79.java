package com.liao.hot100;

/**
 * @author liaoguixin
 * @date 2023/7/30
 */
public class H79 {
    public static void main(String[] args) {

    }

    static boolean[][] used;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] chars = word.toCharArray();
        int lenW = chars.length;

        used = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = match(board, chars, i, j, 0);
                if (flag) {
                    return true;
                }
            }
        }

        return false;
    }



    public static boolean match(char[][] board, char[] chars, int i, int j, int index) {
        if (board[i][j] != chars[index]) {
            return false;
        } else if (index == chars.length - 1) {
            return true;
        }

        used[i][j] = true;
        int[][] direct = {
                {0,1},
                {0,-1},
                {1,0},
                {-1,0}
        };
        boolean res = false;
        for (int[] dir : direct) {
            int newI = i + dir[0], newJ = j + dir[1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length) {
                if (!used[newI][newJ]) {
                    boolean flag = match(board, chars, newI, newJ, index + 1);
                    if (flag) {
                        res = true;
                        break;
                    }
                }
            }
        }

        used[i][j] = false;
        return res;
    }
}
