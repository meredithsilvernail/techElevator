package com.techelevator.postageCalculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostageCalculator {
    double weightInPounds = 0;
    double weightInOunces = 0;
    int distance;

    public static void main(String[] args) {

        PostageCalculator calc = new PostageCalculator();
        calc.processInput();

        List<DeliveryDriver> ouncesList = calc.loadOuncesList();
        List<DeliveryDriver> poundsList = calc.loadPoundsList();

        calc.printOutput(ouncesList, poundsList);

    }

    public void processInput(){
        //method to create scanner, get input as strings, convert and save to variables
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the weight of the package: ");
        String weightEntered = input.nextLine();

        System.out.println("(P)ounds or (O)unces?: ");
        String weightType = input.nextLine();

        System.out.println("What distance will it be traveling?: ");
        String distanceEntered = input.nextLine();
        distance = Integer.parseInt(distanceEntered);

        //figure out pounds and ounces based on which one input
        if(weightType.toUpperCase().equals("P")){
            weightInPounds = Integer.parseInt(weightEntered);
            weightInOunces = weightInPounds * 16;
        }else if(weightType.toUpperCase().equals("O")){
            weightInOunces = Integer.parseInt(weightEntered);
            weightInPounds = weightInOunces / 16;
        }

    }

    public List<DeliveryDriver> loadOuncesList(){
        //method to load list for delivery methods that take weight in ounces
        List<DeliveryDriver> ouncesList = new ArrayList<>();
        ouncesList.add(new FirstClassPostal());
        ouncesList.add(new SecondClassPost());
        ouncesList.add(new ThirdClassPost());
        ouncesList.add(new FexEd());

        return ouncesList;

    }

    public List<DeliveryDriver> loadPoundsList(){
        //method to load list of delivery methods that take weight in pounds
        List<DeliveryDriver> poundsList = new ArrayList<>();
        poundsList.add(new SPU4DayGround());
        poundsList.add(new SPU2DayBusiness());
        poundsList.add(new SPUNextDay());

        return poundsList;
    }

    public void printOutput(List<DeliveryDriver> ouncesList, List<DeliveryDriver> poundsList){
        DecimalFormat format = new DecimalFormat("#0.00");
        for(DeliveryDriver method : ouncesList){
            System.out.println("Delivery Method: " + method.getName() +
                    " --- " + " Cost: $" + format.format(method.calculateRate(distance, weightInOunces)));
        }

        for(DeliveryDriver method : poundsList){
            System.out.println("Delivery Method: " + method.getName() + " --- " + " Cost: $" +
                    format.format(method.calculateRate(distance, weightInPounds)));
        }
    }

}
