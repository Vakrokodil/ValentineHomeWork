package com.valya.homework.section20.codingExercise.future;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureMainNew {

    private static int count;
    private static int countTest;

    public static int getCount() {
        return count;
    }

    public static void main(String[] args)  {

        Random random = new Random();

        int [] numbers = new int[100_000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
            countTest += numbers[i];
        }


        try {
            count = calculateSum(6, numbers);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Sum is " + count);
        System.out.println("Sum Test is " + countTest);
    }

    public static int calculateSum (int countTask, int[] numbers) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(countTask);

        List<MySuperCallable> tasks = new ArrayList<>();
        List<Future<Integer>> futures;

        int lenPart = numbers.length / countTask;
        int start;
        int end = 0;

        for (int i = 0; i < countTask; i++) {
            System.out.println("Task " + (i + 1) + " created. ");

            start = end;

            if (i == countTask - 1) {
                end = numbers.length;
            } else {
                end += lenPart;
            }

            tasks.add(new MySuperCallable(numbers, start, end));

        }

        try {
            System.out.println("Invoke all tasks.");
            futures = executorService.invokeAll(tasks);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int result = 0;

        for (Future<Integer> future : futures) {
            result += future.get();
        }

        System.out.println("Shutdown");
        executorService.shutdown();

        return result;
    }

    static class MySuperCallable implements Callable<Integer> {

        int[] numbers;
        int start;
        int end;

        public MySuperCallable(int[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() {

            int sum = 0;

            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        }
    }
}