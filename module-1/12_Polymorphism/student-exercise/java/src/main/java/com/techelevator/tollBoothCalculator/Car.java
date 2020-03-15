package com.techelevator.tollBoothCalculator;

public class Car implements Vehicle {
    private String type = "Car";
    private boolean hasTrailer;

    public Car(boolean hasTrailer) {
        this.hasTrailer = hasTrailer;
    }

    public boolean hasTrailer() {
        return hasTrailer;
    }

    @Override
    public String getType() {
        if(hasTrailer){
            return type + " with Trailer";
        }else{
            return type;
        }

    }

    @Override
    public double calculateToll(int distance){
        double toll = distance * 0.020;
        if(hasTrailer){
            return toll + 1.00;
        }
        return toll;
    }
}
