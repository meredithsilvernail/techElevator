package com.techelevator.entity;

import java.math.BigDecimal;

public class Drink extends Food {

    public Drink(String slot, String name, BigDecimal price) {
        super(slot, name, price);
    }

    @Override
    public String getMessage(){
        return "Glug glug, Yum!";
    }
}
