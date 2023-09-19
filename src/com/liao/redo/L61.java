package com.liao.redo;

import com.liao.hot100.ListNode;

/**
 * @author liaoguixin
 * @date 2023/9/19
 */
public class L61 {
    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;

        int len = 0;
        while (fast != null) {
            fast = fast.next;
            len++;
        }

        if (len == 1) {
            return head;
        }

        k = k % len;

        if (k == 0) {
            return head;
        }
        fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        ListNode pre = new ListNode(-1);
        while (fast != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        pre.next = null;
        ListNode res = slow;
        while (slow.next != null) {
            slow = slow.next;
        }
        slow.next = head;

        return res;
    }
}
