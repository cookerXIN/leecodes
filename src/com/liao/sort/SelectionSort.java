package com.liao.sort;

/**
 * @author liaoguixin
 * @date 2023/6/26
 * @apiNote
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2,4,7,1,9,5,3};

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }
}
