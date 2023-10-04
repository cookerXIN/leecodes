package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/10/4
 */
public class L4 {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int len = len1 + len2;
        if (len % 2 == 0) {
            int idx = len / 2;
            return get(nums1, nums2, idx-1, idx);
        } else {
            return get(nums1, nums2, len / 2, len / 2);
        }
    }

    public static double get(int[] nums1, int[] nums2, int left, int right) {
        int count = 0;
        int leftVal = 0;
        int rightVal = 0;
        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < nums1.length || idx2 < nums2.length) {
             int tmp1 = idx1 == nums1.length ? Integer.MAX_VALUE : nums1[idx1];
             int tmp2 = idx2 == nums2.length ? Integer.MAX_VALUE : nums2[idx2];

             if (tmp1 > tmp2) {
                 idx2++;

                 if (count == left) {
                     leftVal = tmp2;
                 }
                 if (count == right) {
                     rightVal = tmp2;
                     break;
                 }
             } else {
                 idx1++;

                 if (count == left) {
                     leftVal = tmp1;
                 }
                 if (count == right) {
                     rightVal = tmp1;
                     break;
                 }
             }
             count++;
        }

        return (leftVal + rightVal) / 2.0;
    }
}
