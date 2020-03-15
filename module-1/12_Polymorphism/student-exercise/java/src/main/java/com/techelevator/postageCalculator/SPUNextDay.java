package com.techelevator.postageCalculator;

public class SPUNextDay implements DeliveryDriver {
    private String name = "SPU Next Day";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double calculateRate(int distance, double weight) {
        return (weight * 0.075) * distance;
    }
}
