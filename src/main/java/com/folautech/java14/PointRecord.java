package com.folautech.java14;


public record PointRecord(int x, int y) {

    /**
     * Sometimes you might want to validate or normalize data as it's passed to the record. For this, you can use a
     * compact constructor
     */
    public PointRecord {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Coordinates must be positive");
        }
    }

    // You can add methods to a record
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

}
