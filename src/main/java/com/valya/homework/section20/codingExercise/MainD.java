package com.valya.homework.section20.codingExercise;

public class MainD {
    public static void main(String[] args) throws InterruptedException {

        long before = System.currentTimeMillis();

        CounterThread counter = new CounterThread();

        Thread firstThread = new Thread(counter, "First");
        Thread secondThread = new Thread(counter, "Second");
        Thread thirdThread = new Thread(counter, "Third");

        firstThread.start();
        secondThread.start();
        thirdThread.start();

        firstThread.join();
        secondThread.join();
        thirdThread.join();

        System.out.println("Counter is " + counter.getCount());

        long after = System.currentTimeMillis();
        System.out.println("Program took " + (after - before) + " ms to run");

        ///////

        long before2 = System.currentTimeMillis();

        SynchronizedThread synchronizedThread = new SynchronizedThread();

        Thread thread1 = new Thread(synchronizedThread, "ONE");
        Thread thread2 = new Thread(synchronizedThread, "TWO");
        Thread thread3 = new Thread(synchronizedThread, "THREE");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Var is " + synchronizedThread.getVar());

        long after2 = System.currentTimeMillis();
        System.out.println("Program took " + (after2 - before2) + " ms to run");
    }
}