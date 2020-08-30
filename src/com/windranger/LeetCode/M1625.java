package com.windranger.LeetCode;

import java.util.HashMap;
import java.util.List;

public class M1625 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }
}

class LRUCache {
    class LruNode {
        public int val;
        public LruNode prev;
        public LruNode next;

        public LruNode(int v) {
            this.val = v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LruNode lruNode = (LruNode) o;

            return val == lruNode.val;
        }

        @Override
        public int hashCode() {
            return val;
        }
    }

    public int size;
    public LruNode tail;
    public LruNode last;
    public HashMap<LruNode, Integer> map;

    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        LruNode node = new LruNode(key);
        updateIndex(node);
        return map.getOrDefault(node, -1);
    }

    public void put(int key, int value) {
        LruNode node = new LruNode(key);
        if (map.containsKey(node)) {
            map.put(node, value);
            updateIndex(node);
        } else {
            map.put(node, value);
            insertFirst(node);
        }
    }


    private void updateIndex(LruNode node) {
        LruNode prev = node.prev;
        LruNode next = node.next;
        prev.next = next;
        next.prev = prev;
        insertFirst(node);
    }

    private void insertFirst(LruNode node) {
        node.next = tail;
        tail = node;
        if (last == null) {
            last = node;
        }
        if (last.prev == null && last != node) {
            last.prev = node;
        }
        if (map.size() > size) {
            LruNode pp = last.prev;
            map.remove(last);
            last = pp;
            pp.next = null;
        }
    }

}