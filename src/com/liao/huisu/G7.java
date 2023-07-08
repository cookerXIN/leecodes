package com.liao.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguixin
 * @data 2023/7/7
 */
public class G7 {
    public static void main(String[] args) {
        //输入：s = "25525511135"
        //输出：["255.255.11.135","255.255.111.35"]
        System.out.println(restoreIpAddresses("25525511135"));
    }

    static List<String> resList = new ArrayList<String>();

    public static List<String> restoreIpAddresses(String s) {
        method(s, 0);
        return resList;
    }

    static List<String> item = new ArrayList<String>();
    public static void method(String s, int start) {
        if (item.size() == 4) {
            if (start == s.length()) {
                resList.add(transfer(item));
            }
            return;
        }


        for (int i = start; i < s.length(); i++) {
            if (isValid(s, start, i+1)) {
                item.add(s.substring(start, i+1));
            } else {
                break;
            }
            method(s, i+1);
            item.remove(item.size() - 1);
        }
    }

    public static boolean isValid(String s, int start, int end) {
        String str = s.substring(start, end);
        if (str.length() >= 1 && str.charAt(0) == '0') {
            return false;
        }
        if (Integer.parseInt(str) > 255) {
            return false;
        }
        return true;
    }

    public static String transfer(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                sb.append(".");
                sb.append(list.get(i));
            } else {
                sb.append(list.get(i));
            }
        }

        return sb.toString();
    }
}
