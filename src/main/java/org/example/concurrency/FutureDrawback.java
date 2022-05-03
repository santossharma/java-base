package org.example.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by santoshsharma on 03 May, 2022, at 10:46
 *
 * - It cannot be completed manually, if any delay from API call is happening and want to complete manually, we do not have option to do so.
 * - Multiple Futures cannot be chained together
 * - We cannot combine multiple Futures together
 * - No proper exception handling mechanism
 */

public class FutureDrawback {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<List<Integer>> future = executorService.submit(() -> Arrays.asList(1, 2, 3, 4));

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        /* No proper exception handling mechanism */
        Future<List<Integer>> futureWithException = executorService.submit(()-> {
            System.out.println(10/0);
            return Arrays.asList(1, 2, 3, 4);
        });
        try {
            System.out.println(futureWithException.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
