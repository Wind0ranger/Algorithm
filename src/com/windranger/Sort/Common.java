package com.windranger.Sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Common {
    static final int size = 20;

    public static int[] generate() {
        int[] res = new int[size];
        Random random = new Random();
        for (int i = 0; i < res.length; i++) {
            res[i] = random.nextInt(100);
        }
        return res;
    }

    public static List<Integer> generateV2() {
        List<Integer> res = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            res.add(random.nextInt(100));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Common.generate()));
    }
}
