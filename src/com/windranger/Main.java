package com.windranger;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.combination(2, 3));
//        System.out.println(Arrays.toString(main.arrayMerge(new int[]{1, 2, 4, 5}, 4, new int[]{7, 3}, 2)));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * calculate combination Number
     *
     * @param r int整型
     * @param n int整型
     * @return int整型
     */
    static HashMap<Integer, Long> map = new HashMap<>();

    public int combination(int r, int n) {
        if (n - r == 0 || r == 0 || n == 0) {
            return 1;
        }
        long nr = getDD(n - r, 1);
        long nn = getDD(n, nr);
        long rr = getDD(r, 1);
        return (int) (nn / rr);
    }

    private long getDD(int n, long nr) {
        long res = n / nr;
        if (n <= 1) {
            return 1;
        } else {
            if (map.containsKey(n - 1)) {
                res = res * map.get(n - 1);
            } else {
                res = res * getDD(n - 1, nr);
            }
        }
        map.put(n, res);
        return res;
    }


    public int[] arrayMerge(int[] array1, int n, int[] array2, int m) {
        int[] nums = new int[n + m];
        int i = 0;
        int j = m - 1;
        int k = 0;
        while (i < n && j >= 0) {
            int a = array1[i];
            int b = array2[j];
            if (a <= b) {
                nums[k] = a;
                i++;
            } else {
                nums[k] = b;
                j--;
            }
            k++;
        }
        if (i < n) {
            for (int l = i; l < n; l++, k++) {
                nums[k] = array1[l];
            }
        } else {
            for (int l = j; l >= 0; l--, k++) {
                nums[k] = array2[l];
            }
        }
        return nums;
        // write code here
    }
}
