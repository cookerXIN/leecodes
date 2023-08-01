package com.liao.hot100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liaoguixin
 * @date 2023/8/1
 */
public class H148 {
    public static void main(String[] args) {
        ListNode cur = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        sortList1(cur);
    }

    public static ListNode sortList(ListNode head) {
        Deque<ListNode> deque1 = new LinkedList<>();

        Deque<ListNode> deque2 = new LinkedList<>();

        while (head != null) {
            while (!deque1.isEmpty() && deque1.peekLast().val > head.val) {
                deque2.offer(deque1.pollLast());
            }
            while (!deque2.isEmpty() && deque2.peekLast().val < head.val) {
                deque1.offer(deque2.pollLast());
            }
            deque1.offerLast(head);
            head = head.next;
        }

        ListNode cur = new ListNode(-1);
        head = cur;
        while (!deque1.isEmpty()) {
            cur.next = deque1.pollFirst();
            cur = cur.next;
        }
        while (!deque2.isEmpty()) {
            cur.next = deque2.pollLast();
            cur = cur.next;
        }
        cur.next = null;

        return head.next;
    }


    public static ListNode sortList1(ListNode head) {
        if (head == null) {
            return head;
        }
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        ListNode dummy = new ListNode(0, head);
        for (int subLen = 1; subLen < n; subLen*=2) {
            // 每次更新为当前为链表第一个节点
            ListNode pre = dummy;
            cur = dummy.next;

            while (cur != null) {
                // 开始截取第一段
                ListNode head1 = cur;
                // 设置第一段的长度
                for (int i = 1; i < subLen && cur.next != null; i++) {
                    cur = cur.next;
                }

                // 截取第二段
                ListNode head2 = cur.next;;
                // 孤立第一段 将大于subLen之后的节点截断
                cur.next = null;
                cur = head2;
                // 截取第二段长度
                for (int i = 1; i < subLen && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }

                // 设置下次截取的起点
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }

                // 合并两个子链表
                ListNode merge = merge(head1, head2);
                // 接在前一个结尾的后面
                pre.next = merge;
                // 设置好下一段接到位置
                while (pre.next != null) {
                    pre = pre.next;
                }
                cur = next;
            }
        }

        return dummy.next;
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy, tmp1 = head1, tmp2 = head2;

        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val > tmp2.val) {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            } else {
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            }
            tmp = tmp.next;
        }

        while (tmp1 != null) {
            tmp.next = tmp1;
            tmp1 = tmp1.next;
            tmp = tmp.next;
        }
        while (tmp2 != null) {
            tmp.next = tmp2;
            tmp2 = tmp2.next;
            tmp = tmp.next;
        }

        return dummy.next;
    }
}
