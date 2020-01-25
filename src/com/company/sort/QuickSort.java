package com.company.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static <T extends Comparable<T>> void sort(T[] arr, int start, int end) {
        if (start < end) {
            T divider = arr[start];

            int lo = start;
            int hi = end;

            while (true) {
                while (divider.compareTo(arr[hi]) < 0 || divider.compareTo(arr[hi]) < 0) {
                    hi--;
                    if (hi <= lo) break;
                }
                if (hi <= lo) {
                    arr[lo] = divider;
                    break;
                }

                arr[lo] = arr[hi];

                lo++;

                while (divider.compareTo(arr[lo]) > 0) {
                    lo++;
                    if (lo >= hi) break;
                }
                if (lo >= hi) {
                    lo = hi;
                    arr[hi] = divider;
                    break;
                }

                arr[hi] = arr[lo];
            }

            sort(arr, start, lo -1);
            sort(arr, lo + 1, end);
        }
    }

    public static void main(String[] args) {
        for (int j = 0; j < 100; j++) {
            int size = 1000000;

            Integer[] testArray = new Integer[size];

            Random r = new Random();

            for (int i = 0; i < testArray.length; i++) {
                testArray[i] = r.nextInt();
            }

            long before = System.currentTimeMillis();
            sort(testArray,0, testArray.length-1);
            long first = System.currentTimeMillis();

            //System.out.println(Arrays.toString(testArray));

            System.out.println("First Sort: " + ((double) (first - before)) / 1000);
        }
    }

}
