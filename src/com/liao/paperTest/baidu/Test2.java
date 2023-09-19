package com.liao.paperTest.baidu;

import java.util.*;
/**
 * @author liaoguixin
 * @date 2023/9/12
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }

        for (int i = 0; i <= n-k; i++) {
            boolean flag = true;
            int couldIdx = -1;
            int exp = -1;
            int cur = nums[i];
            for (int j = i+1; j < i + k; j++) {
                if (cur + 1 == nums[j]) {
                    cur = nums[j];
                } else {
                    if (couldIdx == -1) {
                        couldIdx = j;
                        flag = false;
                        cur += 1;
                    } else {
                        if (nums[couldIdx-1] + 1 == nums[j]) {
                            exp = nums[j];
                            couldIdx = -2;
                        }
                        couldIdx = -1;
                        break;
                    }
                }

            }

            if (flag) {
                System.out.println("YES");
                System.out.println("0");
                return;
            }

            if (exp != -1) {
                System.out.println("YES");
                System.out.println("1");
                System.out.println(couldIdx+1 + " " + (exp+1));
                return;
            }

            if (couldIdx != -1) {
                for (int p = 0; p < i; p++) {
                    if (nums[p] == nums[couldIdx-1] + 1) {
                        System.out.println("YES");
                        System.out.println("1");
                        System.out.println(p + " " + couldIdx);
                        return;
                    }
                }
                for (int p = i+k; p < n; p++) {
                    if (nums[p] == nums[couldIdx-1] + 1) {
                        System.out.println("YES");
                        System.out.println("1");
                        System.out.println(couldIdx+1 + " " + (p+1));
                        return;
                    }
                }
            }

        }

        System.out.println("NO");
    }
}
