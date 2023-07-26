package com.folautech.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.github.javafaker.Faker;

public class Java11NewFileMethods {

    static Faker faker = new Faker();

    public static void main(String[] args) {

        runWriteAndReadString();

        runIsSameFile();

        runMismatch();
    }

    /**
     * These methods provide a straightforward way to write and read a String to and from a file.
     */
    static void runWriteAndReadString() {
        System.out.println("runWriteAndReadString...");
        Path path = Path.of("sample.txt");

        // Write a String to a file
        try {
            Files.writeString(path, "Hello, Java 11!");
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // Read the String from a file
        String content = null;
        try {
            content = Files.readString(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("readString content: "+content); // Outputs: Hello, Java 11!

        System.out.println("runWriteAndReadString done!");
    }

    /**
     * This isn't exactly a new method in Java 11, but it's still relatively modern and often overlooked. It checks if
     * two paths locate the same file. This can be useful for checking symbolic links pointing to the same file or
     * verifying if two paths, which may be different strings, refer to the same file.
     */
    static void runIsSameFile() {

        System.out.println("runIsSameFile...");
        Path path1 = Path.of("java9-test1.txt");
        Path path2 = Path.of("java9-test2.txt"); // Assuming this refers to the same file

        boolean isSameFile = false;
        try {
            isSameFile = Files.isSameFile(path1, path2);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("isSameFile: "+isSameFile); // true if they point to the same file, false otherwise

        System.out.println("runIsSameFile done!");
    }

    /**
     * This method compares the contents of two files to determine if there's a mismatch between them. It returns the
     * position of the first mismatch or -1 if no mismatch is found. This is efficient as the comparison stops once a
     * mismatch is found.
     */
    static void runMismatch() {
        System.out.println("runMismatch...");

        Path path1 = Path.of("java9-test1.txt");
        Path path2 = Path.of("java9-test2.txt");

        long mismatchPosition = 0;
        try {
            mismatchPosition = Files.mismatch(path1, path2);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (mismatchPosition == -1L) {
            System.out.println("The files have the same content.");
        } else {
            System.out.println("The files differ starting at position: " + mismatchPosition);
        }
        System.out.println("runMismatch done!");

    }

}
