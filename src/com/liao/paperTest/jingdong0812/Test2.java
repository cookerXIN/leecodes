package com.liao.paperTest.jingdong0812;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/15
 */
public class Test2 {
    //小红有一个数组，她需要对数组操作 n-1次每次操作有两种选择:
    //1.选择数组的最后两个数，记x和y，将它们从数组中删除，然后将x+y的个位数放回数组的最后。
    //2.选择数组的最后两个数，记x和y，将它们从数组中删除，然后将x*y的个位数放回数组的最后。
    //例如，对于数组[1,2,3,4]，选择第一种操作后，数组变为1,2,7，选择第二种操作后，数组变为[1,4]。
    //小红一共操作了n-1次，显然操作后数组只剩下了一个数。小红想知道，这个数等于
    //0,1,...,9 的方案数分别为多少，答案可能很大，你只需要输出答案对 10e9+ 7 取模的结果
    //小红想知道，经过n-1次操作后，结果为0,1,...,9的方案数分别为多少，答案可能很大，你只需要输出答案对 10e9+7 取模的结果

    // 输入例子：
    // 4
    // 1 2 3 4
    // 输出结果:
    // 1 0 0 0 3 3 0 0 0 1
    // 0 0 0 1 0 0 0 0 0 0
    // 0 0 1 0 0 0 0 1 0 0
    // 0 0 0 0 3 0 0 0 0 1
    // 1 0 0 0 3 3 0 0 0 1
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        // 96的关键 可能第一个数是大于10
        if (n == 1) {
            if (nums[0] >= 10) {
                for (int i = 0; i < n; i++) {
                    System.out.print("0 ");
                }
            }
        }

        final int mod = 1000000007;

        int[][] dp = new int[n][10];
        dp[n-1][nums[n-1]%10] = 1;

        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                if (dp[i+1][j] != 0) {
                    int a = (j + nums[i]) % 10;
                    int b = (j * nums[i]) % 10;
                    // +dp[i][a] 是因为其他j情况 可能也会有出现a的情况 所以要将这个情况加进去
                    dp[i][a] = (dp[i+1][j] + dp[i][a]) % mod;
                    dp[i][b] = (dp[i+1][j] + dp[i][b]) % mod;
                }

            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(dp[0][i] + " ");
        }
    }
}
