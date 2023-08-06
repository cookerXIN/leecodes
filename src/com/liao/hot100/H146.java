package com.liao.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author liaoguixin
 * @date 2023/8/6
 */
public class H146 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(2));
        lruCache.put(1,1);
        //System.out.println(lruCache.get(2));
        lruCache.put(4,1);
        System.out.println(lruCache.get(2));    // 返回 -1 (未找到)
        //System.out.println(lruCache.get(3));    // 返回 3
        //System.out.println(lruCache.get(4));
    }

    static class LRUCache {
        LinkedList<Integer> list;
        Map<Integer, Integer> map = new HashMap<>();
        int capacity;
        public LRUCache(int capacity) {
            list = new LinkedList<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            Integer integer = map.get(key);
            list.remove((Integer) key);
            list.addLast((Integer) key);

            return integer;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                list.remove((Integer) key);
            }
            list.addLast(key);
            map.put(key, value);
            if (list.size() > capacity) {
                Integer integer = list.removeFirst();
                map.remove(integer);
            }
        }
    }
}
