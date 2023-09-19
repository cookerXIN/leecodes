package com.liao.redo;

import com.liao.hot100.ListNode;

/**
 * @author liaoguixin
 * @date 2023/9/12
 */
public class L19_2 {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        while (n > 0) {
            fast = fast.next;
            n--;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        while (fast != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        pre.next = slow == null ? null : slow.next;
        return dummy.next;
    }
}
