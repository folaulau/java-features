package com.folautech.java12;

import java.util.Random;

import com.github.javafaker.Faker;

public class Java12Switch {

    static Faker faker = new Faker();

    public static void main(String[] args) {

        runNewSwitchSyntax();
    }

    /**
     * 
     */
    static void runNewSwitchSyntax() {
        System.out.println("runNewSwitchSyntax...");

        DayOfWeek dayOfWeek = DayOfWeek.WEDNESDAY;

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
