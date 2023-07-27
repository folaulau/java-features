package com.folautech.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.github.javafaker.Faker;

/**
 * 
 * CompletableFuture was introduced in Java 8 and is part of the java.util.concurrent package. It represents a future
 * result of an asynchronous computation—a way to write non-blocking asynchronous code in Java.
 * 
 * The main advantage of using CompletableFuture is its ability to chain multiple asynchronous operations, handle
 * exceptions, combine results, and apply transformations without blocking the execution thread.
 * 
 */
public class Java8CompletableFuture {

    static Faker faker = new Faker();

    public static void main(String[] args) {
        System.out.println("Java8CompletableFuture");

        runAsync();
//
//        runSupplyAsync();

 //       runSupplyAsyncThen();
//
//        runWithCustomExecutor();

    }

    /***
     * The CompletableFuture.supplyAsync() method is a handy tool in Java's arsenal for asynchronous programming. It
     * provides a way to execute asynchronous computations that produce a result.
     * 
     * This method is used to initiate an asynchronous computation and return a CompletableFuture that will be completed
     * with the result of that computation. The computation itself is specified as a Supplier<T>, where T is the type of
     * the resulting value.
     * 
     * Key Takeaways:
     * 
     * CompletableFuture.supplyAsync() initiates a non-blocking, asynchronous computation.
     * 
     * By default, tasks execute in the ForkJoinPool.commonPool(), but you can provide your custom Executor.
     * 
     * It provides a more modern, fluent, and readable approach to asynchronous programming in Java, especially when
     * combined with other methods of CompletableFuture for chaining, combining, and handling results.
     */
    static void runSupplyAsync() {
        System.out.println("runSupplyAsync...");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulate some long-running task
            try {
                System.out.println("supplyAsync sleeping...");
                Thread.sleep(1500);
                System.out.println("supplyAsync done sleeping!");
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result";
        });

        // This will print immediately
        System.out.println("Waiting for the result...");

        String result = future.join();
        System.out.println("return result: " + result);

        System.out.println("runSupplyAsync done!");
    }

    static void runSupplyAsyncThen() {
        System.out.println("runSupplyAsyncThen...");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulate some long-running task
            try {
                System.out.println("supplyAsync sleeping...");
                Thread.sleep(1500);
                System.out.println("supplyAsync done sleeping!");
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result";
        }).thenApply(result -> {
            System.out.println("thenApply, result=" + result);
            return result + result;
        }).thenApply(result -> {
            System.out.println("thenApply, result=" + result);
            return result + result + result;
        });

        future.thenAccept(result -> {
            System.out.println("thenAccept, result=" + result);
        });

        // This will print immediately
        System.out.println("Waiting for the result...");

        String result = future.join();
        System.out.println("return result: " + result);

        System.out.println("runSupplyAsyncThen done!");
    }

    /***
     * While CompletableFuture.supplyAsync() is designed to initiate asynchronous computations that produce a result,
     * there are times when you want to perform an action that doesn't return anything. That's where
     * CompletableFuture.runAsync() comes in.
     * 
     * This method is used to run a Runnable task asynchronously. A Runnable doesn't return a result. Hence, the
     * CompletableFuture returned by runAsync() is of type Void.
     * 
     * 
     */
    static void runAsync() {
        System.out.println("runAsync...");
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            // Simulate some long-running task
            try {
                System.out.println("runAsync sleeping...");
                Thread.sleep(1500);
                System.out.println("runAsync done sleeping!");
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });

        // This will block until the future is completed (i.e., the Runnable has executed)
        future.join();

        System.out.println("runAsync done!");

    }

    static void runWithCustomExecutor() {
        System.out.println("runWithCustomExecutor...");

        Executor executor = Executors.newFixedThreadPool(2);

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            // Simulate some long-running task
            try {
                System.out.println("runAsync sleeping...");
                Thread.sleep(1500);
                System.out.println("runAsync done sleeping!");
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }, executor);

        // This will block until the future is completed (i.e., the Runnable has executed)
        future.join();

        System.out.println("runWithCustomExecutor done!");

    }

}
