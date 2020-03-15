package com.techelevator.data;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

import com.techelevator.entity.*;
import com.techelevator.exceptions.DataAccessException;

public class InventoryFileDAO {

    public VendMachine loadInventory(){
        Map<String, Product> inventory = new HashMap<>();
        try( Scanner scanner = new Scanner(
                new File("./vendingmachine.csv"))) {
            while (scanner.hasNextLine()){
                Product product=null;
                String line = scanner.nextLine();
                String[] tokens = line.split("\\|");
                if (tokens[3].equals("Drink")){
                    product = new Beverage(
                            tokens[0],
                            tokens[1],
                            new BigDecimal(tokens[2]),
                            5);
                }
                inventory.put(tokens[0], product);
            }

        } catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }

        return new VendMachine(inventory);
    }

    public static Map<String, Vendable> loadVendingMachine (
            int defaultQuantity, String filename) throws DataAccessException {
        try(Scanner scanner = new Scanner(new FileReader(filename))) {
            return loadVendingMachine(defaultQuantity, scanner);
        } catch (IOException e){
            Logger.logTimeStampedMessage(e.getMessage());
            throw new DataAccessException("Error loading " + filename);
        }
    }

    public static Map<String, Vendable> loadVendingMachine (
            int defaultQuantity, File file) throws DataAccessException {
        try(Scanner scanner = new Scanner(file)) {
            return loadVendingMachine(defaultQuantity, scanner);
        } catch (IOException e){
            Logger.logTimeStampedMessage(e.getMessage());
            throw new DataAccessException("Error loading " + file.getAbsolutePath());
        }
    }

    private static Map<String, Vendable> loadVendingMachine (
            int defaultQuantity, Scanner scanner) throws IOException {
       Map<String, Vendable> vendingMachine = new HashMap<>();
       while (scanner.hasNextLine()){
           String line = scanner.nextLine();
           String[] fields = line.split("\\|");
           String code = fields[0];
           String name = fields[1];
           Money price = new Money(Double.parseDouble(fields[2]));
           ItemType itemType = ItemType.getItemType(fields[3]);
           int quanity = defaultQuantity;
           Vendable item = null;
           switch(itemType){
               case CHIP:
                   item = new Chip(name, price, quanity, code);
                   break;
               case CANDY:
                   item = new Candy(name, price, quanity, code);
                   break;
               case DRINK:
                   item = new Drink(name, price, quanity, code);
                   break;
               case GUM:
                   item = new Gum(name, price, quanity, code);
           }
           if (item != null){
               vendingMachine.put(item.getCode(), item);
           }
       }
       return vendingMachine;
    }
}
