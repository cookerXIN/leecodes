package com.liao.redo;

import java.util.Arrays;

/**
 * @author liaoguixin
 * @date 2023/9/5
 */
public class L130 {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}
        };
        solve(board);
        Arrays.stream(board).forEach(b->System.out.println(b));
    }

    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n-1] == 'O') {
                dfs(board, i, n-1);
            }
        }

        for (int j = 1; j < n-1; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m-1][j] == 'O') {
                dfs(board, m-1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    static int[][] directs = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    static void dfs(char[][] board, int i, int j) {
        if (board[i][j] != 'O') {
            return;
        }

        board[i][j] = '1';

        for (int[] direct : directs) {
            int newI = i + direct[0];
            int newJ = j + direct[1];
            if (newI < 0 || newJ < 0 || newI >= board.length || newJ >= board[0].length) {
                continue;
            }

            dfs(board, newI, newJ);
        }
    }
}
