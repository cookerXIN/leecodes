package com.liao.test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Scanner;

/**
 * @author liaoguixin
 * @date 2023/9/281,2,3\n4,5,6\n7,8,9
 */
public class T1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] strs = input.nextLine().split("\\\\n");
        int m = strs.length;
        int n = strs[0].split(",").length;
        if (m == 0 || n == 0) {
            return;
        }
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            String str = strs[i];
            String[] split = str.split(",");
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(split[j]);
            }
        }

        List<Integer> res = new ArrayList<>();
        int left = 0, right = n - 1, top = 0, bot = m - 1;
        while (left <= right && top <= bot) {
            for (int i = left; i <= right; i++) {
                res.add(nums[top][i]);
            }
            for (int j = top + 1; j <= bot; j++) {
                res.add(nums[j][right]);
            }
            if (left < right && top < bot) {
                for (int i = right - 1; i > left; i--) {
                    res.add(nums[bot][i]);
                }
                for (int j = bot; j > top; j--) {
                    res.add(nums[j][left]);
                }
            }
            left++;
            right--;
            top++;
            bot--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer re : res) {
            sb.append(re).append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        System.out.println(sb.toString());
    }
}
