package com.techelevator.postageCalculator;

public class FirstClassPostal implements DeliveryDriver {

    private String name = "First Class post";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double calculateRate(int distance, double weight) {
        double rate = 0;

        if(weight <= 2){
            rate = 0.035 * distance;
        }else if(weight <= 8){
            rate = 0.040 * distance;
        }else if(weight <= 15){
            rate = 0.047 * distance;
        }else if(weight <= 48){
            rate = 0.195 * distance;
        }else if(weight <= 128){
            rate = 0.450 * distance;
        }else{
            rate = 0.500 * distance;
        }

        return rate;
    }


}
