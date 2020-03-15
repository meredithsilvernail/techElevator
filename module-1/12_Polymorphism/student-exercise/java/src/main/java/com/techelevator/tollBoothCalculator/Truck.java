package com.techelevator.tollBoothCalculator;

public class Truck implements Vehicle {
    private String type = "Truck";
    private int numberOfAxles;

    public Truck(int numberOfAxles) {
        this.numberOfAxles = numberOfAxles;
    }

    @Override
    public String getType() {

        return type + " with " + numberOfAxles + " axles";
    }

    @Override
    public double calculateToll(int distance) {
        double toll;

        switch(numberOfAxles){
            case 4:
                toll = 0.040 * distance;
                break;
            case 6:
                toll = 0.045 * distance;
                break;
            case 8:
                toll = 0.048 * distance;
                break;
            default:
                toll = 0;
        }

//        if(numberOfAxles == 4){
//            toll = (0.040 * distance);
//        }else if(numberOfAxles == 6){
//            toll = (0.045 * distance);
//        }else {
//            toll = (0.048 * distance);
//        }

        return toll;

    }
}
