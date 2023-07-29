package com.liao.test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liaoguixin
 * @date 2023/7/28
 */
public class L12 {
    public static void main(String[] args) {
        int k = 1;
        int[] nums = {1,-1};

        Deque<Integer> deque = new LinkedList<>();
        int n = nums.length;

        int index = 0;
        int[] res = new int[n-k+1];
        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            if (!deque.isEmpty() && i >= k - 1) {
                res[index++] = nums[deque.peekFirst()];
            }
        }


        System.out.println(res);
    }
}
