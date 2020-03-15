package com.techelevator.entity;

import java.util.Objects;

public class BankAccount {

    public static final double INTEREST_RATE = 0.02;

    protected int accountNumber;
    private Customer owner;
    private double balance;

    public BankAccount(){}

    public BankAccount(int accountNumber, Customer owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;

    }

    //setters: always return void, take 1 parameter with same type as field, named set + name of field
    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public void setOwner(Customer owner){
        this.owner = owner;
    }

    //getters: return data type of field, named "get + name of field", returns field
    public Customer getOwner(){
        return owner;
    }
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BankAccount(int accountNumber, Customer owner) {

        this(accountNumber, owner,0.00);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", owner=" + owner +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount that = (BankAccount) o;
        return accountNumber == that.accountNumber &&
                Double.compare(that.balance, balance) == 0 &&
                Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, owner, balance);
    }
}
