package com.liao.paperTest.huawei.h0920;
import java.util.*;
/**
 * @author liaoguixin
 * @date 2023/9/22
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int[] nums = new int[n];
        String[] split = input.nextLine().split(" ");
        for (int i = 0; i < split.length; i++) {
            nums[i % n] = Integer.parseInt(split[i]);
        }
        int sn = Integer.parseInt(input.nextLine());

        int left = 0;
        int right = n - 1;
        int start = -1;
        int end = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == sn) {
                start = mid;
                end = mid;
                for (int i = start; i >= 0; i--) {
                    if (nums[i] != sn) {
                        start = i+1;
                        break;
                    }
                }
                for (int i = end; i < n; i++) {
                    if (nums[i] != sn) {
                        end = i-1;
                        break;
                    }
                }
                break;
            }
            if (nums[0] > nums[mid]) {
                if (nums[mid] < sn && sn <= nums[n-1]) {
                    left = mid+1;
                } else{
                    right = mid-1;
                }
            } else {
                if (nums[0] <= sn && sn < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        System.out.println(start + " " + end);
    }
}
