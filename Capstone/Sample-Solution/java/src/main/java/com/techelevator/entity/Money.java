package com.techelevator.entity;

import com.techelevator.data.Logger;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.util.Objects;

public class Money {

    private BigDecimal value;

    public Money(BigDecimal value) {
        this.value = value;
    }

    public Money(double value) {
        this.value = new BigDecimal(value);
    }

    public Money(int value) {
        this.value = new BigDecimal(value);
    }

    public Money(String value) {
        try{
           this.value = new BigDecimal( Double.parseDouble(value) );
        } catch (NumberFormatException e){
            Logger.logMessage(e.getMessage() + " : " + value);
            this.value = new BigDecimal(0);
        }
    }

    public BigDecimal getValue() {
        return value;
    }

    public Money add(Money otherValue){
        return new Money(this.value.add(otherValue.getValue()));
    }

    public Money subtract(Money otherValue){
        return new Money(this.value.subtract(
                otherValue.getValue(), new MathContext(4)));
    }

    public boolean isEnough(Money otherValue){
        int number = this.value.compareTo(otherValue.getValue());
        return (number == 1) || (number == 0);
    }

    public boolean isZero(){
        return value.compareTo(BigDecimal.ZERO) == 0;
    }

    public String coins(){
        String result = "";
        if (value.intValue() == 0)
            return result;
        BigDecimal num = value.multiply(
                new BigDecimal(100), new MathContext(4));
        int amount = num.intValue();
        if (amount >= 25) {
            int quarters = amount / 25;
            result = quarters + " quarters";
            amount = amount % 25;
        }
        if (amount >= 10) {
            int dimes = amount / 10;
            if (!result.equals(""))
                result += " ";
            result = result + dimes + " dimes";
            amount = amount % 10;
        }
        if (amount >= 5) {
            int nickles = amount / 5;
            if (!result.equals(""))
                result += " ";
            result = result + nickles + " nickles";
            amount = amount % 5;
        }
        if (amount >= 1) {
            if (!result.equals(""))
                result += " ";
            result = result + amount + " pennies";
        }
        return result;
    }

    @Override
    public String toString() {
        return NumberFormat.getCurrencyInstance().format(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value.equals(money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
