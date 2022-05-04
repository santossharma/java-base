package org.example.concurrency;

import java.util.concurrent.CompletableFuture;

/**
 * Created by santoshsharma on 04 May, 2022
 */

public class ExceptionHandling {
    public static void main(String[] args) {
        CompletableFuture<String> futureExceptionHandlingUsingHandle = CompletableFuture.supplyAsync(()-> {
            try {
                if (10 / 0 == 0) {
                    System.out.println("will never print this line");
                }
            }  catch (ArithmeticException ae) {
                ae.printStackTrace();
                throw new RuntimeException(ae.getMessage());
            }
           return "Success";
        }).handle((futureOutput, exception) -> {
            if(exception != null) {
                System.out.println("There is some issue at the moment!! " + exception.getMessage());
            }
            return futureOutput;
        });

        System.out.println(futureExceptionHandlingUsingHandle.join());

        CompletableFuture<String> futureExceptionHandlingUsingExceptionally = CompletableFuture.supplyAsync(()-> {
            try {
                if (10 / 0 == 0) {
                    System.out.println("will never print this line");
                }
            }  catch (ArithmeticException ae) {
                ae.printStackTrace();
                throw new RuntimeException(ae.getMessage());
            }
            return "Success";
        }).exceptionally((exception) -> {
            return "There is some issue at the moment!! " + exception.getMessage();
        });

        System.out.println(futureExceptionHandlingUsingExceptionally.join());


    }
}
