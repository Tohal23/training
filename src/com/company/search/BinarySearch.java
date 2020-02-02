package com.company.search;

public class BinarySearch {

    public static <T extends Comparable<T>> Integer search(T[] arr, T target) {
        int min = 0;
        int max = arr.length-1;

        while (min <= max) {
            int mid = (min + max)/2;

            if (target.compareTo(arr[mid]) < 0) max = mid -1;
            else if (target.compareTo(arr[mid]) > 0) min = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 4, 6, 8, 0, 11, 23, 43, 21, 6, 7};
        Integer target = 8;

        int findIndex = search(arr, target);
        System.out.println(target + " | " + findIndex + " | " + arr[findIndex]);
    }
}
