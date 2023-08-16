package com.liao.paperTest.meituan0812;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/14
 */
public class Test4 {

    //小美拿到了一个长度为n的字符串，她希望将字符串从左到右平铺成一个矩阵（先平铺第一行，然后是第二行，以此类推，矩阵有x行y列，必须保证x*y=n，即每y个字符换行，共x行）。
    //该矩阵的权值定义为这个矩阵的连通块数量。小美希望最终矩阵的权值尽可能小，你能帮小美求出这个最小权值吗？
    //注：我们定义，上下左右四个方向相邻的相同字符是连通的。
    //输入描述
    //第一行输入一个正整数n，代表字符串的长度。
    //第二行输入一个长度为n的、仅由小写字母组成的字符串。
    //1<=n<=10^4
    //输出描述
    //输出一个整数表示最小权值

    // 输入例子：
    // 9
    // aababbabb
    // 输出结果：
    // 2

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();

        int res = Integer.MAX_VALUE;

        // 枚举所有矩阵的可能情况
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                int x = i, y = n / i;
                int cal = cal(x, y, str.toCharArray());
                res = Math.min(cal, res);
            }
        }
        System.out.println(res);

    }
    static boolean[] visited;
    static int cal(int x, int y, char[] chars) {
        visited = new boolean[x*y];
        int count = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!visited[i*y + j]) {
                    // 每次遍历完一个连通区域+1
                    dfs(i,j,x,y,chars);
                    count++;
                }
            }
        }

        return count;
    }

    static void dfs(int i, int j, int x, int y, char[] chars) {
        int idx = i * y + j;
        visited[idx] = true;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 遍历此时矩阵当前位置上下左右相同字符的位置将其标记
        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newI >= 0 && newI < x && newJ >= 0 && newJ < y && !visited[newI*y + newJ] && chars[newI*y + newJ] == chars[idx]) {
                dfs(newI, newJ, x, y, chars);
            }
        }
    }
}
