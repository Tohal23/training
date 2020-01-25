package com.company.sort;

import java.lang.reflect.Array;
import java.util.Random;

public class MergeSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        @SuppressWarnings("unchecked")
        T[] scratchArr = (T[]) Array.newInstance(arr[0].getClass(), arr.length);
        merge(arr, scratchArr, 0, arr.length-1);
    }

    private static <T extends Comparable<T>> void merge(T[] arr, T[] scratch, int start, int end) {
        if (start != end) {
            int midpoint = (start + end) / 2;

            merge(arr, scratch, start, midpoint);
            merge(arr, scratch, midpoint+1, end);

            int leftIndex = start;
            int rightIndex = midpoint + 1;
            int scratchIndex = leftIndex;

            while (leftIndex <= midpoint && rightIndex <= end) {
                if (arr[leftIndex].compareTo(arr[rightIndex]) <= 0) {
                    scratch[scratchIndex] = arr[leftIndex];
                    leftIndex++;
                } else {
                    scratch[scratchIndex] = arr[rightIndex];
                    rightIndex++;
                }
                scratchIndex++;
            }

            for (int i = leftIndex; i <= midpoint; i++) {
                scratch[scratchIndex] = arr[i];
                scratchIndex++;
            }
            for (int i = rightIndex; i <= end; i++) {
                scratch[scratchIndex] = arr[i];
                scratchIndex++;
            }

            if (end + 1 - start >= 0) System.arraycopy(scratch, start, arr, start, end + 1 - start);
        }
    }

    public static void main(String[] args) {
        int size = 1000000;

        for (int j = 0; j < 15; j++) {
            Integer[] testArray = new Integer[size];

            Random r = new Random();

            for (int i = 0; i < testArray.length; i++) {
                testArray[i] = r.nextInt();
            }

            long before = System.currentTimeMillis();
            sort(testArray);
            long first = System.currentTimeMillis();

            //System.out.println(Arrays.toString(testArray));

            System.out.println("First Sort: " + ((double) (first - before)) / 1000);
        }
    }

}
