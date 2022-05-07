package org.example.algo.array;

/**
 * Created by santoshsharma on 06 May, 2022
 *
 * Write a program to reverse an array or string
 */

public class ReverseAnArray<T> {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6};
        ArrayUtil<Integer> intArrayUtil = new ArrayUtil<Integer>(arr);

        intArrayUtil.printArray();
        intArrayUtil.reverseArray();
        intArrayUtil.printArray();

        String[] strArray = {"S", "A", "N", "T", "O", "S", "H"};
        ArrayUtil<String> strArrayUtil = new ArrayUtil<String>(strArray);
        strArrayUtil.reverseArray();
        strArrayUtil.printArray();
    }
}
