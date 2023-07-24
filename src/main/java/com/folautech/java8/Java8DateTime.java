package com.folautech.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.github.javafaker.Faker;

public class Java8DateTime {

    static Faker faker = new Faker();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Java8DateTime");

        doLocaDate();

        doLocalTime();

        doZonedDateTime();

    }

    /**
     * LocalDate is a class in the Java 8 Date and Time API (java.time package) that represents a date without a time
     * component and without a time zone. It represents a date in the ISO calendar system (year, month, day). Since it
     * does not store time information, it is suitable for scenarios where you need to deal with dates only, such as
     * birthdays, anniversaries, and other date-based operations.
     */
    static void doLocaDate() {
        System.out.println("doLocaDate...");

        // Create a LocalDate for the current date
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);

        // Create a LocalDate with a specific date
        LocalDate specificDate = LocalDate.of(2023, 7, 20);
        System.out.println("Specific Date: " + specificDate);

        // Parse a text string to create a LocalDate
        // Parses a text string in the format "yyyy-MM-dd"
        LocalDate parsedDate = LocalDate.parse("2023-07-20");
        System.out.println("Parsed Date: " + parsedDate);

        // Get individual components of the LocalDate
        int year = specificDate.getYear();
        int month = specificDate.getMonthValue();
        int day = specificDate.getDayOfMonth();
        System.out.println("Year: " + year + ", Month: " + month + ", Day: " + day);

        // Add or subtract days, months, or years
        LocalDate modifiedDate = specificDate.plusDays(5).minusMonths(1).plusYears(2);
        System.out.println("Modified Date: " + modifiedDate);

        // Check if a date comes before or after another date
        LocalDate futureDate = LocalDate.of(2024, 1, 1);
        if (futureDate.isAfter(specificDate)) {
            System.out.println("Future date is after specific date.");
        } else {
            System.out.println("Future date is not after specific date.");
        }

        // Check if a date is in the past
        LocalDate pastDate = LocalDate.of(2022, 1, 1);
        if (pastDate.isBefore(currentDate)) {
            System.out.println("Past date is before current date.");
        } else {
            System.out.println("Past date is not before current date.");
        }

        System.out.println("doLocaDate done!");
    }

    /**
     * LocalTime is a class in the Java 8 Date and Time API (java.time package) that represents a time of day without a
     * date and time zone. It contains information about hours, minutes, seconds, and nanoseconds. LocalTime is useful
     * when you need to handle time-specific operations, such as setting reminders, scheduling events, or measuring time
     * durations without considering the date.
     */
    static void doLocalTime() {
        System.out.println("doLocalTime...");

        // Create a LocalTime for the current time
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time: " + currentTime);

        // Create a LocalTime with a specific time
        LocalTime specificTime = LocalTime.of(12, 34);
        System.out.println("Specific Time: " + specificTime);

        // Create a LocalTime with a specific time including seconds and nanoseconds
        LocalTime specificTimeWithSeconds = LocalTime.of(12, 34, 56);
        System.out.println("Specific Time with Seconds: " + specificTimeWithSeconds);

        // Parse a text string to create a LocalTime
        LocalTime parsedTime = LocalTime.parse("13:45:30");
        System.out.println("Parsed Time: " + parsedTime);

        // Get individual components of the LocalTime
        int hour = specificTime.getHour();
        int minute = specificTime.getMinute();
        int second = specificTimeWithSeconds.getSecond();
        System.out.println("Hour: " + hour + ", Minute: " + minute + ", Second: " + second);

        // Add or subtract hours, minutes, seconds, or nanoseconds
        LocalTime modifiedTime = specificTime.plusHours(2).minusMinutes(15).plusSeconds(30).plusNanos(500000000);
        System.out.println("Modified Time: " + modifiedTime);

        // Check if a time comes before or after another time
        LocalTime futureTime = LocalTime.of(14, 0);
        if (futureTime.isAfter(specificTime)) {
            System.out.println("Future time is after specific time.");
        } else {
            System.out.println("Future time is not after specific time.");
        }

        // Check if a time is in the past
        LocalTime pastTime = LocalTime.of(11, 0);
        if (pastTime.isBefore(currentTime)) {
            System.out.println("Past time is before current time.");
        } else {
            System.out.println("Past time is not before current time.");
        }

        System.out.println("doLocalTime done!");
    }

    /***
     * ZonedDateTime is a class in the Java 8 Date and Time API (java.time package) that represents a date and time in a
     * specific time zone. It combines the functionalities of LocalDateTime and ZoneId to represent an instant in time
     * with the time zone information. It allows you to perform operations that consider both the local date and time
     * and the time zone.
     */
    static void doZonedDateTime() {
        System.out.println("doZonedDateTime...");

        // Get the current date and time in a specific time zone
        ZonedDateTime currentDateTime = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println("Current Date and Time: " + currentDateTime);

        // Create a ZonedDateTime for a specific date and time in a specific time zone
        ZonedDateTime specificDateTime = ZonedDateTime.of(2023, 7, 20, 12, 34, 56, 0, ZoneId.of("Asia/Tokyo"));
        System.out.println("Specific Date and Time in Tokyo: " + specificDateTime);

        // Convert a LocalDateTime to ZonedDateTime with a specified time zone
        ZonedDateTime convertedDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/London"));
        System.out.println("Converted Date and Time in London: " + convertedDateTime);

        // Convert a ZonedDateTime to an OffsetDateTime
        OffsetDateTime offsetDateTime = specificDateTime.toOffsetDateTime();
        System.out.println("Offset Date and Time: " + offsetDateTime);

        // Get the time zone information from a ZonedDateTime
        ZoneId zoneId = specificDateTime.getZone();
        System.out.println("Time Zone: " + zoneId);

        // Check if a ZonedDateTime occurs before or after another ZonedDateTime
        ZonedDateTime futureDateTime = specificDateTime.plusDays(1);
        if (futureDateTime.isAfter(specificDateTime)) {
            System.out.println("Future date is after specific date.");
        } else {
            System.out.println("Future date is not after specific date.");
        }

        System.out.println("doZonedDateTime done!");
    }

}
