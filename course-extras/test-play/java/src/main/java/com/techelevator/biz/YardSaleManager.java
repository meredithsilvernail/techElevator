package com.techelevator.biz;

public class YardSaleManager {

    public String numberToWord (int number){
        String result = "";
        String[] ones = {"zero", "one", "two", "three", "four"};
        if (number < 0){
            result = "negative ";
            number = number *-1;
        }
        result = result + ones[number];
        return result;
    }


}
