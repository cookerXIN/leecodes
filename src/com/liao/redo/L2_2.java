package com.liao.redo;

import com.liao.hot100.ListNode;

/**
 * @author liaoguixin
 * @date 2023/9/12
 */
public class L2_2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int pre = 0;

        while (l1 != null || l2 != null) {
            int left = l1 == null ? 0 : l1.val;
            int right = l2 == null ? 0 : l2.val;
            int curVal = (left + right + pre) % 10;

            cur.next = new ListNode(curVal);
            cur = cur.next;

            pre = (left + right + pre) / 10;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (pre == 1) {
            cur.next = new ListNode(1);
        }

        return dummy.next;
    }
}
