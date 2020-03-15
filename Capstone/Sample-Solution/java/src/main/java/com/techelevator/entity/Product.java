package com.techelevator.entity;

import java.math.BigDecimal;

public abstract class Product {

    private String slot;
    private String name;
    private BigDecimal price;
    private int quantity;

    public Product(String slot, String name, BigDecimal price, int quantity) {
        this.slot = slot;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract String getMessage();

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
