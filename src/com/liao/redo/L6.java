package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/8/26
 */
public class L6 {
    public static void main(String[] args) {
        String paypalishiring = convert("PAYPALISHIRING", 4);
    }

    public static String convert(String s, int numRows) {
        int len = s.length();
        int num = len % (3 * numRows - 2);
        int col = (len / (3 * numRows - 2)) * numRows;

        if (num <= numRows) {
            col += 1;
        } else if (num > numRows && num <= 2 * numRows - 1) {
            col += num - numRows + 1;
        } else {
            col += numRows;
        }

        return "";
    }
}
