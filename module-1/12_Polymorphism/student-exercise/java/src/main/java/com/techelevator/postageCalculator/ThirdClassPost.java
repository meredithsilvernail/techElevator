package com.techelevator.postageCalculator;

public class ThirdClassPost implements DeliveryDriver {
    private String name = "Third Class Post";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double calculateRate(int distance, double weight) {
        double rate = 0;

        if(weight <= 2){
            rate = 0.0020 * distance;
        }else if(weight <= 8){
            rate = 0.0022 * distance;
        }else if(weight <= 15){
            rate = 0.0024 * distance;
        }else if(weight <= 48){
            rate = 0.0150 * distance;
        }else if(weight <= 128){
            rate = 0.0160 * distance;
        }else{
            rate = 0.0170 * distance;
        }

        return rate;
    }


}
