package com.liao.sort.newSort;

/**
 * @author liaoguixin
 * @date 2023/9/20
 */
public class MergeSort {
    public static void main(String[] args) {

    }

    public static void merge(int[] nums, int start, int mid, int end) {
        // 临时数组
        int[] tmp = new int[end-start+1];
        int i = start;
        int j = mid+1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = nums[i++];
        }

        while (j <= end) {
            tmp[k++] = nums[j++];
        }

        for (i = 0; i < k; i++) {
            nums[start+i] = tmp[i];
        }

        tmp=null;
    }

    public static void mergeGroups(int[] nums, int len, int gap) {
        int i;
        // 整合排序小数组
        for (i = 0; i + 2*gap -1 < len; i += (2*gap)) {
            merge(nums, i, i + gap - 1, i + 2*gap -1);
        }
        // 如果最后一个不够则单独成一个
        if (i + gap - 1 < len - 1) {
            merge(nums, i, i+gap-1, len-1);
        }
    }

    /*
        归并排序（稳定）
        将数组一直按照一半一半对分，一直拆到一个小数组只有一个元素
        然后再一步步合并两个数组，进行排序，直到变成一个完整的数组
        时间复杂度为O(nlogn)
     */
    public static void mergeSort(int[] nums) {
        if (nums == null)
            return ;

        // 开始拆分数组
        for(int n = 1; n < nums.length; n*=2){
            mergeGroups(nums, nums.length, n);
        }

    }

}
