package com.techelevator.models;

import com.techelevator.models.Products;

import java.math.BigDecimal;

public class Drinks extends Products {

    public Drinks(String slotLocation, String itemName, BigDecimal price, String type) {
        super(slotLocation, itemName, price, type);
    }
}
