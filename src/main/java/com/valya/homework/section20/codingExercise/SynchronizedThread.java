package com.valya.homework.section20.codingExercise;

public class SynchronizedThread implements Runnable{

    private int var;

    public int getVar() {
        return var;
    }

    final Object lock = new Object();

    private void increment() {
        synchronized (lock) {
            var++;
        }
    }

    @Override
    public void run() {
        int maxValue = 100_000_000;

        for (int i = 0; i < maxValue; i++) {
            increment();
        }

        System.out.println(Thread.currentThread().getName() + " finished. Count is " + var);
    }
}
