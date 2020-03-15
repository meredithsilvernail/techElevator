package com.techelevator.postageCalculator;

public class SPU4DayGround implements DeliveryDriver {
    private String name = "SPU 4-Day Ground";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double calculateRate(int distance, double weight) {
        return (weight * 0.0050) * distance;
    }
}
