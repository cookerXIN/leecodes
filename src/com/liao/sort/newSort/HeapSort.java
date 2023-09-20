package com.liao.sort.newSort;

/**
 * @author liaoguixin
 * @date 2023/9/20
 */
public class HeapSort {
    public static void main(String[] args) {

    }


    /*
        最大堆的调整,如果父节点小于子节点,则将其进行交换
     */
    public static void maxHeapDown(int[] nums, int start, int end) {
        int cur = start;
        int left = 2*cur + 1;
        int tmp = nums[cur];

        // 每次遍历一个子树
        for (; left <= end; cur = left, left = left*2 + 1) {
            // 找出最大的子节点
            if (left < end && nums[left] < nums[left+1]) {
                left++;
            }
            // 与父节点进行对比
            if (tmp >= nums[left]) {
                break;
            } else {
                nums[cur] = nums[left];
                nums[left] = tmp;
            }
        }
    }

    /*
       堆排序(不稳定)
       根据建立最大(小)堆,每次取出根节点,再将其依次放入数组中,实现排序
       时间复杂度为O(nlogn)
     */
    public static void heapSortAsc(int[] nums, int n) {
        int i;
        int tmp;

        // 初始化最大堆
        for (i = n/2 - 1; i >= 0; i--) {
            maxHeapDown(nums, i, n-1);
        }

        // 将堆的根节点取出,依次按顺序放入数组,将范围缩小进行排序
        for (i = n-1; i > 0; i--) {

            tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            maxHeapDown(nums,0,i-1);
        }
    }
}
