package com.folautech.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.folautech.java.Student;
import com.folautech.java.User;
import com.github.javafaker.Faker;

public class Java8Optional {

    static Faker faker = new Faker();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Java8Optional");

        isPresent();

        ifPresentOrElse();

        orElse();

        orElseThrow();

        orElseThrowEx();

        orElseGet();

        filter();

        map();

        flatMap();
    }

    /**
     * The Optional class provides the isPresent() method, which is used to check whether an Optional object contains a
     * non-null value or is empty (contains a null value). The isPresent() method returns a boolean value indicating
     * whether the Optional object holds a value.
     * 
     * 
     */
    static void isPresent() {
        System.out.println("isPresent...");

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = (firstName + lastName).toLowerCase() + "@gmail.com";

        User user = User.builder().firstName(firstName).lastName(lastName).email(email).phoneNumber(faker.phoneNumber().cellPhone()).build();

        System.out.println("User: " + user.toString());

        Optional<User> optUser = Optional.ofNullable(user);

        // Checking if the Optional object contains a value
        if (optUser.isPresent()) {
            System.out.println("User is present: " + optUser.get());
        } else {
            System.out.println("User is not present.");
        }

        user = null;

        optUser = Optional.ofNullable(user);

        // Checking if the Optional object contains a value
        if (optUser.isPresent()) {
            System.out.println("User is present: " + optUser.get());
        } else {
            System.out.println("User is not present.");
        }

        System.out.println("isPresent done!");
    }

    /***
     * The Optional class introduced the ifPresentOrElse() method. This method provides a concise way to perform an
     * action if the Optional object contains a value, and an alternative action if the Optional object is empty.
     */
    static void ifPresentOrElse() {
        System.out.println("ifPresentOrElse...");

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = (firstName + lastName).toLowerCase() + "@gmail.com";

        User user = User.builder().firstName(firstName).lastName(lastName).email(email).phoneNumber(faker.phoneNumber().cellPhone()).build();

        System.out.println("User: " + user.toString());

        Optional<User> optUser = Optional.ofNullable(user);

        optUser.ifPresentOrElse(u -> {
            System.out.println("user is present");
            System.out.println("User: " + u.toString());
        }, () -> {
            System.out.println("else");
        });

        user = null;
        optUser = Optional.ofNullable(user);

        optUser.ifPresentOrElse(u -> {
            System.out.println("user is present");
        }, () -> {
            System.out.println("user is null");
        });

        System.out.println("ifPresentOrElse done!");
    }

    static void orElse() {
        System.out.println("orElse...");

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = (firstName + lastName).toLowerCase() + "@gmail.com";

        User user = User.builder().firstName(firstName).lastName(lastName).email(email).phoneNumber(faker.phoneNumber().cellPhone()).build();

        System.out.println("User: " + user.toString());

        Optional<User> optUser = Optional.ofNullable(user);

        User u = optUser.orElse(User.builder().firstName("Test").build());

        System.out.println("User firstName: " + u.getFirstName());

        user = null;
        optUser = Optional.ofNullable(user);

        u = optUser.orElse(User.builder().firstName("Test").build());

        System.out.println("User firstName: " + u.getFirstName());

        System.out.println("orElse done!");
    }

    static void orElseThrow() {
        System.out.println("orElseThrow...");

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = (firstName + lastName).toLowerCase() + "@gmail.com";

        User user = User.builder().firstName(firstName).lastName(lastName).email(email).phoneNumber(faker.phoneNumber().cellPhone()).build();

        System.out.println("User: " + user.toString());

        Optional<User> optUser = Optional.ofNullable(user);

        User u = optUser.orElseThrow();

        user = null;
        optUser = Optional.ofNullable(user);

        try {
            u = optUser.orElseThrow();

            System.out.println("User firstName: " + u.getFirstName());
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }

        System.out.println("orElseThrow done!");
    }

    /**
     * The Optional class provides the orElseThrow() method, which is used to retrieve the value from an Optional object
     * if it is present. If the Optional is empty (contains a null value), orElseThrow() throws an exception of the
     * specified type.
     * 
     * The orElseThrow() method is useful when you expect the Optional to contain a value, and if it doesn't, you want
     * to handle the absence of the value with an exception. This is particularly helpful in situations where a missing
     * value is considered an exceptional case, and you want to raise a specific exception to signal that scenario.
     */
    static void orElseThrowEx() {
        System.out.println("orElseThrowEx...");

        User user = null;

        Optional<User> optUser = Optional.ofNullable(user);

        try {
            User u = optUser.orElseThrow(() -> new RuntimeException("optUser is null"));

            System.out.println("User firstName: " + u.getFirstName());
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }

        System.out.println("orElseThrowEx done!");
    }

    static void orElseGet() {
        System.out.println("orElseGet...");

        User user = null;

        Optional<User> optUser = Optional.ofNullable(user);

        User u = optUser.orElseGet(() -> {
            return User.builder().firstName("test").build();
        });

        System.out.println("User firstName: " + u.getFirstName());

        System.out.println("orElseGet done!");
    }

    /***
     * The Optional class provides the filter() method, which is used to conditionally process the value contained
     * within the Optional. The filter() method checks if the Optional contains a value that matches a given predicate
     * (a condition), and if so, it returns the same Optional object. If the Optional is empty (contains a null value)
     * or the predicate evaluates to false for the value, the filter() method returns an empty Optional.
     */
    static void filter() {
        System.out.println("filter...");

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = (firstName + lastName).toLowerCase() + "@gmail.com";

        User user = User.builder().firstName(firstName).lastName(lastName).email(email).phoneNumber(faker.phoneNumber().cellPhone()).build();

        System.out.println("User: " + user.toString());

        user = null;

        Optional<User> optUser = Optional.ofNullable(user);

        optUser = optUser.filter(u -> {
            System.out.println("running filter if value is not null");
            return u.getFirstName().length() > 0;
        });

        optUser.ifPresent(u -> {
            System.out.println("User firstName: " + u.getFirstName());
        });

        System.out.println("filter done!");
    }

    static void map() {
        System.out.println("map...");

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = (firstName + lastName).toLowerCase() + "@gmail.com";

        User user = User.builder().firstName(firstName).lastName(lastName).email(email).phoneNumber(faker.phoneNumber().cellPhone()).build();

        System.out.println("User: " + user.toString());

        user = null;

        Optional<User> optUser = Optional.ofNullable(user);

        Optional<String> optEmail = optUser.map(u -> {
            System.out.println("running map if value is not null");
            return u.getEmail();
        });

        optEmail.ifPresent(em -> {
            System.out.println("User email: " + em);
        });

        System.out.println("map done!");
    }

    static void flatMap() {
        System.out.println("flatMap...");

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = (firstName + lastName).toLowerCase() + "@gmail.com";

        User user = User.builder().firstName(firstName).lastName(lastName).email(email).phoneNumber(faker.phoneNumber().cellPhone()).build();

        System.out.println("User: " + user.toString());

        Optional<User> optUser = Optional.ofNullable(user);

        Optional<String> optEmail = optUser.flatMap(u -> {
            System.out.println("running flatmap if value is not null");
            return Optional.ofNullable(u.getEmail());
        });

        optEmail.ifPresent(em -> {
            System.out.println("User email: " + em);
        });

        System.out.println("flatMap done!");
    }
   

}
