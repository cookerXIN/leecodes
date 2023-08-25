package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/8/25
 */
public class L125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {
        int len = s.length();
        if (len == 1) {
            return true;
        }
        int left = 0, right = len - 1;
        while (left < right) {
            while (left < len && (!Character.isAlphabetic(s.charAt(left)) && !Character.isDigit(s.charAt(left)))) {
                left++;
            }
            if (left >= right) {
                return true;
            }
            while (right >= 0 && (!Character.isAlphabetic(s.charAt(right)) && !Character.isDigit(s.charAt(right)))) {
                right--;
            }
            if (left >= right) {
                return true;
            }
            char leftChar = s.charAt(left);
            if (Character.isAlphabetic(leftChar)) {
                leftChar = leftChar < 'a' ? (char) (leftChar + 32): leftChar;
            }
            char rightChar = s.charAt(right);
            if (Character.isAlphabetic(rightChar)) {
                rightChar = rightChar < 'a' ? (char) (rightChar + 32): rightChar;
            }

            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
