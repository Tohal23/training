package com.company.sort;

import java.util.Arrays;
import java.util.Random;

public class SimpleSort {

    public static <T extends Comparable<T>> T[] insertSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    T currentVar = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = currentVar;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    public static <T extends Comparable<T>> T[] selectSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int indexMinValue = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[indexMinValue]) < 0) {
                    indexMinValue = j;
                }
            }
            T swapElement = arr[i];
            arr[i] = arr[indexMinValue];
            arr[indexMinValue] = swapElement;
        }
        return arr;
    }

    public static <T extends Comparable<T>> T[] bubbleSort(T[] arr) {
        boolean loop = true;
        while (loop) {
            loop = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i].compareTo(arr[i-1]) < 0) {
                    T currentElement = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = currentElement;

                    loop = true;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int size = 1000;

        Integer[] testArray = new Integer[size];

        Random r = new Random();
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = r.nextInt();
        }

        long before = System.currentTimeMillis();
        Integer[] arr2 = bubbleSort(Arrays.copyOf(testArray, testArray.length));
        long first = System.currentTimeMillis();
        Integer[] arr = insertSort(Arrays.copyOf(testArray, testArray.length));
        long second = System.currentTimeMillis();
        Integer[] arr1 = selectSort(Arrays.copyOf(testArray, testArray.length));
        long third = System.currentTimeMillis();

        System.out.println("First Sort: " + ((double) (first - before)) / 1000);
        System.out.println("Second Sort: " + ((double) (second - first)) / 1000);
        System.out.println("Third Sort: " + ((double) (third - second)) / 1000);
    }
}
