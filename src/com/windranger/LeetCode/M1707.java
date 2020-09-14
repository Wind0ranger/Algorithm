package com.windranger.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class M1707 {
    public static void main(String[] args) {
        String[] names = {"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"};
        String[] synonyms = {"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)"};
        M1707 m = new M1707();
        System.out.println(Arrays.toString(m.trulyMostPopular(names, synonyms)));
    }

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        String pattern = "\\([0-9]*\\)";
        HashMap<String, Integer> map = new HashMap<>();
        for (String name : names) {
            String ss = name.replaceAll(pattern, "");
            int val = Integer.parseInt(name.replace(ss, "").replace("(", "").replace(")", ""));
            map.put(ss, val);
        }
        // 1. 找到并查集
        Map<String, String> parents = new HashMap<>();
        for (String synonym : synonyms) {
            String[] temps = synonym.replace("(", "").replace(")", "").split(",");
            union(parents, temps[0], temps[1]);
        }
        System.out.println(parents);
        System.out.println(map);
        parents.forEach((k, v) -> {
            int kk = 0;
            if (map.containsKey(k)) {
                kk = map.get(k);
            }
            int vv = 0;
            if (map.containsKey(v)) {
                vv = map.get(v);
            }
            int sum = kk + vv;
            map.put(v, sum);
            map.remove(k);
        });
        System.out.println(map);
        return null;
    }

    private void union(Map<String, String> parents, String a, String b) {
        String x = find(parents, a);
        String y = find(parents, b);
        if (!x.equals(y)) {
            parents.put(y, x);
        }
    }

    private String find(Map<String, String> parents, String a) {
        if (!parents.containsKey(a)) {
            parents.put(a, "");
        }
        if ("".equals(parents.get(a))) {
            return a;
        }
        return find(parents, parents.get(a));
    }

}
