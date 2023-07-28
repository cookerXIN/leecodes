package com.liao.test;
import java.util.*;

/**
 * @author liaoguixin
 * @date 2023/7/28
 */
public class K11 {
    static class Link {
        int val;
        Link next = null;

        public Link(int val) {
            this.val = val;
        }
        // public Link Link(int val, Link next) {
        //     this.val = val;
        //     this.next = next;
        // }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                System.out.println("list is empty");
                continue;
            }

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Link first = new Link(arr[0]);
            Link tmp = first;
            for (int i = 1; i < n; i++) {
                Link next = new Link(arr[i]);
                tmp.next = next;
                tmp = tmp.next;
            }

            Link dummy = new Link(-1);
            Link pre = dummy;
            Link cur = first;
            dummy.next = first;
            while (first != null) {
                tmp = first.next;
                first.next = pre;
                pre = first;
                first = tmp;
            }
            cur.next = null;
            while (pre != null) {
                System.out.print(pre.val);
                pre = pre.next;
            }
        }
    }
}
