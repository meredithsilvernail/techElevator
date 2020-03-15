package com.techelevator;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Driver driver = new Driver();
//        driver.classDemoForLoops();

        driver.discountCalculator();

    }

    public void discountCalculator(){
        //create scanner to get input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our Discount Calculator");

        //ask user for input
        System.out.println("Enter the discount price (w/out percentage): ");

        //get input as string
        String percentStr = scanner.nextLine();

        //make input a double and percentage
        double discount = Double.parseDouble(percentStr)/100.0;

        //ask user for input
        System.out.println("Enter a series of prices (separated by space): ");

        //get prices in a string
        String prices = scanner.nextLine();

        //parse values as tokens, using space as split point
        String[] priceArray = prices.split(" ");

        //loop through array and parse double, apply discount, print original and discounted amounts
        for(String price : priceArray){
            double originalPrice = Double.parseDouble(price);
            double discountedPrice = originalPrice - (originalPrice * discount);

            System.out.println("Original: " + originalPrice + " - " + "Discounted: " + discountedPrice);
        }
        scanner.close();

    }

        public void classDemoForLoops(){
            int[] nums = {34, 8, 32};
            int sum = 0;
            for(int num : nums){
                sum += num;
            }
            System.out.println("Total is: " + sum);

            for(int i = 0; i < nums.length; i++){
                System.out.println(i + 1 + ". " + nums[i]);
            }

            int i = 0;
            while(i < nums.length){
                System.out.println(i + 1 + ". " + nums[i]);
                i++;

        }


    }
}
