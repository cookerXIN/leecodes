package com.liao.test;

import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/9/5
 */
public class a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        // 去除中括号并分割字符串为整数数组
        String[] e = input.substring(1, input.length() - 1).split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < e.length; i++) {
            list.add(Integer.parseInt(e[i].trim()));
        }
        int[] nums = new int[list.size()];
        for(int i = 0;i < list.size(); i++){
            nums[i] = list.get(i);
        }
        int k = sc.nextInt();
        sc.close();
        int[] res = twoSum(nums, k);
        for(int i = 0;i < res.length;i++){
            if(i == res.length - 1) {
                System.out.print(res[i]);
                break;
            }
            System.out.print(res[i] + " ");
        }
    }
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{0, nums[i], nums[j]};
                }
            }
        }
        return new int[3];
    }
}
