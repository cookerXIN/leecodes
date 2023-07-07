package com.liao.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguixin
 * @data 2023/7/7
 */
public class A1 {
    public static void main(String[] args) {
        System.out.println(combine(3, 3));
    }

    static List<List<Integer>> resList;
    static List<Integer> itemList;
    public static List<List<Integer>> combine(int n, int k) {
        resList = new ArrayList<>();
        if (n == 0 || k == 0) {
            return resList;
        }

        for (int i = 1; i <= n; i++) {
            itemList = new ArrayList<>();
            itemList.add(i);
            method(n, k, i+1);
        }

        return resList;
    }

    public static void method(int n, int k, int i) {
        if (itemList.size() == k) {
            resList.add(new ArrayList<>(itemList));
            return;
        }

        for (int j = i; j <= n; j++) {
            itemList.add(j);
            method(n, k, j+1);
            itemList.remove(itemList.size()-1);
        }
    }
}
