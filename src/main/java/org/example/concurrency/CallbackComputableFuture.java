package org.example.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by santoshsharma on 03 May, 2022, at 23:36
 */

public class CallbackComputableFuture {
    public static void main(String[] args) {
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(
            () -> {
                delaySecond(1);
                return "Hello";
            }
        ).thenApply(s -> {
            return s + " World";
        }).thenAccept(s -> {
            System.out.print("Result :" + s);
        }).thenRun(() -> System.out.println("!!"));

        completableFuture.join();
    }

    public static void delaySecond(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
