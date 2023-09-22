package com.liao.sort.newSort;

/**
 * @author liaoguixin
 * @date 2023/9/20
 */
public class BucketSort {
    public static void main(String[] args) {

    }

    /*
        桶排序（稳定）
        其是当有数组的最大值时，创建一个用于存放数组中各元素个数的桶，统计数组中各元素的数量，最后在按桶的大小顺序，以及各元素数量添加进原数组
        时间复杂度：
        最好：O(n+k)
        平均：O(n+k)
        最差：O(n^2)
     */
    public static void bucketSort(int[] nums, int max) {
        int[] bucket;

        if (nums == null || max < 1) {
            return;
        }

        bucket = new int[max];

        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }

        for (int i = 0, j = 0; i < bucket.length; i++) {
            while ((bucket[i]--) > 0) {
                nums[j++] = i;
            }
        }

        bucket = null;
    }
}
