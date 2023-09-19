package com.liao.redo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liaoguixin
 * @date 2023/9/13
 */
public class L239 {
    public static void main(String[] args) {

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int len = nums.length;

        int idx = 0;
        int[] res = new int[len-k+1];
        for (int i = 0; i < len; i++) {
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (!deque.isEmpty() && i >= k-1) {
                res[idx] = nums[deque.peekFirst()];
                idx++;
            }
        }

        return res;
    }
}
