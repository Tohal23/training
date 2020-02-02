package com.company.search;

public class InterpolationSearch {

    public static Integer search(Integer[] array, Integer target) {
        int startIndex = 0;
        int lastIndex = array.length-1;

        while ((startIndex <= lastIndex) && (target >= array[startIndex]) &&
                (target <= array[lastIndex])) {

            int pos = startIndex + (((lastIndex-startIndex) /
                    (array[lastIndex]-array[startIndex]))*
                    (target - array[startIndex]));

            if (array[pos] == target)
                return pos;

            if (array[pos] < target)
                startIndex = pos + 1;

            else
                lastIndex = pos - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = {0, 1, 4, 6, 6, 7, 8, 11, 21, 23, 43};
        Integer target = 8;

        int findIndex = search(arr, target);
        System.out.println(target + " | " + findIndex + " | "+ arr[findIndex]);
    }
}
