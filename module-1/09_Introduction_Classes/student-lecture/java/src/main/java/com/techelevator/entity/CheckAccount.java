package com.techelevator.entity;


public class CheckAccount extends BankAccount {

    private double overDraftAmount;

    public CheckAccount(double overDraftAmount, int accountNumber, Customer owner, double balance){
        super(accountNumber, owner, balance);
        this.overDraftAmount = overDraftAmount;
    }

    public CheckAccount(){}

    public void setOverDraftAmount(double overDraftAmount){
        this.overDraftAmount = overDraftAmount;
    }

    public double getOverDraftAmount(){
        return overDraftAmount;
    }

    @Override
    public String toString(){
        return "CheckAccount: overDraft = " + overDraftAmount + ", " + super.toString();
    }



}
