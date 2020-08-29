package com.windranger.Sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QuickSort {

    public static void main(String[] args) {
        List<Integer> list = Common.generateV2();
        List<Integer> res = quick(list);
        System.out.println(res);
    }

    private static List<Integer> quick(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        List<Integer> a = new LinkedList<>();
        List<Integer> b = new LinkedList<>();
        int l = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= l) {
                a.add(list.get(i));
            } else {
                b.add(list.get(i));
            }
        }
        a = quick(a);
        b = quick(b);
        a.add(l);
        a.addAll(b);
        return a;
    }
}
