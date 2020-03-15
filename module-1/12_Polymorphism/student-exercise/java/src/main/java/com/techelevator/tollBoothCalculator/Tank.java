package com.techelevator.tollBoothCalculator;

public class Tank implements Vehicle {
    private String type = "Tank";

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double calculateToll(int distance) {
        return 0;
    }
}
