package com.folautech.java8;
import com.github.javafaker.Faker;

/**
 * 
 * Type annotations were mainly introduced to improve Java's type-checking capabilities at compile-time, thereby
 * ensuring better code robustness. For example, the Checker Framework utilizes type annotations to reduce bugs in Java
 * programs by adding pluggable type-checkers.
 * 
 */
public class Java8TypeAnnotation {

    static Faker faker = new Faker();

    public static void main(String[] args) {
        System.out.println("Java8TypeAnnotation");

        String name = null;

        sayHello(name);

    }

    static void sayHello(@NonNull String name) {
        System.out.println("Hello " + name + "!");
    }

}
