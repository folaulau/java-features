package com.folautech.java11;

import com.github.javafaker.Faker;

public class Java11NewStringMethods {

    static Faker faker = new Faker();

    public static void main(String[] args) {

        runIsBlank();

        runStrip();

        runStringLines();

        runStringRepeat();
    }

    /**
     * This method checks if a string is empty or contains only white spaces.
     */
    static void runIsBlank() {
        System.out.println("runIsBlank...");
        String str1 = "";
        String str2 = "    ";
        String str3 = "hello";
        System.out.println(str1.isBlank()); // true
        System.out.println(str2.isBlank()); // true
        System.out.println(str3.isBlank()); // false

        System.out.println("runIsBlank done!");
    }

    /**
     * These methods remove whitespace from the beginning and/or end of a string. While they may seem similar to trim(),
     * they are Unicode-aware and handle a wider range of whitespace characters.
     */
    static void runStrip() {

        System.out.println("runIsBlank...");
        String str = "  hello  ";
        System.out.println("[" + str.strip() + "]"); // [hello]
        System.out.println("[" + str.stripLeading() + "]"); // [hello ]
        System.out.println("[" + str.stripTrailing() + "]"); // [ hello]

        System.out.println("runStrip done!");
    }

    /**
     * This method returns a stream of lines extracted from the string, separated by line terminators.
     */
    static void runStringLines() {
        System.out.println("runIsBlank...");

        String multiLineStr = "Line1\nLine2\nLine3";
        multiLineStr.lines().forEach(System.out::println);
        /*
         * Output: Line1 Line2 Line3
         */
        System.out.println("runStringLines done!");

    }

    /**
     * This method returns a string whose value is the concatenation of this string repeated the given number of times.
     */
    static void runStringRepeat() {
        System.out.println("runIsBlank...");
        String str = "abc";
        System.out.println(str.repeat(3)); // abcabcabc

        System.out.println("runStringRepeat done!");
    }
}
