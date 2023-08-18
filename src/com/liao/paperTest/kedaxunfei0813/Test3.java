package com.liao.paperTest.kedaxunfei0813;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/18
 */
public class Test3 {
    static HashSet<List<Integer>> set;
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        int[] index = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr1[i] = input.nextInt();
            index[arr1[i]] = i;
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = input.nextInt();
        }

        //set = new HashSet<>();
        //add(arr1);
        //add(arr2);


        long res = (long) (1 + n) * n;
        int i = 0;
        while(i < n){
            int temp = i;
            int num = arr2[i];
            int idx = index[num];
            while (idx < n && i < n && arr2[i] == arr1[idx]){
                i++;
                idx++;
            }
            res -= (long) (1 + (i - temp)) * (i - temp) / 2;
        }

        System.out.println(res);
    }

    static void add(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            List<Integer> item = new ArrayList<>();
            for (int j = i; j < len; j++) {
                item.add(arr[j]);
                set.add(new ArrayList<>(item));
            }
        }
    }
}
