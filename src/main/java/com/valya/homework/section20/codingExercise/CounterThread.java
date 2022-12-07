package com.valya.homework.section20.codingExercise;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterThread extends Thread {

    private AtomicInteger count = new AtomicInteger(0);

    public int getCount() {
        return count.get();
    }

    @Override
    public void run() {

        int maxValue = 100_000_000;

        for (int i = 0; i < maxValue; i++) {
            count.incrementAndGet();
        }

        System.out.println(Thread.currentThread().getName() + " finished. Count is " + count);

    }
}
