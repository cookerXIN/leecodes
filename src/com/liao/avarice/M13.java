package com.liao.avarice;

/**
 * @author liaoguixin
 * @data 2023/7/11
 */
public class M13 {
    public static void main(String[] args) {
        //输入: n = 10
        //输出: 9

        System.out.println(monotoneIncreasingDigits(1234));
    }

    public static int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();

        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] > chars[i+1]) {
                chars[i] = (char) (chars[i] - 1);
                charge(chars, i+1);
            }
        }

        int res = Integer.parseInt(String.valueOf(chars));

        return res;
    }

    public static void charge(char[] chars, int start) {
        for (int i = start; i < chars.length; i++) {
            chars[i] = '9';
        }
    }
}
