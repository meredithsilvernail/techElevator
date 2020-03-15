package com.techelevator.entity;

import java.math.BigDecimal;

public class Chip extends Food {

    public Chip(String slot, String name, BigDecimal price) {
        super(slot, name, price);
    }

    @Override
    public String getMessage(){
        return "Crunch crunch, Yum!";
    }
}
