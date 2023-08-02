package com.liao.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liaoguixin
 * @date 2023/8/2
 */
public class H234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(1))));
        System.out.println(isPalindrome1(head));
    }

    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int left = 0, right = list.size()-1;

        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }


    public static boolean isPalindrome1(ListNode head) {
        ListNode firstEnd = endOfFirstHalf(head);
        ListNode secondStart = firstEnd.next;

        ListNode reverse = reverse(secondStart);

        boolean result = true;

        while (result && reverse != null) {
            if (reverse.val != head.val) {
                result = false;
            }
            reverse = reverse.next;
            head = head.next;
        }

        firstEnd = reverse(secondStart);

        return result;
    }

    public static ListNode endOfFirstHalf(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp;

        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }
}
