package com.liao.hot100;

/**
 * @author liaoguixin
 * @date 2023/7/29
 */

public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
