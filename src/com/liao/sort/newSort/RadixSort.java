package com.liao.sort.newSort;

/**
 * @author liaoguixin
 * @date 2023/9/20
 */
public class RadixSort {
    public static void main(String[] args) {
        int a[] = {53, 3, 542, 748, 14, 214, 154, 63, 616};
        radixSort(a);
    }

    public static int getMax(int[] nums) {
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }

    public static void radixSort(int[] nums) {
        int exp;
        int max = getMax(nums);

        // 从个位开始，对数组a按"指数"进行排序
        for (exp = 1; max/exp > 0; exp *= 10)
            countSort(nums, exp);
    }

    public static void countSort(int[] nums, int exp) {
        int[] output = new int[nums.length];
        int[] buckets = new int[10];

        for (int i = 0; i < nums.length; i++) {
            buckets[(nums[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            buckets[i] += buckets[i - 1];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            output[buckets[ (nums[i]/exp)%10 ] - 1] = nums[i];
            buckets[ (nums[i]/exp)%10 ]--;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = output[i];
        }


        output = null;
        buckets = null;
    }
}
