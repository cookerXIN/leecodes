package com.liao.paperTest.zijie.zijie0512;

/**
 * @author liaoguixin
 * @date 2023/8/19
 */
public class Test1 {
    public static void main(String[] args) {
        // 5 5
        //    .....
        //    ..RRD
        //    .U.DR
        //    .ULL.
        //    ....O

        char[][] chars = {
                {'.','.','.','.','.'},
                {'.','.','R','R','D'},
                {'.','U','.','D','R'},
                {'.','U','L','L','.'},
                {'.','.','.','.','0'},
        };
        int m = 5;
        int n = 5;


        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean[][] visited = new boolean[n][m];
                boolean dfs = dfs(5, 5, i, j, chars, visited);
                if (!dfs) {
                    res++;
                }
            }
        }

        System.out.println(res);


    }

    static boolean dfs(int n, int m, int i, int j, char[][] chars, boolean[][] visited) {
        if (chars[i][j] == '0') {
            return true;
        }

        while (chars[i][j] != '.' && !visited[i][j]) {
            visited[i][j] = true;

            if (chars[i][j] == 'U') {
                i = i - 1;
            } else if (chars[i][j] == 'D') {
                i = i + 1;
            } else if (chars[i][j] == 'R') {
                j = j + 1;
            } else if (chars[i][j] == 'L') {
                j = j - 1;
            }

            if (i < 0 || j < 0 || i >= n || j >= m) {
                return false;
            }
        }

        if (visited[i][j]) {
            return false;
        }

        int[][] directs = {
                {0,1},
                {0,-1},
                {1,0},
                {-1,0},
        };

        visited[i][j] = true;

        boolean res = false;

        for (int[] direct : directs) {
            int newI = i + direct[0];
            int newJ = j + direct[1];

            if (newI >= 0 && newJ >= 0 && newI < n && newJ < m) {
                if (chars[newI][newJ] == 'U') {
                    newI = newI - 1;
                }
                boolean flag = dfs(n, m, newI, newJ, chars, visited);
                if (flag) {
                    return true;
                }
            }
        }

        return res;
    }
}
