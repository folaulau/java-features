package com.folautech.java9;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;
import com.folautech.java.User;
import com.github.javafaker.Faker;

/***
 * 
 */
public class Java9CollectionFactoryMethod {

    static Faker faker = new Faker();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Java9CollectionFactoryMethod");

        runList();
        runSet();
        runMap();
    }

    /***
     * Things to Note:
     * 
     * Immutable Collections: The collections created using these factory methods are immutable. Any attempt to modify
     * them (e.g., add, remove, put) will throw an UnsupportedOperationException.
     * 
     * List<String> list = List.of("A", "B");
     * 
     * list.add("C"); // Throws UnsupportedOperationException
     * 
     * 
     * Disallowing Nulls: These collections do not allow null elements or keys. Trying to add a null will result in a
     * NullPointerException at the time of creation.
     * 
     * List<String> list = List.of("A", null); // Throws NullPointerException
     * 
     * Order Preservation:
     * 
     * For List, the order of elements remains the same as the order in which they're provided. For Set, the order is
     * also preserved, which is a departure from some other set implementations that don't guarantee order.
     * 
     * Efficiency:
     * 
     * The factory methods are memory-efficient compared to other methods of creating collections, especially for
     * small-sized collections.
     */
    static void runList() {
        System.out.println("runList...");
        // before
        List<String> letters = Collections.unmodifiableList(Arrays.asList("A", "B", "C"));

        letters.forEach(System.out::println);

        // now
        letters = List.of("A", "B", "C");

        letters.forEach(System.out::println);

        System.out.println("runList done!");
    }

    static void runSet() {
        System.out.println("runSet...");

        Set<String> letters = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("A", "B", "C")));
        letters.forEach(System.out::println);

        letters = Set.of("A", "B", "C");
        letters.forEach(System.out::println);

        System.out.println("runSet done!");

    }

    static void runMap() {
        System.out.println("runMap...");
        // before java 9
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map = Collections.unmodifiableMap(map);

        map.forEach((key, value) -> {
            System.out.println("key:" + key + ", value:" + value);
        });

        // now
        map = Map.of("A", 1, "B", 2);

        map.forEach((key, value) -> {
            System.out.println("key:" + key + ", value:" + value);
        });

        map = Map.ofEntries(Map.entry("A", 1), Map.entry("B", 2), Map.entry("C", 3));

        map.forEach((key, value) -> {
            System.out.println("key:" + key + ", value:" + value);
        });

        System.out.println("runMap done!");

    }

}
