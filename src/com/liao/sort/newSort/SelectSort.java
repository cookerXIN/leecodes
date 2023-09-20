package com.liao.sort.newSort;

/**
 * @author liaoguixin
 * @date 2023/9/20
 */
public class SelectSort {
    public static void main(String[] args) {

    }

    /*
        选择排序（不稳定）
        和插入排序一样，将数组的区域划分为有序区域和无序区域，每次取有序区域的末尾数（轮次之后加一的元素，本身是在无序区），与无序区域的最小值进行对
        比，如果是本身，则不用交换，如果不一样，则将最小值交换到有序的最后一位，本身是每次查找最小值，将最小值依次添加到数组后面
        时间复杂度O(n^2)
     */
    public static void selectSort(int[] nums, int n) {
        int i;
        int j;
        int min;
        // 控制有序区间的范围
        for (i = 0; i < n; i++) {
            min = i;

            // 从无序区间中,找到最小值
            for (j = i+1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min=j;
                }
            }

            // 如果不是本身,则交换
            if (min != i) {
                int tmp = nums[i];
                nums[i] = nums[min];
                nums[min] = tmp;
            }
        }
    }
}
