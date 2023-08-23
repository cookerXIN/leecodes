package com.liao.redo;

import java.sql.ResultSetMetaData;

/**
 * @author liaoguixin
 * @date 2023/8/23
 */
public class L43 {
    public static void main(String[] args) {
        System.out.println(multiply("6913259244", "71103343"));
    }

    public static String multiply(String num1, String num2) {

        int len1 = num1.length();
        int len2 = num2.length();

        String ans = "0";
        for (int i = len2 - 1; i >= 0; i--) {
            StringBuffer sb = new StringBuffer();
            int add = 0;
            for (int j = len2 - 1; j > i; j--) {
                sb.append(0);
            }

            int y = num2.charAt(i) - '0';
            for (int j = len1 - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x*y + add;
                sb.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                sb.append(add % 10);
            }

            ans = addStrings(ans, sb.reverse().toString());
        }

        return ans;
    }

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
}
