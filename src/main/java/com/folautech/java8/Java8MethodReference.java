package com.folautech.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import com.folautech.java.User;
import com.github.javafaker.Faker;

/***
 * Java method references are a shorthand notation of a lambda expression to call a method. They became available in
 * Java 8, just like lambdas and streams. Method references allow for a cleaner and more readable way to refer to
 * methods without executing them.
 *
 */
public class Java8MethodReference {

    static List<User> users         = new ArrayList<>();
    static int        numberOfUsers = 20;

    static Faker      faker         = new Faker();

    static {
        for (long i = 1; i <= numberOfUsers; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = (firstName + lastName).toLowerCase() + "@gmail.com";

            User user = User.builder().id(i).firstName(firstName).lastName(lastName).email(email).phoneNumber(faker.phoneNumber().cellPhone()).build();
            System.out.println("User: " + user.toString());
            users.add(user);
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Java8MethodReference");

        staticMethodReference();

        instanceMethodReference();

        constructorMethodReference();
    }

    /**
     * a reference to a static method is a type of method reference that allows you to reference and use a static method
     * of a class as a functional interface. It is denoted by ClassName::staticMethodName. This type of method reference
     * is useful when you want to pass a static method as an argument to a functional interface or use it in lambda
     * expressions.
     * 
     * ClassName::staticMethodName
     * 
     * 
     */
    static void staticMethodReference() {
        System.out.println("\nstaticMethodReference...");

        // Using lambda expression
        Arrays.asList("apple", "banana", "orange").forEach(str -> System.out.println(str.toUpperCase()));

        // Using method reference
        Arrays.asList("apple", "banana", "orange").forEach(Java8MethodReference::convertToUpperCase);

        // using static method to print out
        users.forEach(System.out::println);

        System.out.println("staticMethodReference done!");
    }

    public static void convertToUpperCase(String str) {
        System.out.println(str.toUpperCase());
    }

    /***
     * a reference to an instance method is a type of method reference that allows you to reference and use an instance
     * method of a particular object as a functional interface. It is denoted by instance::instanceMethodName. This type
     * of method reference is useful when you want to pass an instance method as an argument to a functional interface
     * or use it in lambda expressions.
     * 
     * instance::instanceMethodName
     * 
     */
    static void instanceMethodReference() {
        System.out.println("\ninstanceMethodReference...");

        List<String> fruits = Arrays.asList("apple", "banana", "orange");

        // Using lambda expression
        fruits.forEach(str -> {
            System.out.println("str: " + str + ",length: " + str.length());
        });

        Java8MethodReference java8MethodReference = new Java8MethodReference();

        // Using method reference
        fruits.forEach(java8MethodReference::printLength);

        System.out.println("instanceMethodReference done!");
    }

    public void printLength(String str) {
        System.out.println("str: " + str + ",length: " + str.length());
    }

    /**
     * a reference to a constructor is a type of method reference that allows you to reference and use a constructor of
     * a class as a functional interface. It is denoted by ClassName::new. This type of method reference is useful when
     * you want to pass a constructor as an argument to a functional interface or use it in lambda expressions.
     * 
     * ClassName::new
     */
    static void constructorMethodReference() {
        System.out.println("\nconstructorMethodReference...");

        // Using lambda expression
        Supplier<User> personLambda = () -> User.builder().firstName("John").lastName("Doe").build();
        User johnFromLambda = personLambda.get();
        System.out.println("User from lambda: " + johnFromLambda);

        // Using method reference
        Supplier<User> personMethodRef = User::new;
        User johnFromMethodRef = personMethodRef.get();
        System.out.println("User from method reference: " + johnFromMethodRef);

        System.out.println("constructorMethodReference done!");
    }

}
