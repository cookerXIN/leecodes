package com.liao.redo;

/**
 * @author liaoguixin
 * @date 2023/8/11
 */
public class L11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int length = height.length;

        int left = 0;
        int right = length - 1;
        int res = 0;
        int area;
        // 每次只移动最小的板子 因为移动大的班子面积一定比之前的小
        while (left < right) {
            if (height[left] > height[right]) {
                area = height[right] * (right - left);
                right--;
            } else {
                area = height[left] * (right - left );
                left++;
            }
            res = Math.max(res, area);
        }

        return res;
    }
}
