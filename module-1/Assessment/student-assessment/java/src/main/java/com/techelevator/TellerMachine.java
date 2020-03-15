package com.techelevator;

import java.math.BigDecimal;

public class TellerMachine {
    private String manufacturer;
    private BigDecimal deposits;
    private BigDecimal withdrawals;

    public TellerMachine(String manufacturer, BigDecimal deposits, BigDecimal withdrawals) {
        this.manufacturer = manufacturer;
        this.deposits = deposits;
        this.withdrawals = withdrawals;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public BigDecimal getBalance(){
        return deposits.subtract(withdrawals);
    }

    @Override
    public String toString() {
        return "ATM " + "- " + getManufacturer() + " - " + getBalance();

    }


    public boolean isCardValid(String cardNumber){
        if(cardNumber.startsWith("5") && cardNumber.length() == 16){
            return true;
        }else if(cardNumber.startsWith("4") && (cardNumber.length() == 13 || cardNumber.length() == 16)){
            return true;
        }else if(cardNumber.startsWith("34") || cardNumber.startsWith("37")){
            return true;
        }else
            return false;
    }

}
