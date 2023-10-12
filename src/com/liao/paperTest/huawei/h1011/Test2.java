package com.liao.paperTest.huawei.h1011;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/10/11
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] split = input.nextLine().split(",");
        int[] books = new int[split.length];
        for (int i = 0; i < books.length; i++) {
            books[i] = Integer.parseInt(split[i]);
        }
        int res = 0;
        Arrays.sort(books);
        int idx = -1;
        for (int i = 0; i < books.length; i++) {
            if (books[i] < 0) {
                idx = i;
            } else if (books[i] > 0) {
                break;
            }
        }
        int time = 1;
        int last = 0;
        for (int i = idx+1; i < books.length; i++) {
            res += time * books[i];
            last += books[i];
            time++;
        }
        int cur = res;
        for (int i = idx; i >= 0; i--) {
            cur += books[i] + last;
            last += books[i];
            if (cur >= res) {
                res = cur;
            } else {
                break;
            }
        }
        System.out.println(res);
    }
}
