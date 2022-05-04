package org.example.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by santoshsharma on 03 May, 2022, at 23:50
 */

public class ComposeCompletableFuture {

    public static void delaySecond(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        CompletableFuture<String> greetedCompletableFuture = getAuthenticatedUser()
                .thenCompose(user -> greetUser(user));

        System.out.println("Some task running in Main method..");
        delaySecond(2);
        System.out.println(greetedCompletableFuture.join());
        System.out.println("Total time spent : " + (System.currentTimeMillis() - startTime)/1000 + " seconds");


        CompletableFuture<Integer> firstNumberFuture = CompletableFuture.supplyAsync(()-> 5);
        CompletableFuture<Integer> secondNumberFuture = CompletableFuture.supplyAsync(()-> 15);
        CompletableFuture<Integer> combineFuture = firstNumberFuture
                .thenCombine(secondNumberFuture, (firstFutureOutput, secondFutureOutput) -> firstFutureOutput + secondFutureOutput);

        System.out.println("Total Value : " + combineFuture.join());

        /*CompletableFuture<String> mixedFuture = combineFuture.thenCompose(n->getAuthenticatedUser()).thenCompose(user -> greetUser(user));
        System.out.println("Mixed : " + mixedFuture.join());*/
    }

    private static CompletableFuture<AuthenticatedUser> getAuthenticatedUser() {
        return CompletableFuture.supplyAsync(()-> {
            System.out.println("Getting/fetching UserDetail()");
            delaySecond(4);
            return createAuthenticatedUser();
        });
    }

    private static CompletableFuture<String> greetUser(AuthenticatedUser user) {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()-> {
            System.out.println("Preparing greeting..");
            delaySecond(3);
            return "Hello " + user.getName();
        });

        return completableFuture;
    }

    private static AuthenticatedUser createAuthenticatedUser() {
        return AuthenticatedUser.builder()
                .userId(1001)
                .name("Java Concurrent User")
                .roleIds(new int []{1,2,3})
                .build();
    }
}
