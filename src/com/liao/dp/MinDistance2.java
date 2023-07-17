package com.liao.dp;

/**
 * @author liaoguixin
 * @date 2023/7/17
 */
public class MinDistance2 {
    public static void main(String[] args) {
        //输入：word1 = "horse", word2 = "ros"
        //输出：3
        //解释：
        //horse -> rorse (将 'h' 替换为 'r')
        //rorse -> rose (删除 'r')
        //rose -> ros (删除 'e')

        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        int n1 = chars1.length;
        int n2 = chars2.length;

        int[][] dp = new int[n1+1][n2+1];

        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (chars1[i-1] == chars2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1), dp[i-1][j-1] + 1);
                }
            }
        }

        return dp[n1][n2];
    }
}
