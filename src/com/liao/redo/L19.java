package com.liao.redo;

import com.liao.hot100.ListNode;

/**
 * @author liaoguixin
 * @date 2023/8/16
 */
public class L19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        removeNthFromEnd(head, 2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode fast = head;
        ListNode slow = head;

        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }

        while (fast != null && slow != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if (slow != null) {
            pre.next = slow.next;
        } else {
            pre.next = null;
        }


        return dummy.next;
    }
}
