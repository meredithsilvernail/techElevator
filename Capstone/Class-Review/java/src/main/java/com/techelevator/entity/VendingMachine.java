package com.techelevator.entity;

import java.util.Map;

public class VendingMachine {
    private Map<String, Food> theMap;

    public VendingMachine(Map<String, Food> theMap) {
        this.theMap = theMap;
    }

    public Food getFood(String slot){
        return theMap.get(slot.toUpperCase());
    }
}
