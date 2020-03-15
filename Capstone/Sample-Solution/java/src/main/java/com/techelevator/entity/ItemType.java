package com.techelevator.entity;

public enum ItemType {

    CHIP("Chip"),
    CANDY("Candy"),
    DRINK("Drink"),
    GUM("Gum");

    private String value;

    private ItemType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public static ItemType getItemType(String value){
        String lowerValue = value.toLowerCase();
        switch (lowerValue){
            case "chip" : return CHIP;
            case "candy" : return CANDY;
            case "drink" : return DRINK;
            case "gum" : return GUM;
        }
        return null;
    }
}
