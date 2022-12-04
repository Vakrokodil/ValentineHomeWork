package com.valya.homework.section20.codingExercise.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class FutureMainD {

    private static int var;

    public static void main(String[] args)  {

        doTaskWithVar(3);
    }

    public static void doTaskWithVar (int countTask) {

        ExecutorService executorService = Executors.newFixedThreadPool(countTask);

        for (int i = 0; i < countTask; i++) {
            System.out.println("Task "  + (i + 1) + " started. ");

            MySuperCallable mySuperCallable = new MySuperCallable();
            Future<Integer> task = executorService.submit(mySuperCallable);
            try {
                task.get();
                System.out.println("Task " + (i + 1) + " finished. Var is " + var );
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Shutdown");
        executorService.shutdown();

        System.out.println("Var is " + var);

    }

    static class MySuperCallable implements Callable<Integer> {
        int maxValue = 100_000_000;

        @Override
        public Integer call() {

            for (int i = 0; i < maxValue; i++) {
                var++;
            }
            return var;
        }
    }
}





