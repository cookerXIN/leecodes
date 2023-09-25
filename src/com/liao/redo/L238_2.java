package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/9/22
 */
public class L238_2 {
    public static void main(String[] args) {

    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] pre = new int[len];
        int[] last = new int[len];

        for (int i = 1; i < len; i++) {
            pre[i] = pre[i-1] * nums[i-1];
        }

        for (int i = len - 2; i >= 0; i--) {
            last[i] = last[i+1] * nums[i+1];
        }

        for (int i = 0; i < len; i++) {
            pre[i] = last[i] * pre[i];
        }

        return pre;
    }
}
