package com.liao.paperTest.meituan0812;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/14
 */
public class Test1 {
    //小美拿到了一个排列。她想知道在这个排列中，x和y是否是相邻的。你能帮帮她吗？
    //排列是指一个长度为n的数组，其中 1 到n 每个元素恰好出现一次。
    //输入描述
    //第一行输入一个正整数n，代表排列的长度。
    //第二行输入n个正整数ai，代表排列的元素。
    //第三行输入两个正整数x和y，用空格隔开。图片
    //保证x≠y
    //输出描述
    //如果x和y在排列中相邻，则输出"Yes"。否则输出"No"。

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            map.put(arr[i], i);
        }

        int x = in.nextInt();
        int y = in.nextInt();

        Integer idxX = map.get(x);
        Integer idxY = map.get(y);
        if (Math.abs(idxX - idxY) <= 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
