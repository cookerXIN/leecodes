package com.liao.huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liaoguixin
 * @data 2023/7/7
 */
public class F6 {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    static List<List<String>> resList = new ArrayList<>();
    static LinkedList<String> items = new LinkedList<>();
    public static List<List<String>> partition(String s) {
        method(s, 0);
        return resList;
    }

    public static void method (String s, int start) {
        if (start >= s.length()) {
            resList.add(new ArrayList<>(items));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if(isSym(s, start, i)){
                String str =  s.substring(start, i + 1);
                items.addLast(str);
            }else {
                continue;
            }
            method(s, i+1);
            items.removeLast();
        }


    }

    public static boolean isSym(String s, int start, int end){
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
