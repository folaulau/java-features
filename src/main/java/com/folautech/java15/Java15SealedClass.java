package com.folautech.java15;

import com.github.javafaker.Faker;

/**
 * To give authors control over which classes can be subclasses, providing a more flexible alternative to final.
 */
public class Java15SealedClass {

    static Faker faker = new Faker();

    public static void main(String[] args) {
        System.out.println("Java15SealedClass");

    }

}

/**
 * The Shape interface is sealed, which means only the classes specified (Circle, Rectangle, and Square) can implement
 * it. The Square class is non-sealed, which means it can be further subclassed.
 * 
 *
 */
sealed interface Shape permits Circle, Rectangle {
}

final class Circle implements Shape {
    /* ... */ }

final class Rectangle implements Shape {
    /* ... */ }

// Square can't implements Shape as Shape is not permitted
// class Square implements Shape {
// /* ... */ }
