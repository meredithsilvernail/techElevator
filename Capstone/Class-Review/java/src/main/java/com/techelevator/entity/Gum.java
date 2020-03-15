package com.techelevator.entity;

import java.math.BigDecimal;

public class Gum extends Food {

    public Gum(String slot, String name, BigDecimal price) {
        super(slot, name, price);
    }

    @Override
    public String getMessage(){
        return "Chew chew, Yum!";
    }
}
