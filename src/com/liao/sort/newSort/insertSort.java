package com.liao.sort.newSort;

/**
 * @author liaoguixin
 * @date 2023/9/19
 */
public class insertSort {
    public static void main(String[] args) {

    }

    /*
        插入排序 稳定
        将数组划分为两个部分，有序部分和无序部分，每次从无序部分依次选出一个数字添加到有序部分中
        时间复杂度是O(n^2) 空间复杂度是O(1)
     */
    static void insertSort(int[] nums, int n) {
        int i,j,k;
        for (i = 1; i < n; i++) {
            // 将a【i】插入到前面的有序集合【a[0],a[1],...,a[i-1]】中
            for (j = i-1; j >= 0; j--) {
                // 遍历到一个合适的位置
                if (nums[j] < nums[i]) {
                    break;
                }
            }

            // 如果当前位置是符合的，则不需要将数组往后去移动
            if (j != i-1) {
                int tmp = nums[i];
                // 将数组往后移动
                for (k = i-1; k > j; k--) {
                    nums[k+1] = nums[k];
                }
                // 将当前的a【i】插入到此位置
                nums[k] = tmp;
            }
        }
    }
}
