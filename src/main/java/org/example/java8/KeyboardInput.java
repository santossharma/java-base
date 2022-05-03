package org.example.java8;

import java.util.Scanner;

public class KeyboardInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // for string
        String stringText = scanner.nextLine();
        System.out.println(stringText);

        // for integer
        int number = scanner.nextInt();
        System.out.println(number);

    }
}
