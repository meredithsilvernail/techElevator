package com.techelevator.entity;

import java.util.Map;

public class VendMachine {

    private Map<String, Product> inventory;

    public VendMachine(Map<String, Product> inventory){
        this.inventory = inventory;
    }

    public Product getProduct(String slot){
        return inventory.get(slot);
    }
}
