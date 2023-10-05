package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/10/5
 */
public class L42 {
    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        int len = height.length;
        int sum = 0;

        for (int i = 1; i < len-1; i++) {
            int leftMax = 0;
            for (int l = i-1; l >= 0; l--) {
                leftMax = Math.max(leftMax, height[l]);
            }

            int rightMax = Integer.MIN_VALUE;
            for (int r = i+1; r < len; r++) {
                rightMax = Math.max(rightMax, height[r]);
            }

            int min = Math.min(leftMax, rightMax);
            if (height[i] < min) {
                sum += (min - height[i]);
            }
        }

        return sum;
    }
}
