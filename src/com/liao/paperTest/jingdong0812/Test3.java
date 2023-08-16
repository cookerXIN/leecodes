package com.liao.paperTest.jingdong0812;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/15
 */
public class Test3 {
    //小红有一个大小为nxm的棋盘，表示这个格子没有棋子，X表示这个格子有棋子。
    //第i行第j列的格子可以用一个坐标(i,j)表示。
    //小红想选出四个棋子，对应坐标分别为
    //(x1,y1),(x2,y2),(x3,y3),(x4,y4)，使得这四个坐标构成一个正方形，小红有多少种方案。
    //如果两个方案有任意一个棋子的坐标不同，那么就认为是两种不同的方案。
    //输入描述
    //第一行一个正整数n,m，代表棋盘的大小。接下来n行，每行一个长度为 m的字符串，仅包含.和'X'。
    //输出描述
    //一个整数，代表最终的方案数

    // 输入例子:
    // 4 4
    // XX..
    // XXX.
    // .X.X
    // ..X.
    // 输出结果:
    // 3

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = in.next();
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (strs[i].charAt(j) == 'X') {
                    int count = countAll(strs, n, m, i, j);
                    res += count;
                }
            }
        }

        System.out.println(res);
    }

    public static int countAll(String[] strs, int n, int m, int i, int j) {
        int count = 0;
        // 枚举两种情况
        for (int k = 1; k < strs.length; k++) {
            if (i+k < n && j+k < m && strs[i+k].charAt(j) == 'X' && strs[i].charAt(j+k) == 'X' && strs[i+k].charAt(j+k) == 'X') {
                count++;
            }
            if (i+k < n && j+k < m && i+2*k < n && j-k >= 0 && strs[i+k].charAt(j+k) == 'X' && strs[i+k].charAt(j-k) == 'X' && strs[i+2*k].charAt(j) == 'X') {
                count++;
            }
        }

        return count;
    }
}
