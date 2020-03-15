package com.techelevator.entity;

public interface Vendable {

    public String getName();

    public void setName(String name);

    public Money getPrice();

    public void setPrice(Money price);

    public int getQuantity();

    public void setQuantity(int quantity);

    public String getCode();

    public void setCode(String code);
}
