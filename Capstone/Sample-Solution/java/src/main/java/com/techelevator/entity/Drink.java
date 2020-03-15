package com.techelevator.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Drink extends Item implements Vendable {

    private String code;

    public Drink(String code) {
        this.code = code;
    }

    public Drink(int id, String name, Money price, int quantity, String code) {
        super(id, name, price, quantity);
        this.code = code;
    }

    public Drink(String name, Money price, int quantity, String code) {
        super(name, price, quantity);
        this.code = code;
    }

    @Override
    public String getCode(){
        return code;
    }

    @Override
    public void setCode(String code){
        this.code = code;
    }

    @Override
    public String getDescription(){
        return "Glug Glug, Yum!";
    }

    @Override
    public String toString() {
        return code + " " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Drink drink = (Drink) o;
        return code.equals(drink.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), code);
    }
}
