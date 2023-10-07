package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/10/7
 */
public class L75 {
    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        int len = nums.length;
        int pos0 = 0;
        int pos1 = 0;
        int tmp;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                tmp = nums[i];
                nums[i] = nums[pos0];
                nums[pos0] = tmp;

                if (pos0 < pos1) {
                    tmp = nums[i];
                    nums[i] = nums[pos1];
                    nums[pos1] = tmp;
                }

                pos0++;
                pos1++;
            } else if (nums[i] == 1) {
                tmp = nums[i];
                nums[i] = nums[pos1];
                nums[pos1] = tmp;

                pos1++;
            }
        }
    }
}
