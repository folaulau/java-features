package com.folautech.java19;

import com.github.javafaker.Faker;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Java virtual threads (jthreads) are a new feature in Java 19. They are a lightweight alternative to platform threads
 * that can be used to improve the performance and scalability of Java applications.
 * 
 * jthreads are implemented using a technique called cooperative multitasking. This means that jthreads do not have
 * their own stack or heap, and they must explicitly yield control to other jthreads when they are blocked or waiting
 * for resources. This makes jthreads much lighter than platform threads, and it allows them to be scheduled more
 * efficiently by the Java Virtual Machine (JVM).
 * 
 * jthreads are also more scalable than platform threads. This is because jthreads can be multiplexed onto a single
 * platform thread, which means that a single platform thread can run multiple jthreads simultaneously. This can improve
 * the performance of Java applications that are heavily multithreaded
 * 
 * Characteristics of Virtual Threads:
 * 
 * Lightweight: Virtual threads don't have a dedicated stack in memory. They utilize a smaller, more efficient structure
 * that allows you to spawn millions of them without depleting system resources.
 * 
 * Managed by the JVM: The JVM, not the OS, schedules and oversees virtual threads. This translates to faster context
 * switches and better performance.
 * 
 * Cheap Blocking: Virtual threads can block without much overhead, making them excellent for I/O-bound tasks.
 * 
 * Concurrency Simplified: With virtual threads, many concurrent tasks can be written in a more straightforward and
 * readable manner.
 */
public class Java19VirtualThread {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        jthread1();
        jthread2();

        executorService.shutdown();

        /*
         * 
         * new Thread(() -> { System.out.println("Hello from a traditional thread!"); }).start();
         * 
         * Thread.startVirtualThread(() -> { System.out.println("Hello from a virtual thread!"); });
         * 
         */
    }

    private static void jthread1() {
        System.out.println("Starting jthread1...");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finishing jthread1...");
    }

    private static void jthread2() {
        System.out.println("Starting jthread2...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finishing jthread2...");
    }
}
