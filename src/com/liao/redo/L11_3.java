package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/10/4
 */
public class L11_3 {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int res = 0;
        int tmp;

        while (left < right) {
            tmp = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(tmp, res);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
