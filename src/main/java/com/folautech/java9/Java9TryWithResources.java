package com.folautech.java9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import com.folautech.java.User;
import com.github.javafaker.Faker;

/***
 * The try-with-resources feature in Java is an enhancement to the try statement that simplifies exception handling and
 * resource management. Resources here refer to objects that must be explicitly closed after their operations are
 * complete, such as streams, sockets, or database connections.
 * 
 * Basic Principles: AutoCloseable Interface: For an object to be used with try-with-resources, it must implement the
 * AutoCloseable or Closeable interface. These interfaces have a single method named close() that is called
 * automatically at the end of the try block.
 * 
 * Resource Declaration: The resource is declared in the parentheses after the try keyword, making the resource
 * available within the following block and ensuring it's closed once the block is exited.
 * 
 * Multiple Resources: You can declare multiple resources in the try-with-resources statement, separated by semicolons.
 *
 */
public class Java9TryWithResources {

    static Faker faker = new Faker();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Java9TryWithResources");

        runSingleFile();

        runWriteFromOneFileToAnother();
    }

    static void runSingleFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("java9-test.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

    static void runWriteFromOneFileToAnother() {
        System.out.println("runWriteFromOneFileToAnother...");
        try (FileInputStream fis = new FileInputStream("java9-test1.txt"); FileOutputStream fos = new FileOutputStream("java9-test2.txt")) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        System.out.println("runWriteFromOneFileToAnother done!");

    }

}
