package org.example.algo.array;

/**
 * Created by santoshsharma on 06 May, 2022
 */

public class ArrayUtil<T> {
    private T[] arr;

    public ArrayUtil(T[] arr) {
        this.arr = arr;
    }

    public void reverseArray() {
        int start = 0;
        int end = arr.length-1;
        T tmp;

        while (start < end) {
            //System.out.println("Start "+start+ " End "+end);
            tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp; // swap
            start++; // -->
            end--; // <--
        }
        //System.out.println("Start "+start+ " End "+end);
    }

    public void printArray() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
