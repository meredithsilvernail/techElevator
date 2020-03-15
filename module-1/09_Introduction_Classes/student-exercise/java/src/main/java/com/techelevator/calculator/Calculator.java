package com.techelevator.calculator;

public class Calculator {

    private int result;

    public Calculator() {
        this.result = 0;
    }

    public int getResult() {
        return result;
    }

    public int add(int addend){
        return result += addend;
    }

    public int multiply(int multiplier){

        return result *= multiplier;
    }

    public int power(int exponent){
        result = (int) Math.pow(result, exponent);
        return Math.abs(result);

    }

    public void reset(){
        result = 0;
    }

    public int subtract(int subtrahend){

        return result -= subtrahend;
    }
}
