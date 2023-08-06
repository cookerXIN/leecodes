package com.liao.hot100;

import java.util.*;

class MaxAlternatingSequenceLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 输入数组的长度n
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt(); // 输入n个正整数，存入数组arr
        }
        // 对数组进行排序
        Arrays.sort(arr);
        int res = 1;
        int pre = arr[0];
        for (int i = 1;i < arr.length; i++) {
            if(arr[i] != pre){
                if ((pre % 2 != 0 && arr[i] % 2 != 0) | (pre % 2 == 0 && arr[i] % 2 == 0)) continue;
                res++;
            }
            pre = arr[i];
        }
        System.out.println(res);
    }
}
