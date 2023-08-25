package com.liao.paperTest.huawei0823;

import java.util.*;
/**
 * @author liaoguixin
 * @date 2023/8/25
 */
public class Test2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (true) {
            String next = input.nextLine();
            String[] split = next.split(" ");
            if (split[0].equals("end")) {
                break;
            } else if (split[0].equals("insert")) {
                sb = insert(sb, split[1], idx);
                idx += split[1].length();
            } else if (split[0].equals("move")) {
                int add = Integer.parseInt(split[1]);
                if (add < 0 && add + idx < 0) {
                    continue;
                }
                if (add > 0 && add + idx > sb.length()) {
                    continue;
                }
                idx = add + idx;
            } else if (split[0].equals("delete")) {
                int len = Integer.parseInt(split[1]);
                if (len < 0) {
                    continue;
                }
                if (len > idx) {
                    continue;
                }
                sb = delete(sb, len, idx);
                idx = idx - len;
            } else if (split[0].equals("copy")) {
                sb = copy(sb, idx);
            }
        }

        System.out.println(sb.substring(0,idx) + "|" + sb.substring(idx));


    }

    static StringBuilder insert(StringBuilder sb, String str, int idx) {
        StringBuilder newSb = new StringBuilder();
        String substring1 = sb.substring(0, idx);
        String substring2 = sb.substring(idx);
        newSb.append(substring1).append(str).append(substring2);
        return newSb;
    }

    static StringBuilder delete(StringBuilder sb, int len, int idx) {
        StringBuilder newSb = new StringBuilder();
        String substring1 = sb.substring(0, idx - len);
        String substring2 = sb.substring(idx);
        newSb.append(substring1).append(substring2);
        return newSb;
    }

    static StringBuilder copy(StringBuilder sb, int idx) {
        StringBuilder newSb = new StringBuilder();
        String substring1 = sb.substring(0, idx);
        String substring2 = sb.substring(idx);
        newSb.append(substring1).append(substring1).append(substring2);
        return newSb;
    }
}
