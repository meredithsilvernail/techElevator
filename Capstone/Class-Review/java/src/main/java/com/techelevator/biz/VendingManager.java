package com.techelevator.biz;

import com.techelevator.entity.Customer;
import com.techelevator.entity.VendingMachine;

import java.math.BigDecimal;

public class VendingManager {

    private VendingMachine machine;

    private Customer customer;

    public VendingManager(VendingMachine machine, Customer customer) {
        this.machine = machine;
        this.customer = customer;
    }

    public BigDecimal feedMoney(String amount){
        return feedMoney( new BigDecimal(amount) );
    }

    public BigDecimal feedMoney(BigDecimal amount){
        customer.setBalance( customer.getBalance().add(amount) );
        return customer.getBalance();
    }
}
