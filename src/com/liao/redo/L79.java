package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/8/17
 */
public class L79 {
    public static void main(String[] args) {

    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = dfs(board, word, 0, i, j, used);
                if (flag) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean dfs(char[][] board, String word, int idx, int i, int j, boolean[][] used) {
        if (board[i][j] != word.charAt(idx)) {
            return false;
        } else if (idx == word.length() - 1) {
            return true;
        }

        used[i][j] = true;

        int[][] direct = {
                {0,1},
                {1,0},
                {0,-1},
                {-1,0}
        };

        boolean res = false;
        for (int[] ints : direct) {
            int newI = i + ints[0];
            int newJ = j + ints[1];

            if (newI >= 0 && newJ >= 0 && newI < board.length && newJ < board[0].length) {
                if (!used[newI][newJ]) {
                    boolean flag = dfs(board, word, idx++, newI, newJ, used);
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
