package com.liao.test.ke0729;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/1
 */
public class C03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            set.add(arr[i]);
        }

        int s = sc.nextInt();
        int count = 0;

        for (int i : arr) {
            if (set.contains(i)) {
                // 如果是等与s的一半 则影响只有1 负责为2
                if (s - i == i) {
                    count -= 1;
                } else {
                    count -= 2;
                }
            }
            set.remove(i);
            set.remove(s-i);
        }

        System.out.println(count + s - 1);
    }
}
