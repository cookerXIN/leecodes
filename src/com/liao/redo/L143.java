package com.liao.redo;

import com.liao.hot100.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liaoguixin
 * @date 2023/8/25
 */
public class L143 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reorderList(head);
    }

    public static void reorderList(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        dummy.next = head;

        Deque<ListNode> deque = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            deque.add(cur);
            cur = cur.next;
        }

        cur = dummy;
        while (!deque.isEmpty()) {
            cur.next = deque.poll();
            if (deque.isEmpty()){
                cur.next.next = null;
                return;
            }
            cur.next.next = deque.pollLast();
            cur = cur.next.next;
        }
        cur.next = null;
    }
}
