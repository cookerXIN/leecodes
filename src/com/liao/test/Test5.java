package com.liao.test;

import java.util.Arrays;

/**
 * @author liaoguixin
 * @date 2023/9/3
 */
public class Test5 {
    public static void main(String[] args) {
        int[] planks = {5,10,10,5,15,15,15,15};
        System.out.println(Checksquare(planks));
    }

    public static boolean Checksquare (int[] planks) {
        Arrays.sort(planks);
        int len = planks.length;
        int size = 1;
        int cur = planks[len - 1];
        int idx = len - 2;
        boolean[] isUsed = new boolean[len];
        isUsed[len - 1] = true;

        while (idx >= 0) {
            if (isUsed[idx]) {
                idx--;
                continue;
            }

            if (size < 4) {
                if (planks[idx] == cur) {
                    isUsed[idx] = true;
                    idx--;
                    size++;
                } else {
                    if (find(planks, isUsed, cur, idx)) {
                        size++;
                    } else {
                        return false;
                    }
                }
            } else {
                cur = planks[idx];
                isUsed[idx] = true;
                idx--;
                size = 1;
            }
        }

        for (boolean b : isUsed) {
            if (!b) {
                return false;
            }
        }

        return size == 4;
    }


    static boolean find(int[] planks, boolean[] isUsed, int target, int end) {
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }

        boolean flag = false;
        for (int i = 0; i <= end; i++) {
            if (isUsed[i]) {
                continue;
            }
            target -= planks[i];
            isUsed[i] = true;
            flag = find(planks, isUsed, target, end);
            if (flag) {
                return true;
            }
            isUsed[i] = false;
            target += planks[i];
        }

        return flag;
    }
}
