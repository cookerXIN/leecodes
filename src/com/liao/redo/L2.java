package com.liao.redo;

import com.liao.hot100.ListNode;

/**
 * @author liaoguixin
 * @date 2023/8/11
 */
public class L2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9,new ListNode(9,new ListNode(9, new ListNode(9))));
        ListNode l2 = new ListNode(9, new ListNode(9));
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int pre = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int tmp = (val1 + val2 + pre) / 10;
            int val = (val1 + val2 + pre) >= 10 ? (val1 + val2 + pre) % 10 : (val1 + val2 + pre);
            pre = tmp;
            cur.next = new ListNode(val);
            cur = cur.next;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }

        if (pre == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}
