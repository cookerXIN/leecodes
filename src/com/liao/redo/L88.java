package com.liao.redo;

import com.liao.huisu.J9;

import java.util.Arrays;

/**
 * @author liaoguixin
 * @date 2023/8/22
 */
public class L88 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        int m = 3;
        int n = 3;

        int now = nums1.length - 1;

        while (now >= 0 && m > 0 && n > 0) {
            if (nums1[m-1] > nums2[n-1]) {
                nums1[now] = nums1[m-1];
                nums1[m-1] = 0;
                m--;
            } else {
                nums1[now] = nums2[n-1];
                n--;
            }
            now--;
        }

        if (n > 0) {
            for (int i = n-1; i >= 0; i--) {
                nums1[now] = nums2[i];
                now--;
            }
        }

        System.out.println(1);
    }
}
