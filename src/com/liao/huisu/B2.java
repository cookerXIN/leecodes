package com.liao.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liaoguixin
 * @data 2023/7/7
 */
public class B2 {

    public static void main(String[] args) {
        System.out.println(combinationSum3(4, 1));
    }

    static List<List<Integer>> resList = new ArrayList<>();
    static LinkedList<Integer> itemList = new LinkedList<>();
    public static List<List<Integer>> combinationSum3(int k, int n) {
        method(k, n, 1);
        return resList;

    }

    public static void method(int k, int n, int start) {
        if (itemList.size() == k) {
            if (n == 0) {
                resList.add(new ArrayList<>(itemList));
            }
            return;
        }

        for (int i = start; i <= 9 - (k - itemList.size()) + 1; i++) {
            itemList.add(i);
            n -= i;
            method(k, n, i+1);
            n += i;
            itemList.removeLast();
        }
    }
}
