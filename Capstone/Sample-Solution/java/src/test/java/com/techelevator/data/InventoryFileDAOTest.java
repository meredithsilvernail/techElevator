package com.techelevator.data;

import com.techelevator.entity.Chip;
import com.techelevator.entity.Money;
import com.techelevator.entity.Vendable;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class InventoryFileDAOTest {

    private static final String FILENAME =
            "C:\\te-curriculum-Mock\\19_Capstone\\java\\vendingmachine.csv";

    private static Map<String, Vendable> inventory;

    @Before
    public void setUp() throws Exception {
        inventory = InventoryFileDAO.loadVendingMachine(5, FILENAME);
    }

    @Test
    public void loadVendingMachineSize() {
        int expectedSize = 16;
        assertEquals("Inventory size ", expectedSize, inventory.size());
    }

    @Test
    public void loadVendingMachineFieldTokens() {
        Chip expected= new Chip("Potato Crisps", new Money(3.05), 5, "A1");
        assertEquals("Field Tokens for Chip ", expected, inventory.get("A1"));
    }
}