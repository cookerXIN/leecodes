package com.liao.redo;

import com.liao.hot100.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liaoguixin
 * @date 2023/8/23
 */
public class L142 {
    public static void main(String[] args) {

    }

    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head)) {
                set.add(head);
            } else {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
