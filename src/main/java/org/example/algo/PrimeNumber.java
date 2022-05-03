package org.example.algo;

import java.util.stream.IntStream;

/* Print all prime numbers less than or equal to N */
public class PrimeNumber {
    public static void main(String[] args) {
        int n = 25;
        printPrimeNumber(n);
    }

    static boolean isPrime(int n) {
        // Corner case
        if (n <= 1) {
            return false;
        }

        // Check from 2 to n-1
        return IntStream.range(2, n).noneMatch(i -> n % i == 0);

        /*for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;*/
    }

    // Function to print primes
    static void printPrimeNumber(int n) {
        IntStream.rangeClosed(2, n).filter(PrimeNumber::isPrime).mapToObj(i -> i + " ").forEachOrdered(System.out::print);

        System.out.println();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i*i + " ");
            }
        }
    }
}
