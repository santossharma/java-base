package org.example.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by santoshsharma on 03 May, 2022, at 23:29
 */

public class AsyncTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Runnable runnable = () -> {
          delaySecond(2);
            System.out.println("Inside runnable using thread " + Thread.currentThread().getName());
        };

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(runnable);

        System.out.println("Inside Main using thread " + Thread.currentThread().getName());
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
