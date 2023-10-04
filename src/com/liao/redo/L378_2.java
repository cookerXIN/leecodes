package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/10/4
 */
public class L378_2 {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 5, 9}, {10, 11, 13}, {12, 13, 15}
        };
        System.out.println(kthSmallest(nums, 8));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int left = matrix[0][0];
        int right = matrix[len-1][len-1];
        int mid;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (check(matrix, mid, k, len)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return left;
    }

    public static boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int count = 0;

        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                count += i+1;
                j++;
            } else {
                i--;
            }
        }

        return count >= k;
    }
}
