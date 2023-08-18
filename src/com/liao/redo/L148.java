package com.liao.redo;

import com.liao.hot100.ListNode;

/**
 * @author liaoguixin
 * @date 2023/8/18
 */
public class L148 {

    public static void main(String[] args) {
        ListNode head = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));

        //ListNode head1 = new ListNode(2, new ListNode(3));
        //ListNode head2 = new ListNode(1, new ListNode(4));
        //ListNode n = merge(head1, head2);

        ListNode node = sortList(head);
        System.out.println("1");
    }

    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for (int subLen = 1; subLen < len; subLen*=2) {
            cur = dummy.next;
            ListNode pre = dummy;

            while (cur != null) {
                ListNode head1 = cur;
                for (int i = 1; i < subLen && cur.next != null; i++) {
                    cur = cur.next;
                }

                ListNode head2 = cur.next;
                // 第一段切段
                cur.next = null;
                cur = head2;
                for (int i = 1; i < subLen && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }

                // 确定下次两段的起点
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    // 第二段切断
                    cur.next = null;
                }

                ListNode node = merge(head1, head2);
                pre.next = node;
                while (pre.next != null) {
                    pre = pre.next;
                }
                cur = next;
            }
        }

        return dummy.next;
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (head1 != null && head2 != null) {
            int val1 = head1.val;
            int val2 = head2.val;

            if (val1 > val2) {
                cur.next = head2;
                head2 = head2.next;
            } else {
                cur.next = head1;
                head1 = head1.next;
            }
            cur = cur.next;
        }

        if (head1 != null) {
            cur.next = head1;
        }
        if (head2 != null) {
            cur.next = head2;
        }

        return dummy.next;
    }
}
