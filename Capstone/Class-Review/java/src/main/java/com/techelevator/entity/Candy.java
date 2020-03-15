package com.techelevator.entity;

import java.math.BigDecimal;

public class Candy extends Food {

    public Candy(String slot, String name, BigDecimal price) {
        super(slot, name, price);
    }

    @Override
    public String getMessage(){
        return "Munch munch, Yum!";
    }
}
