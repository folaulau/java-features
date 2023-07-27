package com.folautech.java14;

import java.util.Random;

import com.github.javafaker.Faker;

/**
 * Pattern Matching for instanceof is one of the steps Java has taken towards making the language more expressive and
 * reducing boilerplate. Introduced as a preview feature in Java 14 and then refined in later versions, it combines the
 * instanceof operator with a pattern variable, removing the need for redundant type-casting.
 * 
 * Benefits:
 * 
 * Reduces Boilerplate: The new approach cuts down the amount of code you have to write and makes it more readable.
 * 
 * Reduces Errors: By eliminating the manual casting step, there's less room for casting errors.
 * 
 * Scope of Pattern Variable: The pattern variable (str in our example) has a limited scope. It's only in scope and
 * assigned a value when the instanceof test is true.
 *
 */
public class Java14InstanceOfPatternMatching {

    static Faker faker = new Faker();

    public static void main(String[] args) {
        System.out.println("Java14InstanceOfPatternMatching");

        Object obj = "hello";

        // old way
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println("Length of string: " + str.length());
        }

        /**
         * 
         * pattern matching
         * 
         * 
         * After checking if obj is an instance of String, you can immediately use the str variable, which is
         * automatically of type String. The casting is implicitly done for you.
         */
        if (obj instanceof String str) {
            System.out.println("Length of string: " + str.length());
        }

    }

}
