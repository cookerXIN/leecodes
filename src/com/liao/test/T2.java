package com.liao.test;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/9/28
 */
public class T2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(cal(n));
    }
    static int cal(int n) {
        return dfs(n,0,0,0,0);
    }

    static int dfs(int n,int x, int c, int d1, int d2) {
        if (x == n) {
            return 1;
        } else {
            int res = 0;
            int tmp = ((1 << n) - 1) & (~(c | d1 | d2));
            while (tmp != 0) {
                int idx = tmp & (-tmp);
                tmp = tmp & (tmp - 1);
                res += dfs(n, x+1, c | idx, (d1 | idx) << 1, (d2 | idx) >> 1);
            }
            return res;
        }
    }
}
