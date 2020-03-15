package com.techelevator.entity;

import java.util.Objects;

public class Customer extends Person {

    private String creditCard;

    public Customer() {}

    public Customer(String name, String email, String creditCard) {
        super(name, email);
        this.creditCard = creditCard;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(creditCard, customer.creditCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), creditCard);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "creditCard='" + creditCard + '\'' +
                super.toString() + '\'' +
                '}';
    }
}
