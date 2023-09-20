package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/9/19
 */
public class L67 {
    public static void main(String[] args) {
        System.out.println(addBinary("101111", "10"));
    }

    public static String addBinary(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int pre = 0;
        while (idx < aChars.length && idx < bChars.length) {
            int aNum = aChars[aChars.length - 1 - idx] - '0';
            int bNum = bChars[bChars.length - 1 - idx] - '0';
            if (aNum + bNum + pre > 1) {
                sb.append(aNum + bNum + pre - 2);
                pre = 1;
            } else {
                sb.append(aNum + bNum + pre);
                pre = 0;
            }
            idx++;
        }

        while (idx < aChars.length) {
            int aNum = aChars[aChars.length - 1 - idx] - '0';
            if (aNum + pre > 1) {
                sb.append(aNum + pre - 2);
                pre = 1;
            } else {
                sb.append(aNum + pre);
                pre = 0;
            }
            idx++;
        }

        while (idx < bChars.length) {
            int bNum = bChars[bChars.length - 1 - idx] - '0';
            if (bNum + pre > 1) {
                sb.append(bNum + pre - 2);
                pre = 1;
            } else {
                sb.append(bNum + pre);
                pre = 0;
            }
            idx++;
        }

        if (pre == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }
}
