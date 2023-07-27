package com.folautech.java12;

import java.util.Random;

import com.github.javafaker.Faker;

public class Java12Switch {

    static Faker faker = new Faker();

    public static void main(String[] args) {

        runNewSwitchSyntax();
    }

    /**
     * Notice a few key differences:
     * 
     * Arrow (->) vs. Colon (:): The new syntax uses -> for cases instead of :.
     * 
     * Multiple Labels: Multiple case labels can be grouped together, separated by commas, as shown with MONDAY, FRIDAY,
     * SUNDAY.
     * 
     * No fall-through: The new switch expression eliminates the notorious "fall-through" behavior of the traditional
     * switch statement, thus reducing errors.
     * 
     * Returning values: The switch expression returns a value, allowing it to be used in more expressive ways, like
     * assigning a value to a variable.
     * 
     * Yield for returning values in a block: If a case needs to execute a block of code, you can use yield to return a
     * value from that block:
     * 
     * 
     * Benefits:
     * 
     * Readability: The code becomes concise and easier to understand.
     * 
     * Safety: Avoids accidental fall-through.
     * 
     * Expressiveness: Switch can now be used in more contexts due to its ability to return values.
     * 
     * Considerations:
     * 
     * Always have a default case or cover all possible cases to ensure exhaustive handling.
     * 
     * When using the new switch expressions, always ensure that each case is exhaustive and handles all scenarios. The
     * compiler will help in this by throwing an error if you've missed a case for a known set of inputs.
     * 
     * Remember that switch expressions were introduced in Java 12 as a preview feature. If you're using a version prior
     * to Java 14, you'll need to enable preview features to use switch expressions. Starting from Java 14, they are a
     * standard feature.
     */
    static void runNewSwitchSyntax() {
        System.out.println("runNewSwitchSyntax...");

        DayOfWeek dayOfWeek = DayOfWeek.WEDNESDAY;

        // you can return a value from the switch
        String dayType = switch (dayOfWeek) {
            case FRIDAY, SATURDAY, SUNDAY -> "End of week";
            case MONDAY, TUESDAY -> "Start of week";
            case WEDNESDAY, THURSDAY -> "Midweek";
            default -> throw new IllegalArgumentException("Invalid day");
        };

        System.out.println("dayType: " + dayType);

        Random random = new Random();
        int number = random.nextInt(1, 11);

        String message = switch (number) {
            case 1, 2, 3 -> "End of week";
            case 4, 5, 6 -> "Start of week";
            case 7, 8, 9 -> {
                /**
                 * if you want to execute lines of code, this is how to do it.
                 * 
                 * Yield for returning values in a block: If a case needs to execute a block of code, you can use yield
                 * to return a value from that block:
                 */
                String result = "Midweek";
                yield result; // 'yield' returns the value for this case
            }
            default -> "no idea";
        };

        System.out.println("number: " + number + ", message: " + message);

        System.out.println("runNewSwitchSyntax done!");
    }

}
