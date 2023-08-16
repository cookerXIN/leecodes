package com.liao.paperTest.meituan0812;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/14
 */
public class Test3 {
    //小美有一个矩形的蛋糕，共分成了n行m 列，共n*m个区域，每个区域是一个小正方形，已知蛋糕每个区域都有一个美味度。她想切一刀把蛋糕切成两部分，自己吃一部分，小团吃另一部分。
    //小美希望两个人吃的部分的美味度之和尽可能接近，请你输出|s1-s2|的最小值。（其中s1代表小美吃的美味度，s2代表小团吃的美味度）。
    //请务必保证，切下来的区域都是完整的，即不能把某个小正方形切成两个小区域。
    //输入描述
    //第一行输出两个正整数n和m，代表蛋糕区域的行数和列数。
    //接下来的n行，每行输入m个正整数aij，用来表示每个区域的美味度
    //输出描述
    //一个整数，代表|s1-s2|的最小值

    // 输入例子：
    // 2 3
    // 1 1 4
    // 5 1 4
    // 输出结果：
    // 0

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] arr = new int[n+1][m+1];
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = in.nextInt();
                sum += arr[i][j];
            }
        }

        // 求前缀和         0 0 0 0
        // 1 1 4    ->    0 1 2 6
        // 5 1 4          0 6 8 16
        // 此时前缀和矩阵的最后一列 最后一行 则为从当前列/行开始前面的数的和
        // 二维前缀和
        // https://blog.csdn.net/justidle/article/details/103754960
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = arr[i][j-1] + arr[i-1][j] - arr[i-1][j-1] + arr[i][j];
            }
        }

        // 我们要求的
        // min = x - y (x > y) -> y = x - min, x + y = sum -> 2x - min = sum -> min = 2x - sum
        // min = y - x (x <= y) -> y = x + min, x + y = sum -> 2x + min = sum -> min = sum - 2x
        // min = |sum - 2x|
        // 则我们只遍历当前列/行，将其当前列/行前面全部数的和当成x，求出最小的|sum - 2x|，则为所求
        long ans = sum;
        for(int j =1; j<=m; j++){
            ans = Math.min(ans,Math.abs(sum - 2*arr[n][j]));
        }

        for(int i=1; i<=n; i++){
            ans = Math.min(ans,Math.abs(sum-2*arr[i][m]));
        }

        System.out.println(ans);
    }

}
