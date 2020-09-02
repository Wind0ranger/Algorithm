package com.windranger;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(1);
        int j = i.incrementAndGet();
        System.out.println(j);
    }

}