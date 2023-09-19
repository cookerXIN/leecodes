package com.liao.redo;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liaoguixin
 * @date 2023/9/16
 */
public class L739 {
    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            int cur = temperatures[i];
            while (!stack.isEmpty() && cur > temperatures[stack.peek()]) {
                int pre = stack.pop();
                res[pre] = i - pre;
            }
            stack.push(i);
        }

        return res;
    }
}
