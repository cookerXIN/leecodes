package com.liao.paperTest.huawei0510;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author liaoguixin
 * @date 2023/8/28
 */
public class Test1 {

    static Deque<Integer> res = new LinkedList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //String str = input.nextLine();
        String str = "6 1 2 3";
        String[] s = str.split(" ");

        for (int i = 0; i < s.length; i++) {
            dfs(Integer.parseInt(s[i]));
        }

        StringBuilder sb = new StringBuilder();
        while (!res.isEmpty()) {
            sb.append(res.poll());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    static void dfs(int i) {
        if (!res.isEmpty() && i == res.peek()) {
            res.poll();
            i *= 2;
            dfs(i);
        } else if (res.size() > 2) {
            int sum = 0;
            List<Integer> list = new ArrayList<Integer>();
            while (sum < i && !res.isEmpty()) {
                Integer poll = res.pollLast();
                sum += poll;
                list.add(poll);
            }
            if (sum == i) {
                i *= 2;
                dfs(i);
            } else {
                for (int j = list.size() - 1; j >= 0; j--) {
                    res.add(list.get(j));
                }
            }
        }
        res.add(i);
    }
}
