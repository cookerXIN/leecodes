package com.liao.test;

import com.liao.hot100.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author liaoguixin
 * @date 2023/8/27
 */
public class Test2 {
    public static void main(String[] args) {
        LRU cache = new LRU(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 返回 1
        cache.put(3, 3); // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2)); // 返回 -1 (未找到)
        cache.put(4, 4); // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1)); // 返回 -1 (未找到)
        System.out.println(cache.get(3)); // 返回 3
        System.out.println(cache.get(4)); // 返回 4
    }

    static class LRU {
        HashMap<Integer, Integer> map;
        LinkedList<Integer> list;
        int size;

        public LRU(int size) {
            map = new HashMap<>();
            list = new LinkedList<Integer>();
            this.size = size;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            list.remove((Object)key);
            list.add(key);
            return map.get(key);
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.put(key, value);
                list.remove(key);
                list.add(key);
            }
            if (list.size() == size) {
                Integer remove = list.remove(0);
                map.remove(remove);
            }
            map.put(key, value);
            list.add(key);
        }
    }

    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
