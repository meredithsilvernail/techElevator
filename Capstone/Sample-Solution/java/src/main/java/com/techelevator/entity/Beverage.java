package com.techelevator.entity;

import java.math.BigDecimal;

public class Beverage extends Product {


    public Beverage(String slot, String name, BigDecimal price, int quantity){
        super(slot, name, price, quantity);
    }

    @Override
    public String getMessage() {
        return "Glug Glug";
    }
}
