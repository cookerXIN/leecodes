package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/10/12
 */
public class L79_2 {
    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean dfs = dfs(board, visited, word, 0, i, j, m, n);
                if (dfs) {
                    return true;
                }
            }
        }

        return false;
    }

    int[][] directs = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    public boolean dfs(char[][] board, boolean[][] visited, String word, int idx, int i, int j, int m, int n) {
        if (board[i][j] != word.charAt(idx)) {
            return false;
        } else if (idx == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean res = false;
        for (int[] direct : directs) {
            int newI = i + direct[0];
            int newJ = j + direct[1];

            if (newI >= 0 && newJ >= 0 && newI < m && newJ < n && !visited[newI][newJ]) {

                res = dfs(board, visited, word, idx+1, newI, newJ, m, n);
                if (res) {
                    break;
                }
            }
        }
        visited[i][j] = false;
        return res;
    }
}
