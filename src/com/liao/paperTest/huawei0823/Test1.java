package com.liao.paperTest.huawei0823;

import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/8/25
 */
public class Test1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            set.add(input.nextInt());
        }

        int m = input.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (m > 0) {
            int node = input.nextInt();
            int len = input.nextInt();

            for (int i = 0; i < len; i++) {
                if (set.contains(input.nextInt())) {
                    list.add(node);
                    for (int j = 0; j < len - i - 1; j++) {
                        input.nextInt();
                    }
                    break;
                }
            }
            m--;
        }

        System.out.println(list.size());
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                System.out.print(list.get(i) + " ");
            } else {
                System.out.print(list.get(i));
            }
        }
    }
}
