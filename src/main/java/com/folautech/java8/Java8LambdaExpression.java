package com.folautech.java8;

import com.folautech.java.User;
import com.github.javafaker.Faker;

/**
 * 
 * Lambda Expressions are a significant feature introduced to enable functional programming in the language. Lambda
 * expressions allow you to treat functions as first-class citizens, making it easier to express behavior as data, and
 * to pass functions as arguments to methods, return them from methods, or assign them to variables.
 * 
 * A Lambda Expression is a concise way to represent an anonymous function—a function without a name, often referred to
 * as a "lambda." It consists of parameters, an arrow ->, and a body.
 * 
 * Syntax of a Lambda Expression:
 * 
 * (parameters) -> { body }
 * 
 */
public class Java8LambdaExpression {

    static Faker faker = new Faker();

    /**
     * Lambda expressions can be used wherever a functional interface is expected. A functional interface is an
     * interface that contains only one abstract method, often referred to as a "single abstract method" (SAM)
     * interface. These interfaces are also known as functional interfaces because they can be used with lambda
     * expressions.
     * 
     * Lambda expressions greatly improve code readability and provide a more concise way to define simple functions or
     * actions. They are widely used in combination with functional interfaces, making it easier to work with
     * collections, streams, and other functional programming constructs introduced in Java 8 and beyond.
     */

    public static void main(String[] args) {
        System.out.println("Java8LambdaExpression");

        UserRegistration userRegistration = (user) -> {

            // 1. run validations

            if (user == null) {
                throw new RuntimeException("User must not be null.");
            }

            if (user.getEmail() == null) {
                throw new RuntimeException("Email must not be null.");
            }

            // 2. save user to db

            user.setId(faker.number().randomNumber());

            // 3. send welcome email

            return user;
        };

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = (firstName + lastName).toLowerCase() + "@gmail.com";

        User user = User.builder().firstName(firstName).lastName(lastName).email(email).phoneNumber(faker.phoneNumber().cellPhone()).build();

        System.out.println("User: " + user.toString());

        User signedUpUser = userRegistration.signUp(user);

        System.out.println("Signed Up User: " + signedUpUser);

    }

}

interface UserRegistration {
    User signUp(User user);
}
