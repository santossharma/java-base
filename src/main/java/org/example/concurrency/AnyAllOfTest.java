package org.example.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by santoshsharma on 04 May, 2022
 */

public class AnyAllOfTest {
    public static void delaySecond(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        CompletableFuture<Void> allOfFuture = CompletableFuture.allOf(futureOne(), futureTwo(), futureThree());
        System.out.println(allOfFuture.join());

        CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(futureOne(), futureTwo(), futureThree());
        System.out.println(anyOfFuture.join());
    }

    public static CompletableFuture<String> futureOne() {
        return CompletableFuture.supplyAsync(()-> {
            System.out.println("Future One : " + Thread.currentThread().getName());
            delaySecond(2);
            return "Return from future one";
        });
    }

    public static CompletableFuture<String> futureTwo() {
        return CompletableFuture.supplyAsync(()-> {
            System.out.println("Future Two : " + Thread.currentThread().getName());
            delaySecond(1);
            return "Return from future two";
        });
    }

    public static CompletableFuture<String> futureThree() {
        return CompletableFuture.supplyAsync(()-> {
            System.out.println("Future Three : " + Thread.currentThread().getName());
            delaySecond(3);
            return "Return from future three";
        });
    }
}
