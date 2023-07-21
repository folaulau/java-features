package com.folautech.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.folautech.java.Student;
import com.folautech.java.User;
import com.github.javafaker.Faker;

public class Java8Stream {

    static List<User> users         = new ArrayList<>();
    static int        numberOfUsers = 20;

    static Faker      faker         = new Faker();

    static {
        for (long i = 0; i < numberOfUsers; i++) {
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
        System.out.println("Java8Stream");

        doFilter();
        doMap();
        doFlatMap();
        doSort();
        doCount();
        doForEach();
        doFindFirst();

    }

    /**
     * The filter function filters based on a predicate(True/False).
     * 
     * The items that pass the predicate are passed on to the next stream.
     * 
     * Stream<T> filter(Predicate<? super T> predicate)
     */
    static void doFilter() {
        System.out.println("doFilter...");

        // filter on id that is greater than 3.

        List<User> filteredUsers = users.stream().filter(user -> {
            return user.getId() > 3;
        }).collect(Collectors.toList());

        filteredUsers.forEach(user -> {
            System.out.println("User: " + user.toString());
        });

        System.out.println("doFilter done!");
    }

    /**
     * Stream API provides the map() method, which is used to transform the elements of a stream from one type to
     * another. It takes a Function as an argument, which is a functional interface representing a function that
     * converts one value to another. The map() operation returns a new stream containing the transformed elements.
     * 
     * <R> Stream<R> map(Function<? super T, ? extends R> mapper)
     * 
     */
    static void doMap() {

        System.out.println("doMap...");

        // filter on id that is greater than 3.

        List<Student> mappedStudents = users.stream().map(user -> {

            // @formatter:off
            return Student.builder()
                        .id(user.getId())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .email(user.getEmail())
                        .phoneNumber(user.getPhoneNumber())
                    .build();
            // @formatter:on

        }).collect(Collectors.toList());

        mappedStudents.forEach(student -> {
            System.out.println("student: " + student.toString());
        });

        System.out.println("doMap done!");

    }

    /***
     * Stream API provides the flatMap() method, which is used to flatten a stream of streams into a single stream. It
     * takes a Function as an argument, which maps each element of the stream to another stream. The flatMap() operation
     * then concatenates or flattens these inner streams into a single output stream.
     * 
     * The flatMap() method is particularly useful when you have a stream of collections or arrays and want to operate
     * on the elements of those collections individually rather than on the entire collection as a single element.
     * 
     * 
     */
    static void doFlatMap() {
        System.out.println("doFlatMap...");

        // filter on id that is greater than 3.

        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));

        // @formatter:off
        // flatten a stream of streams into a single stream
        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        // @formatter:on

        flattenedList.forEach(number -> {
            System.out.println("number: " + number);
        });

        System.out.println("doFlatMap done!");
    }

    static void doSort() {

    }

    static void doCount() {

    }

    static void doForEach() {

    }

    static void doFindFirst() {

    }

}
