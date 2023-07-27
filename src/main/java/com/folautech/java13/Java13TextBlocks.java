package com.folautech.java13;

import java.util.Random;

import com.github.javafaker.Faker;

/**
 * Introduced as a preview feature in Java 13 and then standardized in Java 15, Text Blocks aim to simplify the task of
 * writing and managing multi-line string literals in Java. They are particularly useful when working with JSON, SQL,
 * XML, or any other multi-line textual data.
 * 
 * Basics of Text Blocks:
 * 
 * A text block is denoted by three double-quote marks (""") and allows for multi-line strings without the need for most
 * escape sequences.
 * 
 * All white spaces and new lines within a text block are preserved. If you want to remove the newline at the end of a
 * line, you can use the line continuation character (\)
 * 
 * Within a text block, you can use the standard escape sequences like \n, \t, and \". However, you no longer need to
 * escape every double-quote in the string, only the sequence of three double-quotes (""") if they appear in the
 * content:
 */
public class Java13TextBlocks {

    static Faker faker = new Faker();

    public static void main(String[] args) {
        System.out.println("Java13TextBlocks");

        String bio = """

                Paul and Silas then travel by night to Berea. In Berea, they find that the
                Jews are more noble-minded than those in Thessalonica, as they receive the message with
                great eagerness and examine the Scriptures daily to see if what Paul says is true.
                Many Bereans believe, including several influential Greek women and men.

                However, when the Jews in Thessalonica learn that Paul is preaching in Berea,
                they come there to agitate the crowds. As a result, the believers send Paul to the coast for his safety,
                while Silas and Timothy remain in Berea.
                                """;

        System.out.println("bio: " + bio);
    }

}
