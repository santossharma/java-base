package org.example.random;

import java.util.List;

public class Palindrome {
    public static void main(String[] args) {
        int number = 1311, reverseNumber = 0;
        int originalNumber = number;

        while (number > 0) {
            int remainder = number % 10;
            reverseNumber = reverseNumber * 10 + remainder;
            number = number / 10;
        }

        if(originalNumber == reverseNumber) {
            System.out.println("Its Palindrome !");
        } else {
            System.out.println("Its Not Palindrome !");
        }

    }
}
