package com.liao.paperTest.zijie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/9/10
 */
public class Test5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            pairs.add(new Pair(i, arr[i]));
        }

        // 对数字的最低位1的位置大小进行排序
        pairs.sort((a, b) -> b.lowBitPos - a.lowBitPos);

        // 对选中的数字进行操作
        for (int i = 0; i < k; i++) {
            Pair p = pairs.get(i % n);  // 循环选择数字
            arr[p.index] &= arr[p.index] - 1;  // 将数字的最低位1变为0
        }

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        System.out.println(sum);
    }

    static class Pair {
        int index;
        int lowBitPos;

        Pair(int index, int num) {
            this.index = index;
            // 计算数字的最低位1的位置
            this.lowBitPos = 0;
            while (num > 0) {
                if ((num & 1) == 1) break;
                this.lowBitPos++;
                num >>= 1;
            }
        }
    }
}


