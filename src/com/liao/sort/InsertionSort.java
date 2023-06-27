package com.liao.sort;

/**
 * @author liaoguixin
 * @date 2023/6/26
 * @apiNote
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {2,4,7,1,9,5,3};

        for (int i = 1; i < arr.length; i++) {
            int preIndex = i - 1;
            int current = arr[i];
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex -= 1;
            }
            arr[preIndex + 1] = current;
        }
    }

}
