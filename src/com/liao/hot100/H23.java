package com.liao.hot100;

import java.util.prefs.NodeChangeEvent;

/**
 * @author liaoguixin
 * @date 2023/8/3
 */
public class H23 {
    public static void main(String[] args) {
        ListNode[] list = {
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6)),
        };
        mergeKLists(list);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode mergeClip = mergeClip(lists, 0, lists.length - 1);

        return mergeClip;
    }

    public static ListNode mergeClip(ListNode[] list, int left, int right) {
        if (left == right) {
            return list[left];
        }
        if (left > right) {
            return null;
        }

        int mid = (right + left) >> 1;
        return merge(mergeClip(list, left, mid), mergeClip(list, mid+1, right));
    }

    public static ListNode merge(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }

        if (node1 != null) {
            cur.next = node1;
        }
        if (node2 != null) {
            cur.next = node2;
        }

        return head.next;
    }

}
