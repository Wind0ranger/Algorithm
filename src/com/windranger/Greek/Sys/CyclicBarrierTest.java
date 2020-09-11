package com.windranger.Greek.Sys;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(2);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            System.out.println("0");
        });
        executor.execute(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {

            }
            System.out.println("----" + Thread.currentThread() + "------");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {

            }
            System.out.println("-----" + Thread.currentThread() + "-----");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
    }
}
