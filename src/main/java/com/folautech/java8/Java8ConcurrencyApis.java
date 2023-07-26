package com.folautech.java8;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.github.javafaker.Faker;

/**
 * 
 * 
 * 
 */
public class Java8ConcurrencyApis {

    static Faker                faker   = new Faker();

    static Map<String, Integer> numbers = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        System.out.println("Java8ConcurrencyApis");

        runConcurrentHashMap();
    }

    /***
     * The ConcurrentHashMap class is an important part of Java's Concurrency API, and it's an invaluable tool when you
     * need a thread-safe map implementation that offers better scalability and performance than Hashtable or
     * Collections.synchronizedMap.
     * 
     * ConcurrentHashMap is part of the java.util.concurrent package. It is a thread-safe and highly concurrent version
     * of HashMap. Unlike Hashtable or a synchronized version of HashMap, ConcurrentHashMap does not lock the entire map
     * for basic operations (like get and put). Instead, it divides the map into several segments and locks only the
     * necessary segment(s) for write operations, allowing a higher level of concurrency.
     * 
     * Key Features:
     * 
     * Segmented Locking: ConcurrentHashMap uses multiple locks (on segments) instead of locking the whole map. This
     * segmented design helps improve concurrency. Multiple threads can write to different segments concurrently without
     * contention.
     * 
     * Non-blocking Reads: Read operations (like get) are generally non-blocking and do not use locks.
     * 
     * Default Concurrency Level: By default, it breaks the map into 16 segments, which can be customized.
     * 
     * Nulls: ConcurrentHashMap does not permit the use of null keys or values. Attempting to store a null key or value
     * will throw a NullPointerException.
     * 
     * Fail-safe Iterators: The iterators created by ConcurrentHashMap are fail-safe. While they might not reflect the
     * latest changes to the map, they won't throw a ConcurrentModificationException like iterators from a
     * non-concurrent HashMap would.
     * 
     * Java 8 Enhancements:
     * 
     * With Java 8, ConcurrentHashMap received several new methods leveraging lambdas and functional interfaces:
     * 
     * compute(), computeIfAbsent(), computeIfPresent(): These methods allow atomic computation for a given key.
     * 
     * forEach(), reduce(), search(): Methods for bulk data operations.
     * 
     * merge(): Merges the given key/value pair with the current map.
     * 
     * When to Use:
     * 
     * ConcurrentHashMap is especially useful when you expect a lot of concurrent reads and writes to a map. It provides
     * a high level of concurrency and avoids potential bottlenecks, making it an excellent choice for multi-threaded
     * applications.
     * 
     * Things to Remember:
     * 
     * While ConcurrentHashMap is thread-safe, compound actions like "check-then-act" (e.g., map.contains(key) followed
     * by map.put(key, value)) are not atomic. You might still need external synchronization or use the atomic methods
     * provided.
     * 
     * Iterators of ConcurrentHashMap reflect the state of the map when they were created, not necessarily the latest
     * state of the map.
     * 
     * ConcurrentHashMap can consume more memory than HashMap due to its internal segmentation architecture.
     */
    static void runConcurrentHashMap() {

        numbers.put("One", 1);
        numbers.put("Two", 2);
        System.out.println(numbers.get("One")); // Outputs: 1

        // compute
        numbers.compute("One", (k, v) -> (v == null) ? 42 : v + 42);
        System.out.println(numbers.get("One")); // Outputs: 43

        // computeIfAbsent
        numbers.computeIfAbsent("Three", k -> 3);
        System.out.println(numbers.get("Three")); // Outputs: 3

        // forEach
        numbers.forEach((key, value) -> System.out.println(key + " = " + value));

    }
    
    

}
