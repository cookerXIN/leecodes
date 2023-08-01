package com.liao.hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liaoguixin
 * @date 2023/8/1
 */
public class H215 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 3));
    }

    public static int findKthLargest(int[] nums, int k) {
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque2 = new LinkedList<>();

        for (int num : nums) {
            while (!deque1.isEmpty() && deque1.peekLast() > num) {
                deque2.offer(deque1.pollLast());
            }
            while (!deque2.isEmpty() && deque2.peekLast() < num) {
                deque1.offerLast(deque2.pollLast());
            }
            deque1.offerLast(num);
        }

        int res = -1;
        if (deque2.size() >= k) {
            for (int i = 0; i < k; i++) {
                res = deque2.pollFirst();
            }
        } else {
            int n = k - deque2.size();
            for (int i = 0; i < n; i++) {
                res = deque1.pollLast();
            }
        }

        return res;
    }
}
