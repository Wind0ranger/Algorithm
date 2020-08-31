package com.windranger.LeetCode;

import java.util.*;

public class L841 {
    public static void main(String[] args) {
        L841 l = new L841();
        List<List<Integer>> list = new LinkedList<>();
        list.add(Arrays.asList(1, 3));
        list.add(Arrays.asList(3, 0, 1));
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(0));
//        list.add(Arrays.asList(1));
//        list.add(Arrays.asList(2));
//        list.add(Arrays.asList(3));
//        list.add(Arrays.asList());
        l.canVisitAllRooms(list);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> set = new HashSet<>();
        Deque<Integer> deque = new LinkedList<>(rooms.get(0));
        while (!deque.isEmpty()) {
            int i = deque.pop();
            if (set.contains(i)) {
                continue;
            } else {
                deque.addAll(rooms.get(i));
                set.add(i);
            }
        }
        set.add(0);
        return set.size()==rooms.size();
    }
}
