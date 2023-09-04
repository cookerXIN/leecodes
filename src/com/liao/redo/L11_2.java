package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/9/1
 */
public class L11_2 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;

        int res = Integer.MIN_VALUE;
        while (left < right) {
            int area;
            if (height[left] < height[right]) {
                area = height[left] * (right - left);
                left++;
            } else {
                area = height[right] * (right - left);
                right--;
            }
            res = Math.max(res, area);
        }

        return res;
    }
}
