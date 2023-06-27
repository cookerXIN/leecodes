package com.liao.sort;

import java.util.Arrays;

/**
 * @author liaoguixin
 * @date 2023/6/26
 * @apiNote
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2,4,7,1,9,5,3};

        quickSort(arr,0,arr.length-1);
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int pointer = low;
        for (int i = low; i < high; i++) {
            if (array[i] <= pivot) {
                int temp = array[i];
                array[i] = array[pointer];
                array[pointer] = temp;
                pointer++;
            }
            System.out.println(Arrays.toString(array));
        }
        int temp = array[pointer];
        array[pointer] = array[high];
        array[high] = temp;
        return pointer;
    }
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int position = partition(array, low, high);
            quickSort(array, low, position - 1);
            quickSort(array, position + 1, high);
        }
    }

}
