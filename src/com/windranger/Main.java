package com.windranger;


import java.util.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, Test> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < s; j++) {
                int v = sc.nextInt();
                if (!map.containsKey(v)) {
                    Test node = new Test(v);
                    map.put(v, node);
                }
                list.add(v);
            }
            for (Integer v : list) {
                map.get(v).add(list);
            }
        }
        int size = getSize(map);
        System.out.println(size);
    }

    private static int getSize(HashMap<Integer, Test> map) {
        Test node = map.get(0);
        Deque<Test> deque = new LinkedList<>();
        deque.add(node);
        HashSet<Integer> set = new HashSet<>();
        while (!deque.isEmpty()) {
            Test temp = deque.remove();
            set.add(temp.val);
            for (Integer i : temp.nodes) {
                if (!set.contains(i)) {
                    deque.add(map.get(i));
                }
            }
        }
//        System.out.println(set);
        return set.size();
    }

    static class Test {
        public int val;
        public Set<Integer> nodes = new HashSet<>();

        public Test(int val) {
            this.val = val;
        }

        public void add(List<Integer> n) {
            this.nodes.addAll(n);
        }

    }
}