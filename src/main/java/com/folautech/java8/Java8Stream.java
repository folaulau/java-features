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
        doLimit();
        doParallelStream();
        doMax();
        doMin();

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
     * The Stream API provides the sorted() method, which is used to sort the elements of a stream based on a specified
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

    static void doLimit() {
        System.out.println("doDistinct...");

        users.stream().limit(3).forEach(user -> {
            System.out.println("user: " + user.toString());
        });

        System.out.println("doDistinct done!");
    }

    static void doParallelStream() {
        System.out.println("doParallelStream...");

        users.parallelStream().forEach(user -> {
            System.out.println("user: " + user.toString());
        });

        System.out.println("doParallelStream done!");
    }

    /***
     * Stream API provides the max() method, which is used to find the maximum element of a stream based on a given
     * comparator or the natural order of the elements.
     * 
     * The max() method returns an Optional<T> that contains the maximum element, or an empty Optional if the stream is
     * empty.
     * 
     * Optional<T> max(Comparator<? super T> comparator)
     * 
     */
    static void doMax() {
        System.out.println("doMax...");

        Optional<User> maxUser = users.stream().max(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getFirstName().compareTo(u2.getFirstName());
            }
        });

        maxUser.ifPresent(user -> {
            System.out.println("Max User: " + user.toString());
        });

        System.out.println("doMax done!");
    }

    /***
     * Stream API provides the min() method, which is used to find the minimum element of a stream based on a given
     * comparator or the natural order of the elements.
     * 
     * The min() method returns an Optional<T> that contains the minimum element, or an empty Optional if the stream is
     * empty.
     * 
     * Optional<T> min(Comparator<? super T> comparator)
     * 
     */
    static void doMin() {
        System.out.println("doMin...");

        Optional<User> maxUser = users.stream().min(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getFirstName().compareTo(u2.getFirstName());
            }
        });

        maxUser.ifPresent(user -> {
            System.out.println("Min User: " + user.toString());
        });

        System.out.println("doMin done!");
    }

    /***
     * the Stream API provides the reduce() method, which is used to perform a reduction operation on the elements of a
     * stream. A reduction operation combines the elements of a stream into a single result.
     * 
     * The reduce() method allows you to compute the result of a binary operation iteratively, starting with an initial
     * value (also known as the identity) and applying the operation to the elements in the stream.
     * 
     * Optional<T> reduce(BinaryOperator<T> accumulator)
     * 
     * T reduce(T identity, BinaryOperator<T> accumulator)
     */
    static void doReduce() {
        System.out.println("doReduce...");
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6);
        // Finding the maximum number using reduce with an identity
        int maxNumber = numbers.stream().reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));

        System.out.println("Max Number: " + maxNumber);

        System.out.println("doReduce done!");
    }

}
