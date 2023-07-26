package com.folautech.java8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.github.javafaker.Faker;

public class Java8DateTime {

    static Faker faker = new Faker();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Java8DateTime");

        doLocaDate();

        doLocalTime();

        doZonedDateTime();

        doDuration();

        doPeriod();

        doDateTimeFormatter();

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

    /***
     * Duration is a class in the java.time package that represents a time-based duration. It measures the amount of
     * time between two points in time in terms of hours, minutes, seconds, and nanoseconds. Duration is primarily used
     * to represent a duration between two instances of Instant, but it can also be used with LocalTime, LocalDateTime,
     * or any other time-based object that supports nanosecond precision.
     */
    static void doDuration() {
        System.out.println("doDuration...");
        // Create a Duration between two Instants
        Instant start = Instant.now();
        // Simulate some operation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();

        Duration duration = Duration.between(start, end);
        System.out.println("Duration in seconds: " + duration.getSeconds());
        System.out.println("Duration in milliseconds: " + duration.toMillis());

        // Add and subtract duration
        Duration fiveMinutes = Duration.ofMinutes(5);
        Instant futureInstant = end.plus(fiveMinutes);
        Instant pastInstant = start.minus(fiveMinutes);
        System.out.println("Future Instant: " + futureInstant);
        System.out.println("Past Instant: " + pastInstant);

        // Compare durations
        Duration oneMinute = Duration.ofMinutes(1);
        Duration twoMinutes = Duration.ofMinutes(2);
        if (oneMinute.compareTo(twoMinutes) < 0) {
            System.out.println("One minute is less than two minutes.");
        } else if (oneMinute.compareTo(twoMinutes) > 0) {
            System.out.println("One minute is greater than two minutes.");
        } else {
            System.out.println("One minute is equal to two minutes.");
        }

        // Check if a duration is zero or negative
        Duration zeroDuration = Duration.ZERO;
        Duration negativeDuration = Duration.ofSeconds(-10);
        System.out.println("Is zero duration? " + zeroDuration.isZero());
        System.out.println("Is negative duration? " + negativeDuration.isNegative());

        System.out.println("doDuration done!");
    }

    /***
     * Period is a class in the java.time package that represents a date-based period between two dates. It measures the
     * difference between two LocalDate instances in terms of years, months, and days. Period is useful when you need to
     * deal with date-based durations, such as calculating the difference between two dates, representing a period of
     * time, or adding/subtracting time units to a date.
     */
    static void doPeriod() {
        System.out.println("doPeriod...");
        // Create a Period between two LocalDates
        LocalDate startDate = LocalDate.of(2023, 7, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);

        Period period = Period.between(startDate, endDate);
        System.out.println("Period: " + period);
        System.out.println("Years: " + period.getYears());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Days: " + period.getDays());

        // Add and subtract periods
        Period threeMonths = Period.ofMonths(3);
        LocalDate futureDate = endDate.plus(threeMonths);
        LocalDate pastDate = startDate.minus(threeMonths);
        System.out.println("Future Date: " + futureDate);
        System.out.println("Past Date: " + pastDate);

        // // Compare periods
        // Period oneYear = Period.ofYears(1);
        // Period twoYears = Period.ofYears(2);
        // if (oneYear.compareTo(twoYears) < 0) {
        // System.out.println("One year is less than two years.");
        // } else if (oneYear.compareTo(twoYears) > 0) {
        // System.out.println("One year is greater than two years.");
        // } else {
        // System.out.println("One year is equal to two years.");
        // }

        // Check if a period is zero or negative
        Period zeroPeriod = Period.ZERO;
        Period negativePeriod = Period.ofYears(-1);

        System.out.println("Is zero period? " + zeroPeriod.isZero());
        System.out.println("Is negative period? " + negativePeriod.isNegative());

        System.out.println("doPeriod done!");
    }

    /**
     * DateTimeFormatter is a class in the java.time.format package that provides the functionality to format and parse
     * date and time objects in a specific pattern. It allows you to convert dates and times to text representation
     * (formatting) and parse text into date and time objects (parsing). DateTimeFormatter is part of the Java 8 Date
     * and Time API (java.time package) and is used to customize the presentation of date and time values according to a
     * desired pattern.
     * 
     * Key points about DateTimeFormatter:
     * 
     * DateTimeFormatter is immutable and thread-safe, so you can share a single instance across multiple threads.
     * 
     * It provides a wide range of pre-defined format styles, such as ISO_DATE, ISO_TIME, ISO_DATE_TIME, etc.
     * 
     * You can create a custom date and time format pattern using specific format symbols. For example, "yyyy-MM-dd"
     * represents a year, a hyphen, a month, another hyphen, and a day.
     * 
     * You can use DateTimeFormatter.ofPattern(String pattern) to create a formatter with a custom pattern.
     * 
     * DateTimeFormatter supports localized formatting and parsing for different locales.
     * 
     * 
     */
    static void doDateTimeFormatter() {
        System.out.println("doDateTimeFormatter...");
        // Formatting dates and times using pre-defined styles
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Formatting using pre-defined styles
        System.out.println("ISO Date: " + currentDate.format(DateTimeFormatter.ISO_DATE));
        System.out.println("ISO Time: " + currentTime.format(DateTimeFormatter.ISO_TIME));
        System.out.println("ISO Date Time: " + currentDateTime.format(DateTimeFormatter.ISO_DATE_TIME));

        // Formatting using custom patterns
        DateTimeFormatter customDateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println("Custom Date: " + currentDate.format(customDateFormatter));

        DateTimeFormatter customDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Custom Date Time: " + currentDateTime.format(customDateTimeFormatter));

        // Parsing text into date and time objects
        String dateString = "2023-07-20";
        String dateTimeString = "2023-07-20 12:34:56";

        LocalDate parsedDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTimeString, customDateTimeFormatter);

        System.out.println("Parsed Date: " + parsedDate);
        System.out.println("Parsed Date Time: " + parsedDateTime);

        // Create a LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.of(2023, 7, 20, 12, 34, 56);

        // Convert LocalDateTime to OffsetDateTime with UTC offset (+00:00)
        OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.UTC);

        // Format OffsetDateTime to UTC format (yyyy-MM-dd'T'HH:mm:ss.SSS'Z')
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String formattedUTC = offsetDateTime.format(formatter);

        System.out.println("LocalDateTime: " + localDateTime);
        System.out.println("Formatted UTC: " + formattedUTC);

        System.out.println("doDateTimeFormatter done!");
    }

}
