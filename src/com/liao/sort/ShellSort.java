package com.liao.sort;

/**
 * @author liaoguixin
 * @date 2023/6/26
 * @apiNote
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {2,4,7,1,9,5,3};

        int n = arr.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int current = arr[i];
                int preIndex = i - gap;
                // Insertion sort
                while (preIndex >= 0 && arr[preIndex] > current) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = current;

            }
            gap /= 2;
        }
    }
}
