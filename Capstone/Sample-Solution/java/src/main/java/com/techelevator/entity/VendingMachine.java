package com.techelevator.entity;

import java.util.*;

public class VendingMachine {

    private Map<String, Vendable> vendingInventory;

    private List<Vendable> sortedVendingInventory;

    public VendingMachine(Map<String, Vendable> vendingInventory){
        this.vendingInventory = vendingInventory;
    }

    public void addItem(Vendable item){
        vendingInventory.put(item.getCode().toUpperCase(), item);
    }

    public Vendable getItem(String code){
        return vendingInventory.get(code.toUpperCase());
    }

    public List<Vendable> getInventoryItems(){
        sortedVendingInventory = new ArrayList<>(vendingInventory.size());
        for (Vendable item : vendingInventory.values()) {
            sortedVendingInventory.add(item);
        }
        Collections.sort(sortedVendingInventory,
                (Vendable code1, Vendable code2) ->
                        code1.getCode().compareTo(code2.getCode()));
        return sortedVendingInventory;
    }

    public List<Vendable> getSortedVendingInventory() {
        if (sortedVendingInventory == null){
            sortedVendingInventory = getInventoryItems();
        }
        return sortedVendingInventory;
    }
}
