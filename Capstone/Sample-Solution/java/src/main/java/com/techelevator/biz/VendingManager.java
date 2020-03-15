package com.techelevator.biz;

import com.techelevator.data.Logger;
import com.techelevator.entity.Item;
import com.techelevator.entity.Money;
import com.techelevator.entity.Vendable;
import com.techelevator.entity.VendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class VendingManager {

    private VendingMachine vendingMachine;

    private Money customerBalance;

    private List<Vendable> customerBasket;

    private Vendable currentSelectedItem;

    public VendingManager(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
        this.customerBalance = new Money(0);
    }

    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public List<Vendable> getInventoryItems(){
        return vendingMachine.getInventoryItems();
    }

    public Money getCustomerBalance() {
        return customerBalance;
    }

    public List<Vendable> getCustomerBasket() {
        return customerBasket;
    }

    public List<Vendable> getSortedVendingInventory() {

        return vendingMachine.getSortedVendingInventory();
    }

    public void addMoneyToCustomerBalance(Money amount){
        customerBalance = customerBalance.add(amount);
        Logger.logTimeStampedMessage(
                "Money added : " + amount + " : " + customerBalance);
    }

    public void addMoneyToCustomerBalance(String amountStr){
        addMoneyToCustomerBalance(new Money(amountStr));
    }

    public void addMoneyToCustomerBalance(int amountInt){
        addMoneyToCustomerBalance(new Money(amountInt));
    }

    public String getChange(){
        String result = customerBalance.coins();
        Logger.logTimeStampedMessage(
                "Change returned : " + result);
        return result;
    }

    public String addSelectedItem(String code){
        Vendable item = vendingMachine.getItem(code);
        if (item == null){
            return "Not a valid code.";
        }
        return processSelectedItem(item);
    }

    public String addSelectedItem(int index){
        List<Vendable> sortedInventory = vendingMachine.getSortedVendingInventory();
        if ( (sortedInventory == null) ||
                (index < 0) || (index > sortedInventory.size()) )
            return null;

        Vendable selectedItem = sortedInventory.get(index);
        if (selectedItem == null)
            return null;

        return processSelectedItem(selectedItem);
    }

    private String processSelectedItem(Vendable selectedItem){
        if (selectedItem.getQuantity() < 1) {
            return "Out of Stock";
        }
        if (!customerBalance.isEnough((selectedItem.getPrice()))){
            return "Insufficient Funds";
        }

        customerBalance = customerBalance.subtract(selectedItem.getPrice());
        selectedItem.setQuantity(selectedItem.getQuantity()-1);

        if (customerBasket == null){
            customerBasket = new ArrayList<>();
        }
        customerBasket.add(selectedItem);

        currentSelectedItem = selectedItem;

        Logger.logTimeStampedMessage(
                "Item selected : " + selectedItem + " : " + customerBalance);

        return selectedItem.toString() + " : " + ((Item)selectedItem).getDescription();
    }

    public Vendable getCurrentSelectedItem(){
        return currentSelectedItem;
    }

    public void setCurrentSelectedItemToNull(){
        currentSelectedItem = null;
    }

    public boolean isCustomerBalanceZero(){
        return customerBalance.isZero();
    }

    public void printSalesReport(){
        // iterate through customerBasket and write to file.
    }
}
