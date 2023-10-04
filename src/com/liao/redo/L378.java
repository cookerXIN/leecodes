package com.liao.redo;

import java.util.PriorityQueue;

/**
 * @author liaoguixin
 * @date 2023/10/3
 */
public class L378 {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 5, 9}, {10, 11, 13}, {12, 13, 15}
        };
        System.out.println(kthSmallest(nums, 8));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return left;
    }

    public static boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n-1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i+1;
                j++;
            } else {
                i--;
            }
        }

        return num >= k;
    }
}
