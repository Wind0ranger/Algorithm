package com.windranger.NowCoder;

import java.util.*;

/**
 * https://www.nowcoder.com/practice/e3769a5f49894d49b871c09cadd13a61
 */
public class Lru {

    public static void main(String[] args) {
        Lru l = new Lru();
        int[][] operators = {{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        System.out.println(Arrays.toString(l.LRU(operators, 3)));
    }

    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        LruCache lruCache = new LruCache(k);
        List<Integer> res = new LinkedList<>();
        for (int[] operator : operators) {
            if (operator[0] == 2) {
                res.add(lruCache.get(operator[1]));
            }
            if (operator[0] == 1) {
                int k1 = lruCache.get(operator[1]);
                int v = lruCache.get(operator[2]);
                lruCache.set(k1, v);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    class LruCache {
        private List<Integer> list;
        private HashMap<Integer, Integer> index;
        private int size;
        private HashMap<Integer, Integer> map;

        public LruCache(int k) {
            size = k;
            list = new LinkedList<>();
            map = new HashMap<>();
            index = new HashMap<>();
        }

        public int get(int i) {
            return map.getOrDefault(i, -1);
        }

        public void set(int k, int v) {
            if (list.size() <= size) {
                if (index.containsKey(k)) {
                    list.remove(index.get(k));
                } else {
                    list.add(k);
                    index.put(k, list.size() - 1);
                }
            } else {
//                int kk = list.remov;
//                map.remove(kk);
            }
            map.put(k, v);
        }
    }

}
