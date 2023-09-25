package com.liao.paperTest;

import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/9/23
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        String[] split = input.nextLine().split(" ");
        int t1 = 0, t2 = 0;
        int mvp = 0;
        String mvpStr = "";
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] strs = input.nextLine().split(" ");
            if (strs[1].equals(split[0])) {
                int score = Integer.parseInt(strs[2]);
                map1.put(strs[0], map1.getOrDefault(strs[0],0)+score);
                if (map1.get(strs[0]) > mvp) {
                    mvp = map1.get(strs[0]);
                    mvpStr = strs[0];
                }
                t1+=score;
            } else {
                int score = Integer.parseInt(strs[2]);
                map2.put(strs[0], map2.getOrDefault(strs[0],0)+score);
                if (map2.get(strs[0]) > mvp) {
                    mvp = map2.get(strs[0]);
                    mvpStr = strs[0];
                }
                t2+=score;
            }
        }
        if (t1 > t2) {
            System.out.println(split[0]);
        } else if (t1 < t2){
            System.out.println(split[1]);
        } else {
            System.out.println("ended in a draw");
        }
        System.out.println(mvpStr);
    }
}
