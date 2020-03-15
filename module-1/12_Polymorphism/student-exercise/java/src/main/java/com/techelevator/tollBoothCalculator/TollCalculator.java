package com.techelevator.tollBoothCalculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TollCalculator {

    public static void main(String[] args) {
        int milesTraveled = 0;
        double revenue = 0;


        List<Vehicle> tollBooth1 = new ArrayList<>();
        tollBooth1.add(new Car(false));
        tollBooth1.add(new Car(true));
        tollBooth1.add(new Tank());
        tollBooth1.add(new Truck(4));
        tollBooth1.add(new Truck(6));
        tollBooth1.add(new Truck(8));

        calculate(tollBooth1);
    }

    public static void calculate(List<Vehicle> list){
        double distanceTotal = 0;
        double tollTotal = 0;
        DecimalFormat format = new DecimalFormat("#0.00");


        for(Vehicle vehicle : list){
            int distance = (int) (Math.random() * 100);
            distanceTotal += distance;
            tollTotal += vehicle.calculateToll(distance);

            System.out.println("Vehicle: " + vehicle.getType() + " : " + "Distance: " + distance + " : " + "Toll cost: $" + format.format(vehicle.calculateToll(distance)));

        }

        System.out.println("Total Miles Traveled: " + distanceTotal);
        System.out.println("Total Tollbooth Revenue: $" + format.format(tollTotal));
    }
}
