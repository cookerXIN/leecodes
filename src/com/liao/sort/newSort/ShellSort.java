package com.liao.sort.newSort;

/**
 * @author liaoguixin
 * @date 2023/9/20
 */
public class ShellSort {
    public static void main(String[] args) {

    }

    /*
        希尔排序（不稳定）
        也是分组排序，但是按照步长去分组，比如1，2，3，4，按照步长为2进行分组，则分为1，3和2，4，然后分别进行插入排序，接着步长减半，进行重复之前步骤，直至步长为1
        时间复杂度:当步长为1时，则退化成直接插入排序，O(n^2)；而Hibbard增量则为O(n^3/2)
     */
    public static void shellSort(int[] nums, int n) {
        // 控制步长,每次步长减半
        for (int gap = n / 2; gap > 0; gap/=2) {
            // 按照步长进行分组
            for (int i = 0; i < gap; i++) {
                // 对分组后的数组进行插入排序
                for (int j = i + gap; j < n; j+=gap) {
                    if (nums[j] < nums[j-gap]) {
                        int tmp = nums[j];
                        int k = j - gap;
                        while (k >= 0 && nums[k] > tmp) {
                            nums[k+gap] = nums[k];
                            k -= gap;
                        }
                        nums[k+gap] = tmp;
                    }
                }
            }
        }
    }
}
