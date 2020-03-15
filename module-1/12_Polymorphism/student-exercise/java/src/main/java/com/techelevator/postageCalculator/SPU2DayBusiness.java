package com.techelevator.postageCalculator;

public class SPU2DayBusiness implements DeliveryDriver {
    private String name = "SPU 2-Day Business";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double calculateRate(int distance, double weight) {
        return (weight * 0.050) * distance;
    }
}
