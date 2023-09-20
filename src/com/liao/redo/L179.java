package com.liao.redo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.SortedMap;

/**
 * @author liaoguixin
 * @date 2023/9/19
 */
public class L179 {
    public static void main(String[] args) {
        int[] nums = {
                0,0,0
        };
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        Integer[] integerArray = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            integerArray[i] = nums[i];
        }

        Arrays.sort(integerArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);

                String order1 = s1 + s2;
                String order2 = s2 + s1;
                return order2.compareTo(order1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = integerArray.length - 1; i >= 0; i--) {
            sb.append(integerArray[i]);
        }
        while (sb.charAt(0) == '0' && sb.length() > 1) {
           sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    static int compare(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 < len2) {
            int tmp = len1;
            len1 = len2;
            len2 = tmp;

            String tmpStr = s1;
            s1 = s2;
            s2 = tmpStr;
        }

        for (int i = 0; i < len2; i++) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return 1;
            } else {
                return -1;
            }
        }

        if (len1 > len2) {
            return s1.charAt(len2) > s1.charAt(len2 - 1) ? 1 : -1;
        }

        return 0;
    }
}
