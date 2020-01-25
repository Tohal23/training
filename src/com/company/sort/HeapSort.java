package com.company.sort;

import com.company.struct.ThreadNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HeapSort {

    public static <T extends Comparable<T>> ArrayList<T> heapSort(T[] array) {
        ThreadNode<T> root = new ThreadNode<>();
        ArrayList<T> resultArray = new ArrayList<>(array.length);

        for (T t : array) {
            root.addNode(t);
        }

        boolean via_branch = true;
        while (root != null) {
            if (via_branch) {
                while (root.getLeftChild() != null) {
                    root = root.getLeftChild();
                }
            }

            resultArray.add(root.getValue());

            if (root.getRightChild() == null) {
                root = root.getRightThread();
                via_branch = false;
            } else {
                root = root.getRightChild();
                via_branch = true;
            }

        }

        return resultArray;
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
            ArrayList<Integer> arr2 = heapSort(Arrays.copyOf(testArray, testArray.length));
            long first = System.currentTimeMillis();

            //System.out.println(arr2.toString());

            System.out.println("First Sort: " + ((double) (first - before)) / 1000);
        }

    }

}
