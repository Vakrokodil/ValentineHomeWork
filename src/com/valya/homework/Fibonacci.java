package com.valya.homework;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Fibonacci row length: ");
        int n = scanner.nextInt();
        System.out.println(Arrays.toString(getNumberFibonacci(n)));

        System.out.println("Enter index of number Fibonacci: ");
        int index = scanner.nextInt();
        System.out.println("Fibonacci number: " + numberFibonacci(index));

    }
    /*вывести первые n числа Фибоначчи*/
    public static long[] getNumberFibonacci(int n) {

        long[] arrayFibonacci = new long[n];

        for(int i = 0; i < n; i++) {
            if (i < 2) {
                arrayFibonacci[i] = i;
            }else {
                arrayFibonacci[i] = arrayFibonacci[i - 2] + arrayFibonacci[i - 1];
            }
        }
        return arrayFibonacci;
    }

    /*верни число Фибоначчи по индексу*/
    public static long numberFibonacci(int index) {

        if(index < 2) {
            return index;
        }
        return numberFibonacci(index - 2) + numberFibonacci(index - 1);

    }
}


