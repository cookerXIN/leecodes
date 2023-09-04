package com.liao.paperTest.huawei0524;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/28
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();

        Arrays.stream(input.next().split(",")).forEach(a -> list.add(Integer.parseInt(a)));

        list.sort((a,b)->a-b);

        int start = list.get(0);
        int cur = start;
        int res = 1;
        int size = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == cur + 1) {
                cur = list.get(i);
                size++;
            } else {
                cur = list.get(i);
                size = 1;
            }

            if (size > res) {
                res = size;
                start = cur - res + 1;
            }
        }

        System.out.println(start + " " + res);

    }
}
