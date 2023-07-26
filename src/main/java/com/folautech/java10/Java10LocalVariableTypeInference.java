package com.folautech.java10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import com.folautech.java.User;
import com.github.javafaker.Faker;

/***
 * Java Local Variable Type Inference, introduced in Java 10, allows you to declare local variables without explicitly
 * specifying their data types. Instead, you can use the "var" keyword, and the compiler will infer the data type based
 * on the context and the value being assigned to the variable. This feature is also known as "var" type or "var" local
 * variable.
 * 
 * 
 */
public class Java10LocalVariableTypeInference {

    static Faker faker = new Faker();

    /***
     * Some points to remember about Local Variable Type Inference:
     * 
     * The inferred type of the variable remains fixed once it's determined at compile time. It does not change based on
     * the value assigned to the variable.
     * 
     * The use of 'var' is limited to local variables inside methods or code blocks. It cannot be used for fields
     * (instance variables) or method parameters.
     * 
     * 'var' does not mean "variant" or "dynamic" typing. It's still statically typed, and the compiler will enforce
     * type safety during compilation.
     * 
     * While 'var' can improve code readability in some cases, it's essential to use it judiciously. Avoid using it in
     * cases where the type is not obvious, as it can harm code readability. Always prioritize code clarity and
     * maintainability over brevity.
     * 
     * Since Java is a compiled language, the 'var' keyword is only used during compilation to infer the type. The
     * compiled bytecode still contains the actual data type of the variable.
     * 
     */
    public static void main(String[] args) {
        // Before Java 10, you would declare variables like this:
        int num1 = 10;
        String message = "Hello, World!";
        double pi = 3.14159;

        // With Java 10 and onwards, you can use 'var':
        var num2 = 20; // 'num2' will be inferred as int.
        var greeting = "Hi!"; // 'greeting' will be inferred as String.
        var radius = 5.5; // 'radius' will be inferred as double.

        // You can also use 'var' with complex types:
        var list = new ArrayList<String>(); // 'list' will be inferred as ArrayList<String>.
        var map = new HashMap<Integer, String>(); // 'map' will be inferred as HashMap<Integer, String>.

        // 'var' can be used in loops:
        var numbers = new int[]{1, 2, 3, 4, 5};
        for (var number : numbers) {
            System.out.print(number + " "); // 'number' will be inferred as int.
        }

    }
}
