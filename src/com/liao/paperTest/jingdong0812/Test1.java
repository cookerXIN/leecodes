package com.liao.paperTest.jingdong0812;

import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/8/15
 */
public class Test1 {
    //小红有一个长度为 n 只包含小写字母的字符串她想把这个字符串通过以下操作变成回文串:
    // 1.选择字符串的第一个字母，将其插在字符串的未尾。例如，对于字符串 abc，得到 bca.
    // 2.选择一个字符串的一个字符，将这个字符变成任意小写字母。
    // 每次只能进行上述两种操作中的一种，小红想知道最少需要进行多少次操作才能将字符串变成回文串.
    //  输入描述
    // 第一行一个正整数n，代表字符串的长度。第二行一个长度为 n 的仅包含小写字母的字符串1 ≤ n < 103
    // 输出描述
    // 一个整数，代表最小的操作次数，使得字符串变成回文串.

    // 输入示例
    // 5
    // aacde
    // 输出结果：
    // 2

    // 力扣原题:
    // https://leetcode.cn/problems/DFPeFJ/description/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // 枚举所有可能的1情况，将字符串交换到最后的情况
            // 计算所有情况的最小值
            String t = str.substring(i) + str.substring(0,i);
            res = Math.min(res, count(t) + i);
        }
        System.out.println(res);
    }

    static int count(String str) {
        int left = 0;
        int right = str.length() - 1;
        int num = 0;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                num++;
            }
            left++;
            right--;
        }

        return num;
    }
}
