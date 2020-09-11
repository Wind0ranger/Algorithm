package com.windranger.Collection;

import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<P, Integer> map = new TreeMap<>(
                (o1, o2) -> {
                    if (o1.a == o2.a) {
                        return 0;
                    }
                    return o1.a < o2.a ? 1 : -1;
                }
        );
        map.put(new P("11", 11), 1);
        map.put(new P("22", 22), 2);
        map.put(new P("33", 33), 3);
        map.forEach((k, v) -> {
            System.out.println(k);
        });
    }

    static class P {
        String v;
        int a;

        public P(String v, int a) {
            this.v = v;
            this.a = a;
        }

        @Override
        public String toString() {
            return "P{" +
                    "v='" + v + '\'' +
                    ", a=" + a +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            P p = (P) o;

            if (a != p.a) return false;
            return v != null ? v.equals(p.v) : p.v == null;
        }

        @Override
        public int hashCode() {
            int result = v != null ? v.hashCode() : 0;
            result = 31 * result + a;
            return result;
        }
    }

}

