package com.liao.dp;

/**
 * @author liaoguixin
 * @data 2023/7/13
 */
public class FindMaxForm {
    public static void main(String[] args) {
        //输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
        //输出：4
        //解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
        //其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。

        String[] strs = {"10", "0001", "111001", "1", "0"};

        System.out.println(findMaxForm(strs, 5, 3));

    }

    public static int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m+1][n+1];

        for (String str : strs) {
            char[] chars = str.toCharArray();
            int zeros = 0;
            int ones = 0;
            for (char aChar : chars) {
                if (aChar == '0') {
                    zeros += 1;
                } else {
                    ones += 1;
                }
            }


            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-zeros][k-ones] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
