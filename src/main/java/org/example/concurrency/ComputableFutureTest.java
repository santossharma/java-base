package org.example.concurrency;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by santoshsharma on 03 May, 2022, at 15:49
 */

public class ComputableFutureTest {
    private static final String THREAD_NAME = "Employee_Thread_Pool_";

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ComputableFutureTest computableFuture = new ComputableFutureTest();
        computableFuture.saveEmployee(new File("employeeData.json"));

        computableFuture.saveEmployeeWithCustomExecutor(new File("employeeData.json"));

    }

    public void saveEmployee(File jsonFile) throws ExecutionException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();

        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(()-> {
            try {
                List<Employee> employees = objectMapper.readValue(jsonFile, new TypeReference<List<Employee>>() {});
                System.out.println("Thread: " + Thread.currentThread().getName());

                employees.stream().forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        runAsync.get();
    }

    public void saveEmployeeWithCustomExecutor(File jsonFile) throws ExecutionException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        ExecutorService customExecutorService = Executors.newFixedThreadPool(5, new CustomThreadFactory(THREAD_NAME));

        System.out.println("\nUsing Custom Thread Pool");
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(()-> {
            try {
                List<Employee> employees = objectMapper.readValue(jsonFile, new TypeReference<List<Employee>>() {});
                System.out.println("Thread: " + Thread.currentThread().getName());

                employees.stream().forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, customExecutorService);

        runAsync.get();
        customExecutorService.shutdown();
    }

    private class CustomThreadFactory implements ThreadFactory {
        private int counter = 0;
        private String threadName;

        public CustomThreadFactory(String threadName) {
            this.threadName = threadName;
        }

        @Override public Thread newThread(Runnable runnable) {
            return new Thread(runnable, threadName + counter++);
        }
    }
}

