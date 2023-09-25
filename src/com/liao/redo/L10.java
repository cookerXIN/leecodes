package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/9/22
 */
public class L10 {
    public static void main(String[] args) {

    }

    public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();

        boolean[][] dp = new boolean[lenS+1][lenP+1];
        dp[0][0] = true;

        for (int i = 0; i <= lenS; i++) {
            for (int j = 1; j <= lenP; j++) {
                if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2];
                    if (matches(s, p, i, j-1)) {
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }

        return dp[lenS][lenP];
    }

    boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j-1) == '.') {
            return true;
        }

        return s.charAt(i-1) == p.charAt(j-1);
    }
}
