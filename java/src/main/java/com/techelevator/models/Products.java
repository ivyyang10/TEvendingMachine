package com.techelevator.models;

import java.math.BigDecimal;

public class Products {

    private String slotLocation;
    private String itemName;
    private BigDecimal price;
    private String type;
    private int amount = 6;

    public void setAmount() {
        this.amount -= 1;
    }

    public int getAmount() {
        return amount;
    }

    public Products(String slotLocation, String itemName, BigDecimal price, String type) {
        this.slotLocation = slotLocation;
        this.itemName = itemName;
        this.price = price;
        this.type = type;
    }

    public Products() {
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
