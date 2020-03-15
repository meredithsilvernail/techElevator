package com.techelevator.postageCalculator;

public interface DeliveryDriver {

    public double calculateRate(int distance, double weight);

    public String getName();
}
