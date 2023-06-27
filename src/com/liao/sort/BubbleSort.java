package com.liao.sort;

/**
 * @author liaoguixin
 * @date 2023/6/26
 * @apiNote
 */
public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = {2,4,7,1,9,5,3};

        for (int i = 1; i < arr.length; i++) {
            // Set a flag, if true, that means the loop has not been swapped,
            // that is, the sequence has been ordered, the sorting has been completed.
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    // Change flag
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
