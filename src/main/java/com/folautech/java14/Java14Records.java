package com.folautech.java14;

import java.util.Random;

import com.github.javafaker.Faker;

/**
 * Records in Java are a powerful feature that reduces the verbosity associated with declaring classes that are mere
 * "data carriers." Essentially, they help cut down the boilerplate code for classes that only hold data and don't
 * modify it.
 * 
 * Things to Remember:
 * 
 * Record components are final by default.
 * 
 * Records can't be abstract.
 * 
 * Records can't extend other classes.
 * 
 * You can't declare instance fields in a record that aren't record components.
 * 
 * Records are a significant step toward making Java more expressive and less verbose, especially for common coding
 * patterns.
 * 
 * Caveats and Considerations for using Record with JPA:
 * 
 * Annotations: With records, you can't annotate fields directly since they're declared in the record header. If you
 * need to add JPA annotations (like @Id, @GeneratedValue, etc.), they should be added to the accessor methods (getters)
 * of the record.
 * 
 * Immutability: Records are inherently immutable, which means all their fields are final. This behavior aligns with the
 * principle of immutability in entity design but can complicate scenarios where you want to change an entity's state
 * after it has been constructed.
 * 
 * No-Args Constructor: JPA typically requires a no-args constructor, which records don't provide out of the box.
 * Hibernate's (a popular JPA implementation) team has been working to support records, so expect improvements in this
 * area. If your JPA provider doesn't support records yet, consider using DTOs (Data Transfer Objects) alongside your
 * entities.
 * 
 * Experimental Support: As mentioned earlier, while Spring Data started introducing experimental support for records,
 * this might not be fully mature or cover all scenarios. Always refer to the latest Spring Data documentation and check
 * for compatibility and best practices.
 * 
 *
 */
public class Java14Records {

    static Faker faker = new Faker();

    public static void main(String[] args) {
        System.out.println("Java14Records");

        PointRecord pointRecord = new PointRecord(0, 0);

        double distance = pointRecord.distanceFromOrigin();

        System.out.println("distance: " + distance);
    }

}
