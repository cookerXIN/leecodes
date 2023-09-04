package com.liao.redo;

import com.liao.hot100.ListNode;

/**
 * @author liaoguixin
 * @date 2023/8/26
 */
public class L92 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node = reverseBetween(head, 2, 4);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        for (int i = 0; i < left-1; i++) {
            pre = cur;
            cur = cur.next;
        }
        ListNode leftPre = pre;

        while (left <= right) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            left++;
        }

        ListNode rightLast = cur;
        ListNode tmp = leftPre.next;
        leftPre.next = pre;
        tmp.next = rightLast;

        return dummy.next;
    }
}
