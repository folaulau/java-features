package com.folautech.java13;

import java.util.Random;

import com.github.javafaker.Faker;

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
