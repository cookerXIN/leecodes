package com.liao.hot100;

/**
 * @author liaoguixin
 * @date 2023/7/29
 */
public class H160 {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;

        int lenA = 0;
        int lenB = 0;

        while (curA != null) {
            lenA++;
            curA = curA.next;
        }

        while (curB != null) {
            lenB++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;
        if (lenA < lenB) {
            int tmp = lenA;
            lenA = lenB;
            lenB = tmp;

            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }

        int lenAB = lenA - lenB;
        while (lenAB > 0) {
            curA = curA.next;
            lenAB--;
        }

        while (lenB > 0) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
            lenB--;
        }

        return null;
    }

}
