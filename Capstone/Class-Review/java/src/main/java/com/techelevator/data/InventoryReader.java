package com.techelevator.data;

import com.techelevator.entity.*;

import java.io.File;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryReader {

    public static VendingMachine loadInventory(String fileName)
            throws Exception {
        Map<String, Food> map = new LinkedHashMap<String, Food>();
        Food food = null;
        Scanner scanner = new Scanner( new File(fileName) );
        while (scanner.hasNextLine()){
            String[] tokens = scanner.nextLine().split(",");
            if (tokens[3].equals("Chip")){
                food = new Chip(tokens[0], tokens[1], new BigDecimal(tokens[2]));
            } else if (tokens[3].equals("Candy")){
                food = new Candy(tokens[0], tokens[1], new BigDecimal(tokens[2]));
            } else if (tokens[3].equals("Drink")){
                food = new Drink(tokens[0], tokens[1], new BigDecimal(tokens[2]));
            } else {
                food = new Gum(tokens[0], tokens[1], new BigDecimal(tokens[2]));
            }
            map.put(tokens[0], food);
        }
        scanner.close();

        return new VendingMachine(map);
    }
}
