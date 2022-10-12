package com.valya.homework;

import java.util.Arrays;

public class binarySearch {

    public static void main(String[] args) {

        int myArray[] = {2, 3, 5, 7, 8, 9, 10, 13, 15, 6};
        Arrays.sort(myArray);

        System.out.println(myArray.length);

        System.out.println(isInArray(6, myArray,0,myArray.length - 1));

    }

    public static boolean isInArray(int number, int[] array, int startIndex, int endIndex) {

        if(endIndex < startIndex) {
            return false;
        }

        if (startIndex == endIndex) {
            if (number == array[startIndex]) {
                return true;
            } else {
                return false;
            }
        }

        int middle = (startIndex + endIndex) / 2;

        if(number == array[middle]) {
            return true;
        } else if(number > array[middle]) {
                return isInArray(number, array, middle + 1, endIndex);
        } else {
                return isInArray(number, array, startIndex, middle - 1) ;
            }
        }
    }

