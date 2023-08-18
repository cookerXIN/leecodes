package com.liao.paperTest.meituan0812;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/14
 */
public class Test2 {
    //有一个环形的公路，上面共有n站，现在给定了顺时针第i站到第i+1站之间的距离（特殊的，也给出了第n站到第1站的距离）。小美想沿着公路第x站走到第y站，她想知道最短的距离是多少？
    //输入描述
    //第一行输入一个正整数n，代表站的数量。
    //第二行输入n个正整数ai，前n-1个数代表顺时针沿着公路走，i站到第i+1站之间的距离；
    //最后一个正整数代表顺时针沿着公路走，第n站到第1站的距离。
    //第三行输入两个正整数x和y，代表小美的出发地和目的地。
    //输出描述
    //一个正整数，代表小美走的最短距离。
    //

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int x = in.nextInt();
        int y = in.nextInt();

        if (x == y) {
            System.out.println(0);
            return;
        } else if (x > y) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        long left = 0;
        for (int i = x-1; i < y-1; i++) {
            left += nums[i];
        }
        long right = 0;
        for (int i = y-1; i < n; i++) {
            right += nums[i];
        }
        for (int i = 0; i < x-1; i++) {
            right += nums[i];
        }

        long min = Math.min(left, right);
        System.out.println(min);
    }
}
