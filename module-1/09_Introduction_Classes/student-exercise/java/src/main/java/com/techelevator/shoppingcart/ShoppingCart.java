package com.techelevator.shoppingcart;

public class ShoppingCart {
    private int totalNumberOfItems;
    private double totalAmountOwed;

    public ShoppingCart() {
        totalNumberOfItems = 0;
        totalAmountOwed = 0.0;
    }

    public int getTotalNumberOfItems() {

        return totalNumberOfItems;
    }

    public double getTotalAmountOwed() {

        return totalAmountOwed;
    }

    public double getAveragePricePerItem(){
        if(totalNumberOfItems == 0){
            return 0.0;
        }
        return (totalAmountOwed / totalNumberOfItems);
    }

    public void addItems(int totalNumberOfItems, double pricePerItem){
        this.totalNumberOfItems = totalNumberOfItems;
        this.totalAmountOwed = (pricePerItem * getTotalNumberOfItems());
    }

    public void empty(){
        totalNumberOfItems = 0;
        totalAmountOwed = 0;
    }

}
