package com.windranger.Collection;

import java.util.*;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>(16, 0.75f, true);
        map.put("peach", "桃子");
        map.put("apple", "苹果");
        map.put("watermelon", "西瓜");
        map.put("banana", "香蕉");
        outData(map);

        LruCache lru = new LruCache(3);
        lru.put("peach", 1);
        lru.put("apple", 2);
        lru.put("watermelon", 3);
        lru.put("banana", 4);
        outData(lru);
    }

    private static void outData(Map map) {
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    static class LruCache extends LinkedHashMap<String, Integer> {
        private int max;

        public LruCache(int max) {
            this.max = max;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
            return this.size() > max;
        }
    }
}
