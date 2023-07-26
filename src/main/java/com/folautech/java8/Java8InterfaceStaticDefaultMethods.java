package com.folautech.java8;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import com.folautech.java.User;
import com.github.javafaker.Faker;

/***
 * Java method references are a shorthand notation of a lambda expression to call a method. They became available in
 * Java 8, just like lambdas and streams. Method references allow for a cleaner and more readable way to refer to
 * methods without executing them.
 *
 */
public class Java8InterfaceStaticDefaultMethods {

    static Faker faker = new Faker();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Java8InterfaceStaticDefaultMethods");

        UserOperationsImpl userOperationsImpl = new UserOperationsImpl();

        boolean result = userOperationsImpl.processApplication();

        System.out.println("result: " + result);

        User a = User.builder().dob(LocalDate.now().minusYears(18)).build();
        User b = User.builder().dob(LocalDate.now().minusYears(8)).build();

        int yearsDiff = UserOperations.calculateAgeDiff(a, b);

        System.out.println("yearsDiff: " + yearsDiff);

    }

}

class UserOperationsImpl implements UserOperations {

    /**
     * This implementation is optional. a default method is optional to override.
     */
    @Override
    public boolean processApplication() {
        Random random = new Random();
        int num = random.nextInt(0, 1000);
        if (num % 2 == 0) {
            return true;
        }
        return false;
    }
}

interface UserOperations {

    /**
     * Before Java 8, interfaces could only have abstract methods. The introduction of default methods in interfaces
     * allows developers to add new methods with a default implementation without affecting the classes that already use
     * this interface. This capability helps in enhancing the interfaces without breaking existing code.
     */
    default boolean processApplication() {
        // application process
        return true;
    }

    /**
     * Java 8 introduced the ability to have static methods in interfaces. A static method is a method that belongs to
     * the interface itself and not to the instance of the interface. You can't override these methods in the
     * implementing class, and you call them using the interface name.
     * 
     * Important Points for Static Methods:
     * 
     * They cannot be overridden by the implementing class. They are called using the interface name and cannot be
     * called on interface instances.
     * 
     * Why are these additions significant?
     * 
     * Backward Compatibility: With the introduction of new methods in interfaces (like in Java 8's Stream API), there
     * was a risk of breaking the existing code. Default methods help in providing default implementations without
     * breaking classes that already use the interface.
     * 
     * Utility Methods: Sometimes, you might want to provide some utility methods related to an interface. Having static
     * methods in interfaces lets you provide such utility methods directly within the interface rather than in a
     * separate utility class.
     * 
     * In conclusion, the addition of default and static methods in Java interfaces provides a more flexible and
     * cohesive approach to design interfaces and evolve them without breaking existing implementations.
     */
    static int calculateAgeDiff(User a, User b) {
        return Period.between(a.getDob(), b.getDob()).getYears();
    }
}
