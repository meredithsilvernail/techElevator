package com.techelevator.entity;

import java.math.BigDecimal;

public class Customer {
    private BigDecimal balance;

    public Customer(){
        this.balance = BigDecimal.ZERO;
    }

    public Customer(BigDecimal balance){
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
