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

public class Java8Stream {

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
        System.out.println("Java8Stream");

        doFilter();
        doMap();
        doFlatMap();
        doSort();
        doCount();
        doForEach();
        doFindFirst();
        doAnyMatch();
        doAllMatch();
        doDistinct();

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

        List<Student> mappedStudents = users.stream().map(user -> {

            // @formatter:off
            // map user to student
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

        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));

        // @formatter:off
        // flatten a stream of streams into a single stream
        // flatmap function must return a stream
        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        // @formatter:on

        flattenedList.forEach(number -> {
            System.out.println("number: " + number);
        });

        System.out.println("doFlatMap done!");
    }

    /***
     * he Stream API provides the sorted() method, which is used to sort the elements of a stream based on a specified
     * comparator or the natural ordering of the elements. The sorted() method returns a new stream with the elements
     * sorted according to the specified criteria.
     * 
     * Stream<T> sorted()
     * 
     * Stream<T> sorted(Comparator<? super T> comparator)
     * 
     */
    static void doSort() {
        System.out.println("doSort...");

        List<User> sortedUsers = users.stream()
        // @formatter:off
                .sorted(new Comparator<User>() {
                    @Override
                    public int compare(User u1, User u2) {
                        return u1.getFirstName().compareTo(u2.getFirstName());
                    }
                })
//                .sorted(Comparator.comparingLong(User::getId))
                // @formatter:on
                .collect(Collectors.toList());

        sortedUsers.forEach(user -> {
            System.out.println("user: " + user.toString());
        });

        System.out.println("doSort done!");
    }

    static void doCount() {

        System.out.println("doCount...");

        long count = users.stream().count();

        System.out.println("count: " + count);

        System.out.println("doCount done!");
    }

    static void doForEach() {
        System.out.println("doForEach...");

        users.forEach(user -> {
            System.out.println("user: " + user.toString());
        });

        System.out.println("doForEach done!");
    }

    static void doFindFirst() {
        System.out.println("doFindFirst...");

        Optional<User> optUser = users.stream().findFirst();

        optUser.ifPresent(user -> {
            System.out.println("user: " + user.toString());
        });

        System.out.println("doFindFirst done!");
    }

    /***
     * Stream API provides the anyMatch() method, which is used to check if any element in the stream satisfies a given
     * condition or predicate.
     * 
     * It returns a boolean value indicating whether at least one element in the stream matches the specified condition.
     */
    static void doAnyMatch() {
        System.out.println("doAnyMatch...");

        boolean anyMatch = users.stream().anyMatch(user -> user.getFirstName().contains("mine"));

        System.out.println("anyMatch: " + anyMatch);

        System.out.println("doAnyMatch done!");
    }

    /***
     * Stream API provides the allMatch() method, which is used to check if all elements in the stream satisfy a given
     * condition or predicate.
     * 
     * It returns a boolean value indicating whether every element in the stream matches the specified condition.
     */
    static void doAllMatch() {
        System.out.println("doAllMatch...");

        boolean allMatch = users.stream().allMatch(user -> user.getFirstName().contains("a"));
        System.out.println("allMatch" + allMatch);

        System.out.println("doAllMatch done!");
    }

    /***
     * Stream API provides the distinct() method, which is used to remove duplicate elements from a stream. It returns a
     * new stream containing only the distinct elements based on their natural order (if available) or their
     * implementation of equals() method.
     */
    static void doDistinct() {
        System.out.println("doDistinct...");

        users.stream().distinct().forEach(user -> {
            System.out.println("user: " + user.toString());
        });

        System.out.println("doDistinct done!");
    }

}
