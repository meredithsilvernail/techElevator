package com.techelevator.entity;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class VendingMachineTest {

    @Test
    public void getFoodGum() {
        getFoodTest(
                new Gum("A1", "Some Name", new BigDecimal(5.00)),
                "Chew Chew Yum!");
    }

    @Test
    public void getFoodDrink() {
        getFoodTest(
                new Gum("C1", "Some Name", new BigDecimal(5.00)),
                "Glug Glug Yum!");
    }

    private void getFoodTest(Food food, String expected){
        assertEquals("Message is incorrect: ", expected, food.getMessage());
    }


}